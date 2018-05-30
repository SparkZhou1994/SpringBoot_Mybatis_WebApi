package spark.webapi.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spark.webapi.entity.Score;
import spark.webapi.entity.ScoreKey;
import spark.webapi.service.ScoreService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/score")
public class ScoreController {
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(value = "/getbyno", method = RequestMethod.POST)
	private Map<String, Object> getScoreByNo(@RequestBody ScoreKey key) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		Score score = scoreService.selectByPrimaryKey(key);
		modelMap.put("score",score);
		return modelMap;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private Map<String, Object> addScore(@RequestBody Score score)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 添加区域信息
		modelMap.put("success", scoreService.insert(score));
		return modelMap;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	private Map<String, Object> modifyScore(@RequestBody Score score)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", scoreService.updateByPrimaryKey(score));
		return modelMap;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	private Map<String, Object> removeScore(@RequestBody ScoreKey key) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", scoreService.deleteByPrimaryKey(key));
		return modelMap;
	}
	
	@RequestMapping(value = "/getCourseMax", method = RequestMethod.GET)
	private Map<String, Object> getCourseMax() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		List<Score> score= scoreService.selectCourseMax();
		modelMap.put("score",score);
		return modelMap;
	}
	
	@RequestMapping(value = "/getCourseMin", method = RequestMethod.GET)
	private Map<String, Object> getCourseMin() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		List<Score> score= scoreService.selectCourseMin();
		modelMap.put("score",score);
		return modelMap;
	}
	
	@RequestMapping(value = "/getCourseAvg", method = RequestMethod.GET)
	private Map<String, Object> getCourseAvg() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		List<Score> score= scoreService.selectCourseAvg();
		modelMap.put("score",score);
		return modelMap;
	}
	
	@RequestMapping(value = "/getMajorMax", method = RequestMethod.GET)
	private Map<String, Object> getMajorMax() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		List<Score> score= scoreService.selectMajorMax();
		modelMap.put("score",score);
		return modelMap;
	}
	
	@RequestMapping(value = "/getMajorMin", method = RequestMethod.GET)
	private Map<String, Object> getMajorMin() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		List<Score> score= scoreService.selectMajorMin();
		modelMap.put("score",score);
		return modelMap;
	}
	
	@RequestMapping(value = "/getMajorAvg", method = RequestMethod.GET)
	private Map<String, Object> getMajorAvg() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		List<Score> score= scoreService.selectMajorAvg();
		modelMap.put("score",score);
		return modelMap;
	}
}
