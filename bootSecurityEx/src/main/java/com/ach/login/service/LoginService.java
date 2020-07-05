package com.ach.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ach.login.dao.LoginRepository;
import com.ach.login.dto.Member;

@Service("loginService")
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	public void saveMember(Member member) {
		Assert.notNull(member, " 사용자 정보가 없습니다.");
		loginRepository.save(member);
		selectMember();
	}

	public void selectMember() {
		List<Member> memList = loginRepository.findAll();
		memList.forEach(System.out::println);
	}

}
