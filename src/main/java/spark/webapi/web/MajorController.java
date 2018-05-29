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

import spark.webapi.entity.Major;
import spark.webapi.service.MajorService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/major") 
public class MajorController {
	@Autowired
	private MajorService majorService;
	
	@RequestMapping(value = "/getbyno", method = RequestMethod.GET)
	private Map<String, Object> getMajorByNo(Integer majorNo) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		Major major = majorService.selectByPrimaryKey(majorNo);
		modelMap.put("major",major);
		return modelMap;
	}
	
	@RequestMapping(value = "/getbynopath/{no}", method = RequestMethod.GET)
	private Map<String, Object> getMajorByNoPath(@PathVariable Integer no) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		Major major = majorService.selectByPrimaryKey(no);
		modelMap.put("major",major);
		return modelMap;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private Map<String, Object> addMajor(@RequestBody Major major)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 添加区域信息
		modelMap.put("success", majorService.insert(major));
		return modelMap;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	private Map<String, Object> modifyMajor(@RequestBody Major major)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", majorService.updateByPrimaryKey(major));
		return modelMap;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	private Map<String, Object> removeMajor(Integer majorNo) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", majorService.deleteByPrimaryKey(majorNo));
		return modelMap;
	}
}
