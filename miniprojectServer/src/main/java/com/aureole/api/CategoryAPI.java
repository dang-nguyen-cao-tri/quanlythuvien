package com.aureole.api;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aureole.dto.CategoryDTO;
import com.aureole.service.ICategoryService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryAPI {

	@Autowired
	private ICategoryService categoryService;

	@GetMapping(value ="/category")
	public List<CategoryDTO> getAllCategory(){
		return categoryService.findAll();
	}
	
}
