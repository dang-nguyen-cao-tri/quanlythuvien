package com.aureole.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.aureole.dto.BookDTO;
import com.aureole.report.CreateExcelBook;
import com.aureole.report.GeneratePdfReport;
import com.aureole.service.IBookService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController // @Controller /*biến 1 java class thông thường thành API trong restful web
				// service*/
public class BookAPI {

	// @Autowired để nhúng INewService vào lớp này, và tâng Service phải có @service
	// để đánh dấu
	@Autowired
	private IBookService bookService;
	/*
	 * @PostMapping(value = "/new") //them mot bai viet neu dung POST; method =
	 * RequestMethod.POST ; ''@PostMapping = RESTMAPPING + METHOD
	 * 
	 * //@ResponseBody //de tra du lieu ra cliend ve kieu JSON public NewDTO
	 * createNew(@RequestBody NewDTO model) { // @RequestBody nhan data tu client,
	 * model chứa data, return model; }
	 */
	
	@GetMapping(value ="/printreport")
	public ResponseEntity<InputStreamResource> downloadBookExel() throws IOException {

		List<BookDTO> books = bookService.findAll();
		ByteArrayInputStream in = CreateExcelBook.WriteExcel(books);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=books.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
	@GetMapping(value ="/printreportPDF", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> downloadBookPDF() throws IOException {

		List<BookDTO> books = bookService.findAll();
		ByteArrayInputStream in = GeneratePdfReport.bookReport(books);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=books.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(in));
	}
	@GetMapping(value ="/book/name/{n}")
	public List<BookDTO> searchBookByName(@PathVariable("n") String n) {
		return bookService.findBookByName(n);
	}
	
	@GetMapping(value ="/book")
	public List<BookDTO> getAllBook(){
		return bookService.findAll();
	}
	
	@GetMapping(value ="/book/{id}")
	public BookDTO getBookByID(@PathVariable("id") int id){
		//model.setId(id);
		return bookService.findOneBook(id);
	}
	
	@PostMapping(value = "/book") 
	public BookDTO createBook(@RequestBody BookDTO model) { 
		return bookService.save(model);
	}

	@PutMapping(value = "/book/{id}")
	public BookDTO updateBook(@RequestBody BookDTO model, @PathVariable("id") int id) { //get giá trị của tham số id
		model.setId(id);
		return bookService.update(model);
	}

	@DeleteMapping(value = "/book/{id}")
	public void deleteBook( @PathVariable("id") int id) { 
		bookService.delete(id);
	}

	/*@DeleteMapping(value = "/book")
	public void deleteBook(@RequestBody int[] ids) { //mảng ids chứa nhiều id kiểu int
		bookService.delete(ids);
	}*/
}
