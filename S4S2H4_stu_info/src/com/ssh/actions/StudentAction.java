package com.ssh.actions;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.ssh.entities.Student;
import com.ssh.service.StudentsService;

public class StudentAction extends SuperAction implements ModelDriven<Student> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentsService studentsService;

	public void setStudentsService(StudentsService studentsService) {
		this.studentsService = studentsService;
	}

	// 保存修改后的学生信息
	public String save() {
		studentsService.updateStudent(student);
		return "save_success";
	}

	// 修改学生
	public String modify() {
		// 获取学生编号
		String sid = request.getParameter("sid");
		Student student = studentsService.queryStudentBySid(sid);
		session.setAttribute("modify_students", student);
		return "modify_success";
	}

	// 查询学生
	public String query() {
		List<Student> list = studentsService.queryAllStudents();
		if (list != null && list.size() > 0) {
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}

	// 删除学生
	public String delete() {
		String sid = request.getParameter("sid");
		studentsService.deleteStudent(sid);
		return "delete_success";
	}

	// 添加学生
	public String add() {
		studentsService.addStudent(student);
		return "add_success";

	}

	private Student student;

	@Override
	public Student getModel() {
		student = new Student();
		return student;
	}

}
