/**
 * 
 */
package com.wpmac.mzehtapi.api.base;

import java.io.Serializable;

/**
 * Package: cn.upg.credit.circus.result
 * Description:  基础返回对象
 *
 * @author : yingxiaohong
 * @create : yingxiaohong 2016-11-10-下午5:02
 * @update : yingxiaohong (2016-11-10-下午5:02)
 **/

public class ApiResult<T> implements Serializable {

	private static final long serialVersionUID = 517161603122400300L;
	private boolean success = false;
	private String message;
	private T data;

	public ApiResult(boolean success , String message){
		this.success = success ;
		this.message = message ;
	}

	public ApiResult(boolean success , String message, T data){
		this.success = success ;
		this.message = message ;
		this.data = data ;
	}



	/**
	 * @return the success
	 */
	public final boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public final void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


}