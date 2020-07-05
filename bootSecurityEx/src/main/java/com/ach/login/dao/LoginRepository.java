package com.ach.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ach.login.dto.Member;

public interface LoginRepository extends JpaRepository<Member, Integer>{

}
