package spark.webapi.service;

import java.util.List;

import spark.webapi.entity.Score;
import spark.webapi.entity.ScoreKey;

public interface ScoreService {
    int deleteByPrimaryKey(ScoreKey key);

    int insert(Score record);

    Score selectByPrimaryKey(ScoreKey key);

    int updateByPrimaryKey(Score record);
    
    List<Score> selectCourseMax();
    
    List<Score> selectCourseMin();
    
    List<Score> selectCourseAvg();
    
    List<Score> selectMajorMax();
    
    List<Score> selectMajorMin();
    
    List<Score> selectMajorAvg();
}
