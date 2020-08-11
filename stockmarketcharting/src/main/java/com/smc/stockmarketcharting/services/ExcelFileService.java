package com.smc.stockmarketcharting.services;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smc.stockmarketcharting.model.StockPrice;
import com.smc.stockmarketcharting.repository.StockPriceRepository;

@Service
public class ExcelFileService {
	
	
	@Autowired
	StockPriceRepository stockPriceRepository;

	public ResponseEntity<String> handleFileUpload(MultipartFile file) {
	String message="";
    try {
       try {
       	//FileInputStream fis = new FileInputStream(file);
       	XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
       	XSSFSheet sheet = wb.getSheetAt(0);
       	Iterator<Row> itr = sheet.iterator();
       	Row row = itr.next();
       	row = itr.next();
       	Iterator<Cell> cellIterator = row.cellIterator();
       	Cell cell = cellIterator.next();
       	
       	while ((cell.getStringCellValue())!=null)              
       	{
       	StockPrice s1=new StockPrice();
       	
      // 	Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
       	//while (cellIterator.hasNext())   
       	//{ 
       	   // Cell cell = cellIterator.next();  
       		s1.setCompanycode(cell.getStringCellValue());
       		System.out.println("code: "+cell.getStringCellValue());
       		
       		Cell cell1 = cellIterator.next();
       		s1.setStockexchange(cell1.getStringCellValue());
       		System.out.println("exchange "+cell1.getStringCellValue());
       		
       		Cell cell2 = cellIterator.next();
       		s1.setCurrentprice(cell2.getNumericCellValue());
       		System.out.println("price :"+cell2.getNumericCellValue());
       		
       		Cell cell3 = cellIterator.next();
       		//java.sql.Date sqlDate = new java.sql.Date( cell3.getDateCellValue() );
       		s1.setDate(cell3.getDateCellValue());
       		System.out.println("date :"+cell3.getDateCellValue());
       		
       		
       		
       		//java.util.Date date = cell.getDateCellValue();
       		//java.sql.Date sqlDate = new java.sql.Date(date);
//       		java.sql.Date sqlDate = new java.sql.Date( cell3.getDateCellValue() );
//       		s1.setDate(cell3.getDateCellValue());
       		
       //		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
       	//	Date d = dateFormat.parse(strTime);
      		
       		
       		
       		
       		
      		
       		
       		Cell cell4 = cellIterator.next();
       		
       		String t=cell4.getStringCellValue();
       		s1.setTime(t);
       		//DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
       	   // Date d = dateFormat.parse(t);
       	 System.out.println(t);
       	
       	    
    		//s1.setTime();
       		
//       		Cell cell4 = cellIterator.next();
//      		String t=cell4.getStringCellValue();
//      		s1.setTime(Time.valueOf(t));
//      		//System.out.println(cell.getDateCellValue());
//       		
      		
       		stockPriceRepository.save(s1);
       		
       		row = itr.next();
       		cellIterator = row.cellIterator();
       		cell = cellIterator.next();
       		
       		
       	//	Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
       	}
       }
       	catch(Exception e)  
       	{  
       		System.out.println("enteres");
       	//e.printStackTrace();
       		
       } 
       message="ok uploaded";
       return ResponseEntity.status(HttpStatus.OK).body(message);
    } catch (Exception e) {
       message = "Failed to upload! karthick Excel";
       return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
    }
	}
}