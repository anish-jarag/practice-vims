package com.example.vims_backend.service;

import com.example.vims_backend.entity.Document;
import com.example.vims_backend.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

//	Add document
    public Document addDocument(Document document) {
        return documentRepository.save(document);
    }

//	Get all documents
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

//	Get document by ID
    public Document getDocumentById(int id) {
        return documentRepository.findById(id).orElse(null);
    }

//	Get all documents for a proposal
    public List<Document> getDocumentsByProposalId(int proposalId) {
        return documentRepository.findByProposal_ProposalId(proposalId);
    }

//	Update document
    public Document updateDocument(int id, Document updatedDocument) {
        Document existing = documentRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setDocType(updatedDocument.getDocType());
            existing.setFileUrl(updatedDocument.getFileUrl());
            existing.setProposal(updatedDocument.getProposal());
            existing.setUploadedAt(updatedDocument.getUploadedAt());
            return documentRepository.save(existing);
        }
        return null;
    }

//	Delete document
    public boolean deleteDocument(int id) {
        if (documentRepository.existsById(id)) {
            documentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
