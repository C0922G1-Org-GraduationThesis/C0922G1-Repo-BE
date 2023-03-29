package com.example.be.service;

import com.example.be.dto.IDocumentDto;
import com.example.be.model.Document;
import com.example.be.repository.IDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DocumentService implements  IDocumentService{

    @Autowired
    private IDocumentRepository documentRepository;

    @Override
    public Page<IDocumentDto> findAllDocumentDto(String keySearch1, Pageable pageable) {
        return documentRepository.findAllDocumentDto(keySearch1, pageable);
    }

    @Override
    public void removeDocument(Long id) {
        documentRepository.removeDocument(id);
    }

    @Override
    public Document getDocumentFindById(Long id) {
        return documentRepository.getDocumentFindById(id);
    }

    @Override
    public void addDocument(String documentDescribe, String documentFile, String documentName) {
        documentRepository.addDocument(documentDescribe,documentFile,documentName);
    }


}
