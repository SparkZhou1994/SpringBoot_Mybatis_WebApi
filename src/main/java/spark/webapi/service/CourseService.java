package spark.webapi.service;

import spark.webapi.entity.Course;

public interface CourseService {
    int deleteByPrimaryKey(Integer courseNo);

    int insert(Course record);

    Course selectByPrimaryKey(Integer courseNo);

    int updateByPrimaryKey(Course record);
}
