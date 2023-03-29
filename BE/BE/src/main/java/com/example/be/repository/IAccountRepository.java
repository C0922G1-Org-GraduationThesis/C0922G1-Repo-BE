package com.example.be.repository;

import com.example.be.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account,Long> {

    @Query(value = "select a.* from  account as a where a.email= :email", nativeQuery = true)
    Account findAccountByEmail(@Param("email") String email);

}
