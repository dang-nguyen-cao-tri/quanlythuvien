package com.aureole.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aureole.converter.CategoryConverter;
import com.aureole.dto.CategoryDTO;
import com.aureole.entity.CategoryEntity;
import com.aureole.repository.CategoryRepository;
import com.aureole.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> oldEntitys = categoryRepository.findAllCategory();
		return categoryConverter.toListDTO(oldEntitys);
	}

}
