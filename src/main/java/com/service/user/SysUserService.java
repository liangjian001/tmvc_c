package com.service.user;

import com.entities.share.ResultInfo;
import com.entities.user.SysUser;
import com.entities.user.SysUserExample;

public interface SysUserService {
	public ResultInfo getUserListData(SysUserExample example);
	public ResultInfo getUserListByEntity(SysUser user);
	public ResultInfo insertUserInfo(SysUser user);
	public int selectCountByEntity(SysUser user);
}
