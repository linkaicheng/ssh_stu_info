package com.ssh.dao;

import java.util.List;

import com.ssh.entities.Student;

public class StudentsDao extends BaseDao {
	/**
	 * ��ѯ����ѧ������
	 * 
	 * @return
	 */
	public List<Student> queryAllStudents() {
		String hql = "FROM Student";
		return getSession().createQuery(hql).list();
	}

	/**
	 * ����ѧ����Ų�ѯѧ������
	 * 
	 * @param sid
	 * @return
	 */
	public Student queryStudentBySid(String sid) {

		return (Student) getSession().get(Student.class, sid);
	}

	/**
	 * �޸�ѧ������
	 * 
	 * @param student
	 * @return
	 */
	public boolean updateStudent(Student student) {
		getSession().update(student);
		return true;
	}

	/**
	 * ����ѧ�����ɾ��һ��ѧ��
	 * 
	 * @param sid
	 * @return
	 */
	public boolean deleteStudent(String sid) {
		Student student = (Student) getSession().get(Student.class, sid);
		getSession().delete(student);
		return true;
	}

	// ��ѯѧ�����е����ѧ��
	public String queryMaxSid() {
		String hql = "select max(sid) from Student";
		return (String) getSession().createQuery(hql).uniqueResult();
	}

}
