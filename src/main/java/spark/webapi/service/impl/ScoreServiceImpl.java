package spark.webapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spark.webapi.dao.ScoreMapper;
import spark.webapi.entity.Score;
import spark.webapi.entity.ScoreKey;
import spark.webapi.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	ScoreMapper scoreMapper;
	
	@Transactional
	@Override
	public int deleteByPrimaryKey(ScoreKey key) {
		// TODO Auto-generated method stub
		if(key.getStuNo()>0 && key.getCourseNo()>0){
			try{
				int effectedNum=scoreMapper.deleteByPrimaryKey(key);
				if(effectedNum>0){
					return effectedNum;
				}else{
					throw new RuntimeException("删除成绩信息失败!");
				}
			}catch(Exception e){
				throw new RuntimeException("删除成绩信息失败:" + e.toString());
			}
		}else{
			throw new RuntimeException("学号或课程号不能为空！");
		}
	}

	@Transactional
	@Override
	public int insert(Score record) {
		// TODO Auto-generated method stub
		if(record.getStuNo() != null && !"".equals(record.getStuNo()) && record.getCourseNo() != null && !"".equals(record.getCourseNo())){
			try{
				int effectedNum=scoreMapper.insert(record);
				if(effectedNum>0){
					return effectedNum;
				}else{
					throw new RuntimeException("添加成绩信息失败!");
				}
			}catch(Exception e){
				throw new RuntimeException("添加成绩信息失败:" + e.toString());
			}
		}else{
			throw new RuntimeException("成绩信息不能为空！");
		}
	}

	@Override
	public Score selectByPrimaryKey(ScoreKey key) {
		// TODO Auto-generated method stub
		return scoreMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByPrimaryKey(Score record) {
		// TODO Auto-generated method stub
		if(record.getStuNo() != null && record.getStuNo()>0 && record.getCourseNo() != null && record.getCourseNo()>0){
			try{
				int effectedNum=scoreMapper.updateByPrimaryKey(record);
				if(effectedNum>0){
					return effectedNum;
				}else{
					throw new RuntimeException("更新成绩信息失败!");
				}
			}catch(Exception e){
				throw new RuntimeException("更新成绩信息失败:" + e.toString());
			}
		}else{
			throw new RuntimeException("成绩信息不能为空！");
		}
	}

}
