package com.aureole.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.aureole.dto.BookDTO;

@Service
public interface IBookService {
	BookDTO save(BookDTO bookDTO);
	BookDTO update(BookDTO bookDTO);
	void delete(int id);
	List<BookDTO> findAll();
	BookDTO findOneBook(int id);
	List<BookDTO> findBookByName(String name);
}
