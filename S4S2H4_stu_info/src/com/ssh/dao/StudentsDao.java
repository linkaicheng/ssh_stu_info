package com.ssh.dao;

import java.util.List;

import com.ssh.entities.Student;

public class StudentsDao extends BaseDao {
	/**
	 * 查询所有学生资料
	 * 
	 * @return
	 */
	public List<Student> queryAllStudents() {
		String hql = "FROM Student";
		return getSession().createQuery(hql).list();
	}

	/**
	 * 根据学生编号查询学生资料
	 * 
	 * @param sid
	 * @return
	 */
	public Student queryStudentBySid(String sid) {

		return (Student) getSession().get(Student.class, sid);
	}

	/**
	 * 修改学生资料
	 * 
	 * @param student
	 * @return
	 */
	public boolean updateStudent(Student student) {
		getSession().update(student);
		return true;
	}

	/**
	 * 根据学生编号删除一个学生
	 * 
	 * @param sid
	 * @return
	 */
	public boolean deleteStudent(String sid) {
		Student student = (Student) getSession().get(Student.class, sid);
		getSession().delete(student);
		return true;
	}

	// 查询学生表中的最大学号
	public String queryMaxSid() {
		String hql = "select max(sid) from Student";
		return (String) getSession().createQuery(hql).uniqueResult();
	}

}
