package com.ssh.service;

import java.util.List;

import com.ssh.dao.StudentsDao;
import com.ssh.entities.Student;

public class StudentsService {
	private StudentsDao studentsDao;

	public void setStudentsDao(StudentsDao studentsDao) {
		this.studentsDao = studentsDao;
	}

	// 更姓学生信息
	public boolean updateStudent(Student student) {
		return studentsDao.updateStudent(student);
	}

	// 查询一个学生
	public Student queryStudentBySid(String sid) {
		return studentsDao.queryStudentBySid(sid);

	}

	// 查询全部学生
	public List<Student> queryAllStudents() {
		return studentsDao.queryAllStudents();
	}

	// 删除学生
	public boolean deleteStudent(String sid) {
		return studentsDao.deleteStudent(sid);
	}

	// 添加一个学生
	public boolean addStudent(Student student) {
		student.setSid(getNewSid());
		studentsDao.getSession().save(student);
		return true;
	}

	// 生成一个学号
	private String getNewSid() {
		String sid = studentsDao.queryMaxSid();
		if (sid == null || "".equals(sid)) {
			sid = "S0000001";
		} else {
			String temp = sid.substring(1);// 取后七位
			int i = Integer.parseInt(temp);
			i++;
			// 还原成字符串
			temp = String.valueOf(i);
			int len = temp.length();
			// 凑够七位
			for (int j = 0; j < 7 - len; j++) {
				temp = "0" + temp;
			}
			sid = "S" + temp;
		}
		return sid;
	}
}
