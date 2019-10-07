package com.aureole.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.aureole.dto.MemberDTO;
import com.aureole.entity.MemberEntity;

@Component
public class MemberConverter {

	public MemberEntity toEntity(MemberDTO dto) {
		MemberEntity entity = new MemberEntity();

		entity.setName(dto.getName());
		entity.setBirthDay(dto.getBirthDay());
		entity.setEmail(dto.getEmail());
		entity.setGender(dto.getGender());
		entity.setCreatedDate(dto.getCreatedDate());
		return entity;
	}

	public MemberDTO toDTO(MemberEntity entity) {
		MemberDTO dto = new MemberDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setBirthDay(entity.getBirthDay());
		dto.setEmail(entity.getEmail());
		dto.setGender(entity.getGender());
		dto.setCreatedDate(entity.getCreatedDate());
		return dto;
	}

	public List<MemberDTO> toListDTO(List<MemberEntity> members) {
		List<MemberDTO> dtos = new ArrayList<>();
		for (MemberEntity s : members) {
			MemberDTO k = new MemberDTO();
			k.setId(s.getId());
			k.setName(s.getName());
			k.setBirthDay(s.getBirthDay());
			k.setEmail(s.getEmail());
			k.setGender(s.getGender());
			k.setCreatedDate(s.getCreatedDate());
			dtos.add(k);
		}
		return dtos;
	}

	public MemberEntity toEntity(MemberDTO dto, MemberEntity entity) {
		entity.setName(dto.getName());
		entity.setBirthDay(dto.getBirthDay());
		entity.setEmail(dto.getEmail());
		entity.setGender(dto.getGender());
		entity.setCreatedDate(dto.getCreatedDate());
		return entity;
	}

}
