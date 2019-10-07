package com.aureole.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aureole.dto.BookMemberDTO;
import com.aureole.service.IInfoService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InfoAPI {
	@Autowired
	private IInfoService infoService;

	@GetMapping(value ="/info")
	public List<BookMemberDTO> getAllInfo(){
		return infoService.findAll();
	}
	
	@GetMapping(value ="/info/{id}")
	public BookMemberDTO getInfoByID(@PathVariable("id") int id){
		return infoService.findOneInfo(id);
	}
	
	@PostMapping(value = "/info") 
	public BookMemberDTO createInfo(@RequestBody BookMemberDTO model) { 
		return infoService.save(model);
	}
	
	@PutMapping(value = "/info/{id}")
	public BookMemberDTO updateBook(@RequestBody BookMemberDTO model, @PathVariable("id") int id) {
		model.setId(id);
		return infoService.update(model);
	}

	@DeleteMapping(value = "/info/{id}")
	public void deleteInfo(@PathVariable("id") int id) {
		infoService.delete(id);
	}
}
