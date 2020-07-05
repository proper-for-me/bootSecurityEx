package com.ach.cache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ach.login.dao.LoginRepository;
import com.ach.login.dto.Member;

import jdk.internal.jline.internal.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CachService {

	@Autowired
	LoginRepository loginRepository;
	
	private int cnt = 0;
	
	@Cacheable(value = "memList")
	public List<Member> cacheMemberList() {
		log.debug("조회  1 호출" + cnt++);
		return loginRepository.findAll();
	};
}
