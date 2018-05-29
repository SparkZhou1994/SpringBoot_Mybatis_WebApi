package spark.webapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spark.webapi.dao.StudentMapper;
import spark.webapi.entity.Student;
import spark.webapi.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer stuNo) {
		// TODO Auto-generated method stub
		if (stuNo > 0) {
			try {
				// 删除区域信息
				int effectedNum = studentMapper.deleteByPrimaryKey(stuNo);
				if (effectedNum > 0) {
					return effectedNum;
				} else {
					throw new RuntimeException("删除学生信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除学生信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("学号不能为空！");
		}
	}

	@Transactional
	@Override
	public int insert(Student record) {
		// TODO Auto-generated method stub
		if (record.getStuName() != null && !"".equals(record.getStuName())) {
			// 设置默认值

			try {
				int effectedNum = studentMapper.insert(record);
				if (effectedNum > 0) {
					return effectedNum;
				} else {
					throw new RuntimeException("添加学生信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加学生信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("学生信息不能为空！");
		}
	}


	@Transactional
	@Override
	public int updateByPrimaryKey(Student record) {
		// TODO Auto-generated method stub
		if (record.getStuNo() != null && record.getStuNo() > 0) {
			// 设置默认值
			try {
				// 更新区域信息
				int effectedNum = studentMapper.updateByPrimaryKey(record);
				if (effectedNum > 0) {
					return effectedNum;
				} else {
					throw new RuntimeException("更新学生信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新学生信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("学生信息不能为空！");
		}
	}


	@Override
	public Student selectByPrimaryKey(Integer stuNo) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(stuNo);
	}
}
