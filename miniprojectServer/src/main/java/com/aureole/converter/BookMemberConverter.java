package com.aureole.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.aureole.dto.BookMemberDTO;
import com.aureole.entity.BookMemberEntity;

@Component
public class BookMemberConverter {

	public BookMemberEntity toEntity(BookMemberDTO dto) {
		BookMemberEntity entity = new BookMemberEntity();
		entity.setId(dto.getId());
		entity.setBorrowDate(dto.getBorrowDate());
		entity.setReturnDate(dto.getReturnDate());
		entity.setExpirationDate(dto.getExpirationDate());
		entity.setStatus(dto.getStatus());
		return entity;
	}

	public BookMemberDTO toDTO(BookMemberEntity entity) {
		BookMemberDTO dto = new BookMemberDTO();
		dto.setId(entity.getId());
		dto.setBorrowDate(entity.getBorrowDate());
		dto.setReturnDate(entity.getReturnDate());
		dto.setExpirationDate(entity.getExpirationDate());
		dto.setStatus(entity.getStatus());
		dto.setBookId(entity.getBook().getId());
		dto.setBookName(entity.getBook().getBookName());
		dto.setMemberId(entity.getMember().getId());
		dto.setMemberName(entity.getMember().getName());
		return dto;
	}

	public List<BookMemberDTO> toListDTO(List<BookMemberEntity> bms) {
		List<BookMemberDTO> dtos = new ArrayList<>();
		for (BookMemberEntity s : bms) {
			BookMemberDTO k = new BookMemberDTO();
			k.setId(s.getId());
			k.setBorrowDate(s.getBorrowDate());
			k.setReturnDate(s.getReturnDate());
			k.setExpirationDate(s.getExpirationDate());
			k.setStatus(s.getStatus());
			k.setBookId(s.getBook().getId());
			k.setBookName(s.getBook().getBookName());
			k.setMemberId(s.getMember().getId());
			k.setMemberName(s.getMember().getName());
			dtos.add(k);
		}
		return dtos;
	}

	public BookMemberEntity toEntity(BookMemberDTO dto, BookMemberEntity entity) {
		entity.setId(dto.getId());
		entity.setBorrowDate(dto.getBorrowDate());
		entity.setReturnDate(dto.getReturnDate());
		entity.setExpirationDate(dto.getExpirationDate());
		entity.setStatus(dto.getStatus());
		return entity;
	}

}
