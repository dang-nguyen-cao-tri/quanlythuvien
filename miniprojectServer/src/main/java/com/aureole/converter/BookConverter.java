package com.aureole.converter;

import java.util.ArrayList;
import java.util.List;

//để convert DTO thành Entity để lưu database
//và ngược lại để trả về cho API
import org.springframework.stereotype.Component;
import com.aureole.dto.BookDTO;
import com.aureole.entity.BookEntity;

@Component
public class BookConverter {

	public BookEntity toEntity(BookDTO dto) {
		BookEntity entity = new BookEntity();
		entity.setId(dto.getId());
		entity.setBookName(dto.getBookName());
		entity.setAuthor(dto.getAuthor());
		entity.setQuantity(dto.getQuantity());
		entity.setPrice(dto.getPrice());
		entity.setPeriod(dto.getPeriod());
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setDescription(dto.getDescription());
		return entity;
	}

	public BookDTO toDTO(BookEntity entity) {
		BookDTO dto = new BookDTO();
		dto.setId(entity.getId());
		dto.setBookName(entity.getBookName());
		dto.setAuthor(entity.getAuthor());
		dto.setQuantity(entity.getQuantity());
		dto.setPrice(entity.getPrice());
		dto.setPeriod(entity.getPeriod());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setDescription(entity.getDescription());
		dto.setCategoryId(entity.getCategoryEntity().getId());
		dto.setCategoryName(entity.getCategoryEntity().getTypeName());
		return dto;
	}

	public List<BookDTO> toListDTO(List<BookEntity> books) {
		List<BookDTO> dtos = new ArrayList<>();
		for (BookEntity s : books) {
			BookDTO k = new BookDTO();
			k.setId(s.getId());
			k.setBookName(s.getBookName());
			k.setAuthor(s.getAuthor());
			k.setQuantity(s.getQuantity());
			k.setPrice(s.getPrice());
			k.setPeriod(s.getPeriod());
			k.setCreatedDate(s.getCreatedDate());
			k.setDescription(s.getDescription());
			k.setCategoryName(s.getCategoryEntity().getTypeName());
			k.setCategoryId(s.getCategoryEntity().getId());
			dtos.add(k);
		}
		return dtos;
	}

	public BookEntity toEntity(BookDTO dto, BookEntity entity) {
		entity.setId(dto.getId());
		entity.setBookName(dto.getBookName());
		entity.setAuthor(dto.getAuthor());
		entity.setQuantity(dto.getQuantity());
		entity.setPrice(dto.getPrice());
		entity.setPeriod(dto.getPeriod());
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setDescription(dto.getDescription());
		return entity;
	}

}
