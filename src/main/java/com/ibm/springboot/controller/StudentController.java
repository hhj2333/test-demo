package com.ibm.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ibm.springboot.bean.JsonResult;
import com.ibm.springboot.bean.Student;
import com.ibm.springboot.mapper.StudentMapper;

@RestController
public class StudentController {
	@Autowired
	private StudentMapper studentMapper;
	@GetMapping("/student/getscore/{id}")
	public JsonResult<Student> getScore(@PathVariable("id") Integer id) {
		Student student = new Student();
		student = studentMapper.getMyScore(id);
		if(student==null) {
			return new JsonResult(404,"没找到该生相关信息");
		}
		student.setId(id);
		return new JsonResult<>(student,"查询成功");
	}
	
}
