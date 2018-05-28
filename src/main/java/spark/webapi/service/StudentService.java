package spark.webapi.service;

import java.util.List;
import spark.webapi.entity.Student;

public interface StudentService {
	List<Student> getStudentList();
	Student getStudentByNo(int stuNo);
	boolean addStudent(Student student);
	boolean modifyStudent(Student student);
	boolean deleteStudent(int stuNo);
}
