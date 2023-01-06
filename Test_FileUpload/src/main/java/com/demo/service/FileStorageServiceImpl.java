package com.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.demo.beans.FileDB;
import com.demo.dao.FileHandlingOp;

@Service
public class FileStorageServiceImpl implements FileStorageService{
	@Autowired
	FileHandlingOp fdao;
	
	@Override
	public void store(MultipartFile file, int empid, String fileName) {
		String fName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB fileDB;
		try {
			fileDB = new FileDB(fName, file.getContentType(), file.getBytes(), empid, fileName);
			fdao.save(fileDB);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
