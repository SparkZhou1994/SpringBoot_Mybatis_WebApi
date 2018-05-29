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
	
	@RequestMapping(value = "/getbyno", method = RequestMethod.GET)
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

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	private Map<String, Object> removeScore(@RequestBody ScoreKey key) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", scoreService.deleteByPrimaryKey(key));
		return modelMap;
	}
}
