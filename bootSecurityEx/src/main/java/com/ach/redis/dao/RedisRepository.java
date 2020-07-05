package com.ach.redis.dao;

import org.springframework.data.repository.CrudRepository;

import com.ach.redis.dto.Point;

public interface RedisRepository extends CrudRepository<Point, String>{
}
