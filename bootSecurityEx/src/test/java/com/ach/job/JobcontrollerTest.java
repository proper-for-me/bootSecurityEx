package com.ach.job;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.server.Encoding;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ach.login.dto.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.util.ContentTypeUtil;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class JobcontrollerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	//@Test
	void testMainProcess() throws Exception {
		
		Member member = new Member();
		member.setMbrName("최군");
		mockMvc.perform(post("/main")
				)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("최군"))
		.andDo(print());
		
	}
	
	@Test
	void mainJson() throws Exception {
		 String content = objectMapper.writeValueAsString(new Member("최군"));
		mockMvc.perform(post("/mainJson")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content))
		.andExpect(status().isOk())
	//	.andExpect(jsonPath("$.mbrName").value("최군"))
		.andDo(print());
		
	}
	
	@Test
	public void testCaching() throws Exception {
		IntStream.range(0, 10).limit(10).forEach((index)->{ 
			try {
				mockMvc.perform(get("/cacheing"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Test
	void jsonException() throws Exception {
		 String content = objectMapper.writeValueAsString(new Member("ABC"));
		mockMvc.perform(post("/jsonException")
				.characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
				.content(content))
		.andExpect(status().isOk())
		.andDo(print());
	}
}
	
