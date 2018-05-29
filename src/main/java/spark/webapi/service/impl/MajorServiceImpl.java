package spark.webapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spark.webapi.dao.MajorMapper;
import spark.webapi.entity.Major;
import spark.webapi.service.MajorService;

@Service
public class MajorServiceImpl implements MajorService{
	@Autowired
	MajorMapper majorMapper;

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer majorNo) {
		// TODO Auto-generated method stub
		if (majorNo > 0) {
			try {
				// 删除区域信息
				int effectedNum = majorMapper.deleteByPrimaryKey(majorNo);
				if (effectedNum > 0) {
					return effectedNum;
				} else {
					throw new RuntimeException("删除专业信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除专业信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("专业号不能为空！");
		}
	}

	@Transactional
	@Override
	public int insert(Major record) {
		// TODO Auto-generated method stub
		if (record.getMajorName() != null && !"".equals(record.getMajorName())) {
			// 设置默认值

			try {
				int effectedNum = majorMapper.insert(record);
				if (effectedNum > 0) {
					return effectedNum;
				} else {
					throw new RuntimeException("添加专业信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加专业信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("专业信息不能为空！");
		}
	}

	@Override
	public Major selectByPrimaryKey(Integer majorNo) {
		// TODO Auto-generated method stub
		return majorMapper.selectByPrimaryKey(majorNo);
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(Major record) {
		// TODO Auto-generated method stub
		if (record.getMajorNo() != null && record.getMajorNo() > 0) {
			// 设置默认值
			try {
				// 更新区域信息
				int effectedNum = majorMapper.updateByPrimaryKey(record);
				if (effectedNum > 0) {
					return effectedNum;
				} else {
					throw new RuntimeException("更新专业信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新专业信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("专业信息不能为空！");
		}
	}

}
