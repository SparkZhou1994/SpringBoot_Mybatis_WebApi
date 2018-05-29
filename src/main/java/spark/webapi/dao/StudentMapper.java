package spark.webapi.dao;

import spark.webapi.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer stuNo);

    int insert(Student record);

    Student selectByPrimaryKey(Integer stuNo);

    int updateByPrimaryKey(Student record);
}