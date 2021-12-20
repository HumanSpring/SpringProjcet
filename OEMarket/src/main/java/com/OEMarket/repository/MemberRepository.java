package com.OEMarket.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.OEMarket.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberRepository {

	private static Map<Long, MemberDTO> store = new ConcurrentHashMap<Long, MemberDTO>();
	
	public MemberDTO save(Long id, MemberDTO member) {	
		member.setId(id);
		log.info("save : member = {} ", member);
		store.put(id, member);
		
		return member;
	}
	
	public MemberDTO findById(Long id) {
		return store.get(id);
	}
	
	public Optional<MemberDTO> findByEmail(String email){
		return this.findAll().stream()
					.filter(m -> m.getEmail().equals(email))
					.findFirst();
	}

	public List<MemberDTO> findAll(){
		return new ArrayList<MemberDTO>(store.values());
	}
	
	/* 임시 회원 추가 */
	@PostConstruct
	public void init() {
		MemberDTO member1 = new MemberDTO();
		member1.setEmail("testemail01");
		member1.setPassword("testpassword01");
		member1.setName("testname01");
		member1.setNickname("testnickname01");
		member1.setMemberRole("USER");
		
		save((long) 1, member1);
		
		MemberDTO member2 = new MemberDTO();
		member2.setEmail("testemail02");
		member2.setPassword("testpassword02");
		member2.setName("testname02");
		member2.setNickname("testnickname02");
		member2.setMemberRole("ADMIN");
		
		save((long) 2, member2);
	}
	
}
