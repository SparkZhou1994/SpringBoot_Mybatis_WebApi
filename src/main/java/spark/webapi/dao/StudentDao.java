package spark.webapi.dao;

import java.util.List;

import spark.webapi.entity.Student;

public interface StudentDao {
	List<Student> queryStudent();
	Student queryStudentByNo(int stuNo);
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int stuNo);
}
