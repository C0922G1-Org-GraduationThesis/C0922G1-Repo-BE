package com.example.be.repository;
import com.example.be.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface ITeamRepository extends JpaRepository<Team, Long> {

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    @Query(value = "select * from team", countQuery = "select * from team", nativeQuery = true)
    Page<Team> findPagePro(Pageable pageable);

}
