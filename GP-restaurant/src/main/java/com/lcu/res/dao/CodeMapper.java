package com.lcu.res.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lcu.res.po.Code;

@Repository
@Mapper
public interface CodeMapper {

	Code selectBytypeAndrn(Code code);

	void updateBytype(Code code);

	void createCode(Code code);

}
