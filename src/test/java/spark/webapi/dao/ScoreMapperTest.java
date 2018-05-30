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

import spark.webapi.entity.Score;
import spark.webapi.entity.ScoreKey;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class ScoreMapperTest {
	@Autowired
	private ScoreMapper scoreMapper;
	@Test
	@Ignore
	public void testselectCourseMax(){
		List<Score> scoreList=scoreMapper.selectMajorAvg();
		assertEquals(new Integer(75), scoreList.get(0).getScore());
	}
	@Test
	public void testSelectByPrimaryKey(){
		ScoreKey scoreKey=new ScoreKey();
		scoreKey.setStuNo(1);
		scoreKey.setCourseNo(1);
		Score score=scoreMapper.selectByPrimaryKey(scoreKey);
		assertEquals(new Integer(100), score.getScore());
	}
}
