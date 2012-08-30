package com.pocoer.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.pocoer.model.ExclusiveKey;
/**
 * 这是一个ExclusiveKeyService抽象类
 * 它对外暴露一个方法，让用户调用
 * @author roadahead
 *
 */
@WebService
public interface ExclusiveKeyService {
	/**
	 * 对外暴露的方法，创建并返回一个APIKey，同时将其存进数据库中
	 */
	@WebMethod(operationName="GetAPIKey")
	@WebResult(name = "result")
	public String getAPIKey(@WebParam(name = "kebsiteName")String kebsiteName);
}
