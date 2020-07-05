package com.ach.redis.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ach.redis.dto.Point;

@SpringBootTest
class RedisRepositoryTest {

	@Autowired
	private RedisRepository redisRepository;
	
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


    @Test
    @DisplayName(value = "기본 등록 조회")
    public void 기본_등록_조회기능() {
        //given
        String id = "jojoldu1111";
        LocalDateTime refreshTime = LocalDateTime.of(2018, 5, 26, 0, 0);
        Point point = Point.builder()
                .id(id)
                .amount(1000L)
                .refreshTime(refreshTime)
                .build();

        //when
        redisRepository.save(point);

        //then
        Point savedPoint = redisRepository.findById(id).get();
        assertThat(savedPoint.getAmount()).isEqualTo(1000L);
        assertThat(savedPoint.getRefreshTime()).isEqualTo(refreshTime);
    }
    @Test
    public void 수정기능() {
        //given
        String id = "jojoldu";
        LocalDateTime refreshTime = LocalDateTime.of(2018, 5, 26, 0, 0);
        redisRepository.save(Point.builder()
                .id(id)
                .amount(1000L)
                .refreshTime(refreshTime)
                .build());

        //when
        Point savedPoint = redisRepository.findById(id).get();
        savedPoint.refresh(2000L, LocalDateTime.of(2018,6,1,0,0));
        redisRepository.save(savedPoint);

        //then
        Point refreshPoint = redisRepository.findById(id).get();
        assertThat(refreshPoint.getAmount()).isEqualTo(2000L);
    }



}
