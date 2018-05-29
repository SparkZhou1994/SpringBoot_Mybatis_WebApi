package spark.webapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spark.webapi.dao.CourseMapper;
import spark.webapi.entity.Course;
import spark.webapi.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseMapper courseMapper;
	
	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer courseNo) {
		// TODO Auto-generated method stub
		if (courseNo > 0) {
			try {
				// 删除区域信息
				int effectedNum = courseMapper.deleteByPrimaryKey(courseNo);
				if (effectedNum > 0) {
					return effectedNum;
				} else {
					throw new RuntimeException("删除课程信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除课程信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("课程号x不能为空！");
		}
	}

	@Transactional
	@Override
	public int insert(Course record) {
		// TODO Auto-generated method stub
		if (record.getCourseName() != null && !"".equals(record.getCourseName())) {
			// 设置默认值

			try {
				int effectedNum = courseMapper.insert(record);
				if (effectedNum > 0) {
					return effectedNum;
				} else {
					throw new RuntimeException("添加课程信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加课程信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("课程信息不能为空！");
		}
	}

	@Override
	public Course selectByPrimaryKey(Integer courseNo) {
		// TODO Auto-generated method stub
		return courseMapper.selectByPrimaryKey(courseNo);
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(Course record) {
		// TODO Auto-generated method stub
		if (record.getCourseNo() != null && record.getCourseNo() > 0) {
			// 设置默认值
			try {
				// 更新区域信息
				int effectedNum = courseMapper.updateByPrimaryKey(record);
				if (effectedNum > 0) {
					return effectedNum;
				} else {
					throw new RuntimeException("更新课程信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新课程信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("课程信息不能为空！");
		}
	}

}
