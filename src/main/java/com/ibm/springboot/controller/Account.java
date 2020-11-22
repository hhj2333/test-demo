package com.ibm.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.bean.Admin;
import com.ibm.springboot.bean.AlterPasswdJson;
import com.ibm.springboot.bean.JsonResult;
import com.ibm.springboot.bean.LoginJson;
import com.ibm.springboot.bean.ReturnMess;
import com.ibm.springboot.bean.Student;
import com.ibm.springboot.bean.Teacher;
import com.ibm.springboot.mapper.AdminMapper;
import com.ibm.springboot.mapper.StudentMapper;
import com.ibm.springboot.mapper.TeacherMapper;

@RestController
public class Account {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private AdminMapper adminMapper;


	@PostMapping("/login")
	public JsonResult studentLogin(@RequestBody LoginJson loginJson) {
		String type = loginJson.getType();
		String username = loginJson.getUsername();
		String password = loginJson.getPassword();
		System.out.println("ssss");
		System.out.println(username);
		if (username==null&&password==null) {
			return new JsonResult(404, "账号或密码为空");
		}
		if ("3".equals(type)) {
			if (password.equals(studentMapper.login(username))) {
				
				return new JsonResult<>(studentMapper.returnLoginStudenMess(username), "登录成功");
			} else {
				return new JsonResult(404, "账号或密码错误");
			}
		} else if ("6".equals(type)) {
			if (password.equals(teacherMapper.login(username))) {
				return new JsonResult<Teacher>(teacherMapper.returnLoginTeacherMess(username), "登录成功");
				
			} else {
				return new JsonResult(404, "账号或密码错误");
			}
		} else if ("9".equals(type)) {
			if (password.equals(adminMapper.login(username))) {
				return new JsonResult<Admin>(adminMapper.returnLoginAdminMess(username), "登录成功");
			} else {
				return new JsonResult(404, "账号或密码错误");
			}
		} else {
			return new JsonResult(404, "请选择登录类型");
		}

	}

	@PostMapping("/alterpassword")
	public JsonResult<Student> alterPassword(@RequestBody AlterPasswdJson alterPasswdJson) {
		int id = alterPasswdJson.getId();
		int type = alterPasswdJson.getType();
		String oldPassword = alterPasswdJson.getOldPassword();
		String newPassword = alterPasswdJson.getNewPassword();
		
		if (type == 1) {
			if (studentMapper.selectOldPass(id).equals(oldPassword)) {
				Student student = new Student();
				student.setPassword(newPassword);
				student.setId(id);
				if (studentMapper.alterPassword(student)) {
					return new JsonResult<>(200, "修改成功");
				} else {
					return new JsonResult<>(404, "修改失败");
				}
			}			
		} else if (type == 2) {
			if (teacherMapper.selectOldPass(id).equals(oldPassword)) {
				Teacher teacher = new Teacher();
				teacher.setId(id);
				teacher.setPassword(newPassword);
				if (teacherMapper.alterPassword(teacher)) {
					return new JsonResult<>(200, "修改成功");
				} else {
					return new JsonResult<>(404, "修改失败");
				}
			}
			
		}else {
			return new JsonResult(404,"请选择类型");
		}
		return new JsonResult(404,"原密码错误");
		
	}

}
