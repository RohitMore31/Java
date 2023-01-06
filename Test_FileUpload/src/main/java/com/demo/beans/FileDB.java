package com.demo.beans;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="javafileop")
public class FileDB {	
	@Id
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name="uuid",strategy="uuid2")
	private int id;
	private String name;
	private String type;
	@Lob
	private byte [] data;
	private int empid;
	private String filename;
	public FileDB() {
		super();
	}
	public FileDB(String name, String type, byte[] data, int empid, String filename) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
		this.empid = empid;
		this.filename = filename;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "FileDB [id=" + id + ", name=" + name + ", type=" + type + ", data=" + Arrays.toString(data) + ", empid="
				+ empid + ", filename=" + filename + "]";
	}
	
	
}
