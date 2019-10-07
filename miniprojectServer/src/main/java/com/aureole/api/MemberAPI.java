package com.aureole.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.aureole.dto.MemberDTO;
import com.aureole.service.IMemberService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MemberAPI {
	@Autowired
	private IMemberService memberService;

	@GetMapping(value ="/member")
	public List<MemberDTO> getAllMember(){
		return memberService.findAll();
	}
	
	@GetMapping(value ="/member/{id}")
	public MemberDTO getBookByID(@PathVariable("id") int id){
		return memberService.findOneMember(id);
	}
	
	@PostMapping(value = "/member") 
	public MemberDTO createMember(@RequestBody MemberDTO model) { 
		return memberService.save(model);
	}
	
	@PutMapping(value = "/member/{id}")
	public MemberDTO updateBook(@RequestBody MemberDTO model, @PathVariable("id") int id) {
		model.setId(id);
		return memberService.update(model);
	}

	@DeleteMapping(value = "/member/{id}")
	public void deleteMember(@PathVariable("id") int id) {
		memberService.delete(id);
	}
}
