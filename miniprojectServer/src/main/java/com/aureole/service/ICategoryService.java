package com.aureole.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.aureole.dto.CategoryDTO;

@Service("baseserv")
public interface ICategoryService {
	List<CategoryDTO> findAll();
}
