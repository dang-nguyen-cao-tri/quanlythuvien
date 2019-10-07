package com.aureole.service.impl;

import java.sql.Timestamp;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aureole.converter.BookMemberConverter;
import com.aureole.dto.BookMemberDTO;
import com.aureole.entity.BookEntity;
import com.aureole.entity.BookMemberEntity;
import com.aureole.entity.MemberEntity;
import com.aureole.repository.BookMemberRepository;
import com.aureole.repository.BookRepository;
import com.aureole.repository.MemberRepository;
import com.aureole.service.IInfoService;

@Service
public class InfoService implements IInfoService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private BookMemberRepository bookMemberRepository;
	@Autowired
	private BookMemberConverter bookMemberConverter;

	@Override
	public BookMemberDTO save(BookMemberDTO bookMemberDTO) {
     	 
		bookMemberDTO.setBorrowDate(new Timestamp(System.currentTimeMillis()));
		BookEntity bookEntity = bookRepository.findOneByID(bookMemberDTO.getBookId());
		MemberEntity memberEntity = memberRepository.findMemberByID(bookMemberDTO.getMemberId());
		BookMemberEntity bookMemberEntity = bookMemberConverter.toEntity(bookMemberDTO);   //*
		bookMemberEntity.setBook(bookEntity);
		bookMemberEntity.setMember(memberEntity);
		bookMemberEntity = bookMemberRepository.save(bookMemberEntity); 
		return bookMemberConverter.toDTO(bookMemberEntity); 
	}

	
	@Override
	public BookMemberDTO update(BookMemberDTO bookMemberDTO) {
				
		BookMemberEntity oldEntity = bookMemberRepository.findInfoByID(bookMemberDTO.getId());
		BookEntity bookEntity =bookRepository.findOneByID(bookMemberDTO.getBookId());
		MemberEntity memberEntity =memberRepository.findMemberByID(bookMemberDTO.getMemberId());
		BookMemberEntity bookMemberEntity = bookMemberConverter.toEntity(bookMemberDTO, oldEntity);
		bookMemberEntity.setBook(bookEntity);
		bookMemberEntity.setMember(memberEntity);
		bookMemberEntity = bookMemberRepository.save(bookMemberEntity);
		
		return bookMemberConverter.toDTO(bookMemberEntity);
	}

	@Transactional
	@Override
	public void delete(int id) {
			bookMemberRepository.deleteOneById(id);
		}

	
	@Override
	public List<BookMemberDTO> findAll() {
		List<BookMemberEntity> oldEntitys = bookMemberRepository.findAll();
		return bookMemberConverter.toListDTO(oldEntitys);
	}

	@Override
	public BookMemberDTO findOneInfo(int id) {
		BookMemberEntity oldEntity = bookMemberRepository.findInfoByID(id);
		return bookMemberConverter.toDTO(oldEntity);
	}

}
