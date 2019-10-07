package com.aureole.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.aureole.dto.BookMemberDTO;

@Service
public interface IInfoService {
	BookMemberDTO save(BookMemberDTO bookMemberDTO);
	BookMemberDTO update(BookMemberDTO bookMemberDTO);
	void delete(int id);
	List<BookMemberDTO> findAll();
	BookMemberDTO findOneInfo(int id);
}
