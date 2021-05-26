package com.chainsys.bookapp.model;

import java.time.LocalDate;

public class book {
	private int id;
	private String name;
	private LocalDate publishingdate;
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public book(int id, String name, LocalDate publishingdate) {
		super();
		this.id = id;
		this.name = name;
		this.publishingdate = publishingdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getPublishingdate() {
		return publishingdate;
	}
	public void setPublishingdate(LocalDate publishingdate) {
		this.publishingdate = publishingdate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publishingdate == null) ? 0 : publishingdate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		book other = (book) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publishingdate == null) {
			if (other.publishingdate != null)
				return false;
		} else if (!publishingdate.equals(other.publishingdate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", name=" + name + ", publishingdate=" + publishingdate + "]";
	}
	
}
