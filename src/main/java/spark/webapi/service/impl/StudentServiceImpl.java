package spark.webapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spark.webapi.dao.StudentDao;
import spark.webapi.entity.Student;
import spark.webapi.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return studentDao.queryStudent();
	}

	@Override
	public Student getStudentByNo(int stuNo) {
		// TODO Auto-generated method stub
		return studentDao.queryStudentByNo(stuNo);
	}
	
	@Transactional
	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		// 空值判断，主要是判断areaName不为空
				if (student.getStuName() != null && !"".equals(student.getStuName())) {
					// 设置默认值

					try {
						int effectedNum = studentDao.insertStudent(student);
						if (effectedNum > 0) {
							return true;
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
	public boolean modifyStudent(Student student) {
		// TODO Auto-generated method stub
		// 空值判断，主要是areaId不为空
				if (student.getStuNo() != null && student.getStuNo() > 0) {
					// 设置默认值
					try {
						// 更新区域信息
						int effectedNum = studentDao.updateStudent(student);
						if (effectedNum > 0) {
							return true;
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

	@Transactional
	@Override
	public boolean deleteStudent(int stuNo) {
		// TODO Auto-generated method stub
		if (stuNo > 0) {
			try {
				// 删除区域信息
				int effectedNum = studentDao.deleteStudent(stuNo);
				if (effectedNum > 0) {
					return true;
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

}
