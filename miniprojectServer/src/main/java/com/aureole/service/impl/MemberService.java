package com.aureole.service.impl;

import java.sql.Timestamp;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aureole.converter.MemberConverter;
import com.aureole.dto.MemberDTO;
import com.aureole.entity.MemberEntity;
import com.aureole.repository.MemberRepository;
import com.aureole.service.IMemberService;

@Service
public class MemberService implements IMemberService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberConverter memberConverter;

	@Transactional
	@Override
	public void delete(int id) {
			memberRepository.deleteOneById(id);
	}
	
	@Override
	public MemberDTO save(MemberDTO memberDTO) {
		memberDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		MemberEntity memberEntity = memberConverter.toEntity(memberDTO);
		memberEntity = memberRepository.save(memberEntity);
		return memberConverter.toDTO(memberEntity);
	}

	@Override
	public MemberDTO update(MemberDTO memberDTO) {
		MemberEntity oldMemberEntity = memberRepository.findOne(memberDTO.getId());
		MemberEntity memberEntity = memberConverter.toEntity(memberDTO, oldMemberEntity);
		memberEntity = memberRepository.save(memberEntity);
		return memberConverter.toDTO(memberEntity);
	}

	@Override
	public List<MemberDTO> findAll() {
		List<MemberEntity> oldEntitys = memberRepository.findAllMember();
		return memberConverter.toListDTO(oldEntitys);
	}

	@Override
	public MemberDTO findOneMember(int id) {
		MemberEntity oldEntity = memberRepository.findMemberByID(id);
		return memberConverter.toDTO(oldEntity);
	}
	
	
}
