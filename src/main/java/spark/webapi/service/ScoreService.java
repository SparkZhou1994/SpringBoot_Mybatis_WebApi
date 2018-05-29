package spark.webapi.service;

import spark.webapi.entity.Score;
import spark.webapi.entity.ScoreKey;

public interface ScoreService {
    int deleteByPrimaryKey(ScoreKey key);

    int insert(Score record);

    Score selectByPrimaryKey(ScoreKey key);

    int updateByPrimaryKey(Score record);
}
