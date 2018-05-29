package spark.webapi.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spark.webapi.entity.Course;
import spark.webapi.service.CourseService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/course") 
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/getbyno", method = RequestMethod.GET)
	private Map<String, Object> getCourseByNo(Integer courseNo) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		Course course = courseService.selectByPrimaryKey(courseNo);
		modelMap.put("course",course);
		return modelMap;
	}
	
	@RequestMapping(value = "/getbynopath/{no}", method = RequestMethod.GET)
	private Map<String, Object> getCourseByNoPath(@PathVariable Integer no) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		Course course = courseService.selectByPrimaryKey(no);
		modelMap.put("course",course);
		return modelMap;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private Map<String, Object> addCourse(@RequestBody Course course)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 添加区域信息
		modelMap.put("success", courseService.insert(course));
		return modelMap;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	private Map<String, Object> modifyCourse(@RequestBody Course course)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", courseService.updateByPrimaryKey(course));
		return modelMap;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	private Map<String, Object> removeCourse(Integer courseNo) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", courseService.deleteByPrimaryKey(courseNo));
		return modelMap;
	}

}
