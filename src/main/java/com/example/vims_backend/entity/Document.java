package com.example.vims_backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.example.vims_backend.entity.enums.DocumentType;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    @ManyToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    @Enumerated(EnumType.STRING)
    private DocumentType docType;

    private String fileUrl;

    private LocalDateTime uploadedAt = LocalDateTime.now();

    // Constructors
    public Document() {}

	public Document(int documentId, Proposal proposal, DocumentType docType, String fileUrl, LocalDateTime uploadedAt) {
		super();
		this.documentId = documentId;
		this.proposal = proposal;
		this.docType = docType;
		this.fileUrl = fileUrl;
		this.uploadedAt = uploadedAt;
	}

	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", proposal=" + proposal + ", docType=" + docType + ", fileUrl="
				+ fileUrl + ", uploadedAt=" + uploadedAt + "]";
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	public DocumentType getDocType() {
		return docType;
	}

	public void setDocType(DocumentType docType) {
		this.docType = docType;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public LocalDateTime getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(LocalDateTime uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

}
