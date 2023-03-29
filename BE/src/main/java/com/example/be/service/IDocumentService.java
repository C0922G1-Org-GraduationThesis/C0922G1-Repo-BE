package com.example.be.service;

import com.example.be.dto.IDocumentDto;
import com.example.be.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IDocumentService {
    public Page<IDocumentDto> findAllDocumentDto( String keySearch1, Pageable pageable);

    void removeDocument(Long id);

    Document getDocumentFindById(Long id);

    void addDocument( String documentDescribe, String documentFile, String documentName);

}
