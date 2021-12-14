package com.OEMarket.repository;

import org.springframework.data.repository.CrudRepository;

import com.OEMarket.dto.MemberDTO;

public interface MemberRepository extends CrudRepository<MemberDTO, Long> {

}
