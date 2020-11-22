package com.ibm.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.bean.AddScoreJson;
import com.ibm.springboot.bean.BlurFindJson;
import com.ibm.springboot.bean.BlurFindJson;
import com.ibm.springboot.bean.JsonResult;
import com.ibm.springboot.bean.Student;
import com.ibm.springboot.bean.Teacher;
import com.ibm.springboot.mapper.TeacherMapper;

@RestController
@RequestMapping("teacher")
public class TeacherController { 
	@Autowired
	TeacherMapper teacherMapper;
	//获取所有学生信息
	@GetMapping("getallstumess")
	public JsonResult<List<Student>> getAllStudentMess() {
		return new JsonResult<>(teacherMapper.getAllStuMess(),"获取成功");
	}
	@GetMapping("alterscore")
	public JsonResult<Student> alterScore(@RequestBody Student student){
		if(teacherMapper.alterScore(student)) {
			return new JsonResult(200,"修改成功");
		}
		return new JsonResult(404,"修改失败");
		
	}
	@GetMapping("find")
	public JsonResult<List<Student>> findByStuNo(@RequestBody BlurFindJson blurFindJson){
		int type = blurFindJson.getType();
		if(type==1) {
			return new JsonResult<>(teacherMapper.findByStuNo(blurFindJson),"查询成功");
		}else if(type==2){
			return new JsonResult<>(teacherMapper.findByStuName(blurFindJson),"查询成功");
		}else if(type==3) {
			return new JsonResult<>(teacherMapper.findByStuClass(blurFindJson),"查询成功");
		}else {
			return new JsonResult(404,"请选择查询类型");
		}
		
	}
}
