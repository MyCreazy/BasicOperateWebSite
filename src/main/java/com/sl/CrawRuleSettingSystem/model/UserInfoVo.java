package com.sl.CrawRuleSettingSystem.model;

/**
 * 用户登录信息
 * 
 * @author Administrator
 *
 */
public class UserInfoVo {
	/**
	 * 主键
	 */
	private String KeyID = "";

	/**
	 * 用户名
	 */
	private String UserName = "";

	/**
	 * 密码
	 */
	private String PassWord = "";

	/**
	 * 
	 */
	private int IsAdministrators = 0;

	/**
	 * 是否删除
	 */
	private int IsDelete = 0;

	/**
	 * 修改时间
	 */
	private String ModifyTime = "";

	/**
	 * 获取主键
	 * @return
	 */
	public String getKeyID() {
		return KeyID;
	}

	/**
	 * 设置主键
	 * @param keyID
	 */
	public void setKeyID(String keyID) {
		KeyID = keyID;
	}

	/**
	 * 获取用户名
	 * @return
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * 设置用户名
	 * @param userName
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * 获取密码
	 * @return
	 */
	public String getPassWord() {
		return PassWord;
	}

	/**
	 * 设置密码
	 * @param passWord
	 */
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	/**
	 * 获取是否是管理员
	 * @return
	 */
	public int getIsAdministrators() {
		return IsAdministrators;
	}

	/**
	 * 设置是否是管理员
	 * @param isAdministrators
	 */
	public void setIsAdministrators(int isAdministrators) {
		IsAdministrators = isAdministrators;
	}

	/**
	 * 获取是否删除
	 * @return
	 */
	public int getIsDelete() {
		return IsDelete;
	}

	/**
	 * 设置是否删除
	 * @param isDelete
	 */
	public void setIsDelete(int isDelete) {
		IsDelete = isDelete;
	}

	/**
	 * 获取修改时间
	 * @return
	 */
	public String getModifyTime() {
		return ModifyTime;
	}

	/**
	 * 设置修改时间
	 * @param modifyTime
	 */
	public void setModifyTime(String modifyTime) {
		ModifyTime = modifyTime;
	}
}
