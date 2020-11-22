package com.ibm.springboot.mapper;

import org.apache.ibatis.annotations.Select;

import com.ibm.springboot.bean.Admin;

public interface AdminMapper {
	//学生登录
	@Select("select password from admin where username=#{username}")
	public String login(String username);
	//返回登录的管理员信息
	@Select("select id,username from admin where username=#{username}")
	public Admin returnLoginAdminMess(String username);	
}
