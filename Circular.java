package com.intranet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "Circular")
public class Circular {

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "CREATED_AT")
	private DateTime createdAt;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "FILE")
	private byte[] pdfFile;

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public byte[] getPdfFile() {
		return pdfFile;
	}

	@PrePersist
	public void prePersist() {
		final DateTime current = DateTime.now();
		createdAt = current;
		System.out.println("hello");
	}

	public void setCreatedAt(final DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPdfFile(final byte[] pdfFile) {
		this.pdfFile = pdfFile;
	}

}
