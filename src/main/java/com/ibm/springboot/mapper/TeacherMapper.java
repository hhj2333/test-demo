package com.ibm.springboot.mapper;

import java.util.List;

import org.apache.catalina.LifecycleListener;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ibm.springboot.bean.BlurFindJson;
import com.ibm.springboot.bean.Student;
import com.ibm.springboot.bean.Teacher;

public interface TeacherMapper {
	//教师登录
	@Select("select password from teacher where username=#{username}")
	public String login(String username);
	//返回登录的教师信息
	@Select("select id,username,teaname from teacher where username=#{username}")
	public Teacher returnLoginTeacherMess(String username);
	//录入学生成绩
	
	public boolean addStudentScore();
	//修改密码
	@Update("update teacher set password=#{password} where id=#{id}")
	public boolean alterPassword(Teacher teacher);
	//匹配原密码是否一致
	@Select("select password from teacher where id=#{id}")
	public String selectOldPass(int id);
	//获取所有学生信息
	@Select("select id,stuno,stuname,stuclass,score from student")
	public List<Student> getAllStuMess();
	//修改成绩
	@Update("update student set score=#{score} where id=#{id}")
	public boolean alterScore(Student student);
	//按学号模糊查询
	@Select("select id,username,stuno,stuname,stuclass,score from student where stuno like '%' #{key} '%'")
	public List<Student> findByStuNo(BlurFindJson blurFindJson);
	//按名字查找
	@Select("select id,username,stuno,stuname,stuclass,score from student where stuname like '%' #{key} '%'")
	public List<Student> findByStuName(BlurFindJson blurFindJson);
	//按班级查找
	@Select("select id,username,stuno,stuname,stuclass,score from student where stuclass like '%' #{key} '%'")
	public List<Student> findByStuClass(BlurFindJson blurFindJson);
	
}
