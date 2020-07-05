package com.ach;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CommonContrller {

	private Logger logging = log;
	public void commMain() {
		log.debug("commonMain");
		
	}
	
}
