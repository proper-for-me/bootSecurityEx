package com.ach.login.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ach.CommonContrller;
import com.ach.login.dto.Member;
import com.ach.login.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController extends CommonContrller{


	@Autowired
	LoginService loginService;
	
	
	@GetMapping(value = "/main")
	public String mainProcess() {
//		log.debug("mainProcess " + System.getenv().toString());
//		Member member = new Member();
//		member.setMbrName("leee");
//		ModelAndView mv = new ModelAndView();
//		mv.addObject(member);
//		mv.setViewName("main.html");
		return "main.html";
	}


	@PostMapping(value = "/mainJson")
	public String mainJson(@RequestBody Member member, Model model) {
		log.debug("mainJson " + System.getenv().toString());
//		Member member = new Member();
//		member.setMbrName(name);
		loginService.saveMember(member);
		model.addAttribute(member);
		return "/views/mainJson";
	}
}
