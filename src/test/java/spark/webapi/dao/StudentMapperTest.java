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
public class StudentMapperTest {
	@Autowired
	private StudentMapper studentMapper;
	@Test
	public void testCQueryStudentByNo(){
		Student student=studentMapper.selectByPrimaryKey(1);
		assertEquals("周炬辉", student.getStuName());
	}
}
