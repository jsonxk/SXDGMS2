package com.xk.Dao;

import com.xk.orm.HistoryEmail;

public interface HistoryEmailMapper {
	/**
	 * 把发送的信息添加到historyemail中
	 * @param historyEmail
	 * @return
	 */
	int SubmitRepairInfo(HistoryEmail historyEmail);
}