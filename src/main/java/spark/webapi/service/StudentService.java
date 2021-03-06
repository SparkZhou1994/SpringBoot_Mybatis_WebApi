package spark.webapi.service;

import spark.webapi.entity.Student;

public interface StudentService {
    int deleteByPrimaryKey(Integer stuNo);

    int insert(Student record);
    
    Student selectByPrimaryKey(Integer stuNo);

    int updateByPrimaryKey(Student record);
}
