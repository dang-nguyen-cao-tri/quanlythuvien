package com.aureole.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.aureole.dto.MemberDTO;

@Service("baseserv")
public interface IMemberService {
	MemberDTO save(MemberDTO memberDTO);
	MemberDTO update(MemberDTO memberDTO);
	void delete(int id);
	List<MemberDTO> findAll();
	MemberDTO findOneMember(int id);
}
