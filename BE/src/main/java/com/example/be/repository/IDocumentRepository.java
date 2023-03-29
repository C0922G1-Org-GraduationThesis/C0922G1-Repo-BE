package com.example.be.repository;

import com.example.be.dto.IDocumentDto;
import com.example.be.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IDocumentRepository extends JpaRepository<Document, Long> {

    @Query(value =
            "select d.document_id as documentId, " +
                    "        d.document_name as documentName, " +
                    "                    d.document_describe as documentDescribe, " +
                    "                    d.document_file as documentFile " +
                    "                    from `sprint1`.document d " +
                    "                    join teacher t on t.teacher_id = d.teacher_id " +
                    "                    where d.document_name like concat('%', :keySearch1, '%') " +
                    "                    and d.flag = false",
            countQuery =
                    "select d.document_id as documentId, " +
                            "        d.document_name as documentName, " +
                            "                    d.document_describe as documentDescribe, " +
                            "                    d.document_file as documentFile " +
                            "                    from `sprint1`.document d " +
                            "                    join teacher t on t.teacher_id = d.teacher_id " +
                            "                    where d.document_name like concat('%', :keySearch1, '%') " +
                            "                    and d.flag = true",
            nativeQuery = true
    )
    public Page<IDocumentDto> findAllDocumentDto(@Param("keySearch1") String keySearch1, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update document set flag=false where document_id = :id",
            countQuery = "update document set flag=true where document_id = :id"
            , nativeQuery = true)
    void removeDocument(@Param("id") Long id);

    @Query(value = "update document set flag=true where document_id = :id", nativeQuery = true)
    Document getDocumentFindById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value =
            "insert into document (document_describe, document_file, document_name)\n" +
            "value (:documentDescribe,:documentFile,:documentName)",
    nativeQuery = true)
    void addDocument(@Param("documentDescribe") String documentDescribe,@Param("documentFile") String documentFile, @Param("documentName")String documentName);


}
