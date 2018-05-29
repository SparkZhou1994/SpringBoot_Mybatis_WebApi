package spark.webapi.dao;

import spark.webapi.entity.Major;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer majorNo);

    int insert(Major record);

    Major selectByPrimaryKey(Integer majorNo);

    int updateByPrimaryKey(Major record);
}