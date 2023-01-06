package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.beans.FileDB;

public interface FileHandlingOp extends JpaRepository<FileDB, Integer>{

}
