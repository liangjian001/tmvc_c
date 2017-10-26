package com.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.common.MybatisSqlSessionFactory;
import com.dao.user.SysUserDao;
import com.entities.share.ResultInfo;
import com.entities.user.SysUser;
import com.entities.user.SysUserExample;
import com.service.user.SysUserService;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public ResultInfo getUserListData(SysUserExample example) {
		ResultInfo resultInfo = new ResultInfo();
		SqlSession sqlSession  = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			List<SysUser> listData = new ArrayList<SysUser>();
			listData = sysUserDao.getUserListData(sqlSession, example);
			if (null != listData && 0 < listData.size()){
				resultInfo.setResultFlag(true);
				resultInfo.setResultObject(listData);
			} else {
				resultInfo.setResultFlag(false);
				resultInfo.setResultText("没有查询到符合条件的数据!");
			}
		} catch (Exception ex){
			ex.printStackTrace();
			resultInfo.setResultFlag(false);
			resultInfo.setResultText("查询数据异常!");
		} finally {
			sqlSession.close();
		}
		return resultInfo;
	}

	@Override
	@Cacheable(value="myCache",key="#user.userId")
	public ResultInfo getUserListByEntity(SysUser user) {
		ResultInfo resultInfo = new ResultInfo();
		SqlSession sqlSession  = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try{
			List<SysUser> listData = new ArrayList<SysUser>();
			listData = sysUserDao.getUserListByEntity(sqlSession, user);
			if (null != listData && 0 < listData.size()){
				resultInfo.setResultFlag(true);
				resultInfo.setResultObject(listData);
			} else {
				resultInfo.setResultFlag(false);
				resultInfo.setResultText("没有查询到符合条件的数据!");
			}
		} catch (Exception ex){
			ex.printStackTrace();
			resultInfo.setResultFlag(false);
			resultInfo.setResultText("查询数据异常!");
		} finally {
			sqlSession.close();
		}
		return resultInfo;
	}

	/**
	 * insert的缓存注解用的是@CacheEvict(value="myCache",key="0",beforeInvocation=true)，
	 * 这里清除的是指定缓存，也就是count方法中@Cacheable(value="myCache",key="0")的，
	 * （serviceImpl中注释的@CacheEvict(value="myCache",allEntries=true,beforeInvocation=true)是清除所有的缓存
	 */
	@Override
	//@CacheEvict(value="myCache",allEntries=true,beforeInvocation=true)//清除所有的缓存
	@CacheEvict(value="myCache",key="0",beforeInvocation=true)//清除的是指定缓存
	public ResultInfo insertUserInfo(SysUser user) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultFlag(false);
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			if (null == user){
				resultInfo.setResultText("参数不能为null!");
			} else {
				int result = sysUserDao.insertUserInfo(sqlSession, user);
				if (0 < result){
					resultInfo.setResultFlag(true);
					resultInfo.setResultText("保存用户信息成功!");
				} else {
					resultInfo.setResultText("保存用户信息失败!");
				}
			}
		} catch (Exception ex){
			ex.printStackTrace();
			resultInfo.setResultText("保存用户信息异常!");
		} finally {
			sqlSession.close();
		}
		return resultInfo;
	}

	@Override
	@Cacheable(value="myCache",key="0")
	public int selectCountByEntity(SysUser user) {
		int count = 0;
		SqlSession sqlSession  = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			count = sysUserDao.selectCountByEntity(sqlSession, user);
		} catch (Exception ex){
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return count;
	}

}
