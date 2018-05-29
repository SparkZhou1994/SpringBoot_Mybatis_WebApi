package spark.webapi.service;

import spark.webapi.entity.Major;

public interface MajorService {
    int deleteByPrimaryKey(Integer majorNo);

    int insert(Major record);

    Major selectByPrimaryKey(Integer majorNo);

    int updateByPrimaryKey(Major record);
}
