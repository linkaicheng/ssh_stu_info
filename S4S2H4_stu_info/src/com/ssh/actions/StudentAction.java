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

	// �����޸ĺ��ѧ����Ϣ
	public String save() {
		studentsService.updateStudent(student);
		return "save_success";
	}

	// �޸�ѧ��
	public String modify() {
		// ��ȡѧ�����
		String sid = request.getParameter("sid");
		Student student = studentsService.queryStudentBySid(sid);
		session.setAttribute("modify_students", student);
		return "modify_success";
	}

	// ��ѯѧ��
	public String query() {
		List<Student> list = studentsService.queryAllStudents();
		if (list != null && list.size() > 0) {
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}

	// ɾ��ѧ��
	public String delete() {
		String sid = request.getParameter("sid");
		studentsService.deleteStudent(sid);
		return "delete_success";
	}

	// ���ѧ��
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
