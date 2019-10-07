package com.aureole.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.aureole.dto.CategoryDTO;
import com.aureole.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();

		entity.setTypeName(dto.getTypeName());
		entity.setCode(dto.getCode());
		entity.setId(dto.getId());
		
		return entity;
	}

	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		dto.setTypeName(entity.getTypeName());
		dto.setCode(entity.getCode());
		dto.setId(entity.getId());
		return dto;
	}

	public List<CategoryDTO> toListDTO(List<CategoryEntity> Categorys) {
		List<CategoryDTO> dtos = new ArrayList<>();
		for (CategoryEntity s : Categorys) {
			CategoryDTO k = new CategoryDTO();
			k.setId(s.getId());
			k.setTypeName(s.getTypeName());
			k.setCode(s.getCode());
			dtos.add(k);
		}
		return dtos;
	}

	public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity entity) {
		entity.setTypeName(dto.getTypeName());
		entity.setCode(dto.getCode());
		//entity.setId(dto.getId());
		return entity;
	}

}
