package com.ssh.service;

import java.util.List;

import com.ssh.dao.StudentsDao;
import com.ssh.entities.Student;

public class StudentsService {
	private StudentsDao studentsDao;

	public void setStudentsDao(StudentsDao studentsDao) {
		this.studentsDao = studentsDao;
	}

	// ����ѧ����Ϣ
	public boolean updateStudent(Student student) {
		return studentsDao.updateStudent(student);
	}

	// ��ѯһ��ѧ��
	public Student queryStudentBySid(String sid) {
		return studentsDao.queryStudentBySid(sid);

	}

	// ��ѯȫ��ѧ��
	public List<Student> queryAllStudents() {
		return studentsDao.queryAllStudents();
	}

	// ɾ��ѧ��
	public boolean deleteStudent(String sid) {
		return studentsDao.deleteStudent(sid);
	}

	// ���һ��ѧ��
	public boolean addStudent(Student student) {
		student.setSid(getNewSid());
		studentsDao.getSession().save(student);
		return true;
	}

	// ����һ��ѧ��
	private String getNewSid() {
		String sid = studentsDao.queryMaxSid();
		if (sid == null || "".equals(sid)) {
			sid = "S0000001";
		} else {
			String temp = sid.substring(1);// ȡ����λ
			int i = Integer.parseInt(temp);
			i++;
			// ��ԭ���ַ���
			temp = String.valueOf(i);
			int len = temp.length();
			// �չ���λ
			for (int j = 0; j < 7 - len; j++) {
				temp = "0" + temp;
			}
			sid = "S" + temp;
		}
		return sid;
	}
}
