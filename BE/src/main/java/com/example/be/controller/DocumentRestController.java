package com.example.be.controller;

import com.example.be.dto.DocumentDto;
import com.example.be.dto.IDocumentDto;
import com.example.be.model.Document;
import com.example.be.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/document")
public class DocumentRestController {


    @Autowired
    private IDocumentService documentService;

    @GetMapping("")
    public ResponseEntity<Page<IDocumentDto>> getAllAndSearchDocument(
            @RequestParam(defaultValue = "") String keySearch1,
            @PageableDefault(value = 5) Pageable pageable) {
        Page<IDocumentDto> documentDto = documentService.findAllDocumentDto(keySearch1, pageable);
        if (documentDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(documentDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Document> deleteDocument(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        documentService.removeDocument(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<Document> GetDocumentFindById(@PathVariable Long id) {
        Document document = documentService.getDocumentFindById(id);
        if (document == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @PostMapping("/create-document")
    public ResponseEntity createDocument(@RequestBody DocumentDto documentDto) {
        if (documentDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        documentService.addDocument(documentDto.getDocumentDescribe(),documentDto.getDocumentFile(),documentDto.getDocumentName());
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
