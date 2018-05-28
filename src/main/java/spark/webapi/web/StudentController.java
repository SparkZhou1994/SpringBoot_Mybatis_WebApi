package spark.webapi.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spark.webapi.entity.Student;
import spark.webapi.service.StudentService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/liststudent", method = RequestMethod.GET)
	private Map<String, Object> listArea() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Student> list = new ArrayList<Student>();
		// 获取区域列表
		list = studentService.getStudentList();
		modelMap.put("studentList", list);
		return modelMap;
	}


	@RequestMapping(value = "/getstudentbyid", method = RequestMethod.GET)
	private Map<String, Object> getStudentByNo(Integer stuNo) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		Student student = studentService.getStudentByNo(stuNo);
		modelMap.put("student", student);
		return modelMap;
	}

	@RequestMapping(value = "/addstudent", method = RequestMethod.POST)
	private Map<String, Object> addArea(@RequestBody Student student)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 添加区域信息
		modelMap.put("success", studentService.addStudent(student));
		return modelMap;
	}

	@RequestMapping(value = "/modifystudent", method = RequestMethod.POST)
	private Map<String, Object> modifyArea(@RequestBody Student student)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", studentService.modifyStudent(student));
		return modelMap;
	}

	@RequestMapping(value = "/removestudent", method = RequestMethod.GET)
	private Map<String, Object> removeArea(Integer stuNo) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", studentService.deleteStudent(stuNo));
		return modelMap;
	}

}
