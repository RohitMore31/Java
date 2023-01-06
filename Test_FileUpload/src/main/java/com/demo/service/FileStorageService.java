package com.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

	void store(MultipartFile file, int empid, String fileName);

}
