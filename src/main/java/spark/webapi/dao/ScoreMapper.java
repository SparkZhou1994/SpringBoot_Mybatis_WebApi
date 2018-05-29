package spark.webapi.dao;

import spark.webapi.entity.Score;
import spark.webapi.entity.ScoreKey;

public interface ScoreMapper {
    int deleteByPrimaryKey(ScoreKey key);

    int insert(Score record);

    Score selectByPrimaryKey(ScoreKey key);

    int updateByPrimaryKey(Score record);
}