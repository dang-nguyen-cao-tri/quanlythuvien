package com.aureole.service.impl;

import java.sql.Timestamp;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aureole.converter.BookConverter;
import com.aureole.dto.BookDTO;
import com.aureole.entity.BookEntity;
import com.aureole.entity.CategoryEntity;
import com.aureole.repository.BookRepository;
import com.aureole.repository.CategoryRepository;
import com.aureole.service.IBookService;

@Service("baseServ")
public class BookService implements IBookService {
	// để nhúng repository vào service dùng @autowired
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookConverter bookConverter;
	
	@Transactional
	@Override
	public BookDTO save(BookDTO bookDTO) {
		bookDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryEntity categoryEntity = categoryRepository.findOneById(bookDTO.getCategoryId());
//		CategoryEntity categoryEntity = categoryRepository.findOneByName(bookDTO.getCategoryName());
		BookEntity bookEntity = bookConverter.toEntity(bookDTO);   //*
		bookEntity.setCategoryEntity(categoryEntity);
		bookEntity = bookRepository.save(bookEntity); // lưu xuống trả về 1 entity, nên ta overwrite newEntity ở *
		return bookConverter.toDTO(bookEntity);
	}

	@Transactional
	@Override
	public BookDTO update(BookDTO bookDTO) {
		BookEntity oldBookEntity = bookRepository.findOne(bookDTO.getId());
		CategoryEntity categoryEntity = categoryRepository.findOneById(bookDTO.getCategoryId());
		BookEntity bookEntity = bookConverter.toEntity(bookDTO, oldBookEntity); //đè mới lên cũ findOneByName(bookDTO.getCategoryName());
		bookEntity.setCategoryEntity(categoryEntity);
		bookEntity = bookRepository.save(bookEntity);
		return bookConverter.toDTO(bookEntity);
	}

	@Transactional
	@Override
	public void delete(int id) {
			bookRepository.deleteOneById(id);
		}

	
	@Override
	public List<BookDTO> findAll() {
		List<BookEntity> oldEntitys = bookRepository.findAll();
		return bookConverter.toListDTO(oldEntitys);
	}

	@Override
	public BookDTO findOneBook(int id) {
		BookEntity oldEntity = bookRepository.findOneByID(id);
		return bookConverter.toDTO(oldEntity);
	}

	@Override
	public List<BookDTO> findBookByName(String name) {
		List<BookEntity> oldEntitys = bookRepository.findBookByName(name);
		return bookConverter.toListDTO(oldEntitys);
	}

	

}
