package com.example.vims_backend.controller;

import com.example.vims_backend.entity.Document;
import com.example.vims_backend.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentRestController {

    @Autowired
    private DocumentService documentService;

//	Add a document
    @PostMapping
    public ResponseEntity<?> addDocument(@RequestBody Document document) {
        Document saved = documentService.addDocument(document);
        return (saved != null)
                ? ResponseEntity.ok(saved)
                : ResponseEntity.badRequest().body("Unable to save document.");
    }

//	Get all documents
    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        return ResponseEntity.ok(documentService.getAllDocuments());
    }

//	Get document by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getDocumentById(@PathVariable int id) {
        Document doc = documentService.getDocumentById(id);
        return (doc != null)
                ? ResponseEntity.ok(doc)
                : ResponseEntity.notFound().build();
    }

//	Get documents by proposal ID
    @GetMapping("/proposal/{proposalId}")
    public ResponseEntity<List<Document>> getByProposalId(@PathVariable int proposalId) {
        return ResponseEntity.ok(documentService.getDocumentsByProposalId(proposalId));
    }

//	Update document
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDocument(@PathVariable int id, @RequestBody Document document) {
        Document updated = documentService.updateDocument(id, document);
        return (updated != null)
                ? ResponseEntity.ok(updated)
                : ResponseEntity.notFound().build();
    }

//	Delete document
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable int id) {
        return documentService.deleteDocument(id)
                ? ResponseEntity.ok("Document deleted successfully.")
                : ResponseEntity.status(404).body("Document not found.");
    }
}
