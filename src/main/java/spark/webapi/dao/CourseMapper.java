package spark.webapi.dao;

import spark.webapi.entity.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseNo);

    int insert(Course record);

    Course selectByPrimaryKey(Integer courseNo);

    int updateByPrimaryKey(Course record);
}