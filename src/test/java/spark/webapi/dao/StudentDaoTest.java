package spark.webapi.dao;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import spark.webapi.entity.Student;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class StudentDaoTest {
	@Autowired
	private StudentDao studentDao;
	@Test
	@Ignore
	public void testAQueryStudent(){
		List<Student> studentList = studentDao.queryStudent();
		// 验证预期值和实际值是否相符
		assertEquals(4, studentList.size());
	}
	@Test
	public void testCQueryStudentByNo(){
		Student student=studentDao.queryStudentByNo(1);
		assertEquals("周炬辉", student.getStuName());
	}
	@Test
	@Ignore
	public void testBInsertStudent(){
		Student student=new Student();
		student.setStuName("Jack");
		student.setClassNo(1);
		student.setRole("u");
		//将该对象实例添加入库
		int effectedNum = studentDao.insertStudent(student);
		//检测影响行数
		assertEquals(1, effectedNum);
		//校验总数是否+1
		List<Student> studentList = studentDao.queryStudent();
		assertEquals(3, studentList.size());
	}
	@Test
	@Ignore
	public void testDUpdateStudent(){
		Student student=new Student();
		student.setStuNo(1521566);
		student.setStuName("Tom");
		student.setRole("u");
		//将该对象实例添加入库
		int effectedNum = studentDao.updateStudent(student);
		//检测影响行数
		assertEquals(1, effectedNum);
		//校验总数是否+1
		List<Student> studentList = studentDao.queryStudent();
		assertEquals(3, studentList.size());
	}
	@Test
	@Ignore
	public void testEDelectStudent(){
		int effectedNum = studentDao.deleteStudent(1521566);
		//检测影响行数
		assertEquals(1, effectedNum);
		//校验总数是否+1
		List<Student> studentList = studentDao.queryStudent();
		assertEquals(2, studentList.size());
	}
}
