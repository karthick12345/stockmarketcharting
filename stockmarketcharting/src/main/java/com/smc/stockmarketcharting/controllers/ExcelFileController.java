package com.smc.stockmarketcharting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smc.stockmarketcharting.services.ExcelFileService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/fileupload")
public class ExcelFileController {
	
	@Autowired
	ExcelFileService excelFileService;
	
	@PostMapping("/file")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
	return excelFileService.handleFileUpload(file);   
	}
}
