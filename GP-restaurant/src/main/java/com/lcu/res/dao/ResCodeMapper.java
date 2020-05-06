package com.lcu.res.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lcu.res.po.ResCode;

@Repository
@Mapper
public interface ResCodeMapper {

	ResCode selectBytype(String codeType);

	void update(ResCode rcode);

}
