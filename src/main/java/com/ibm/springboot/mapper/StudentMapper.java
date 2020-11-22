package com.ibm.springboot.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ibm.springboot.bean.Student;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import sun.security.util.Password;

public interface StudentMapper {
	//学生登录
	@Select("select password from student where username=#{username}")
	public String login(String username);
	//返回登录成功的学生信息
	@Select("select id,username,stuclass,stuname,stuno from student where username=#{username}")
	public Student returnLoginStudenMess(String username);
	//查询成绩
	@Select("select stuname,password,stuno,score from student where id=#{id}")
	public Student getMyScore(int id);
	//修改密码
	@Update("update student set password=#{password} where id=#{id}")
	public boolean alterPassword(Student student);
	//匹配原密码是否一致
	@Select("select password from student where id=#{id}")
	public String selectOldPass(int id);
	
}
