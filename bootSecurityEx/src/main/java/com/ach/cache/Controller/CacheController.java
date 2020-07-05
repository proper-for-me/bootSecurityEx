package com.ach.cache.Controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ach.CommonContrller;
import com.ach.cache.service.CachService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CacheController extends CommonContrller{
	
	@Autowired
	CachService cashService;

	@GetMapping(value="/cacheing")
	public String cacheMain(){
		
		log.debug("처음 호출");
		
		cashService.cacheMemberList();
		
		log.debug("처음 호출 종료");
		
		return "views/cacheing";
	}
}
