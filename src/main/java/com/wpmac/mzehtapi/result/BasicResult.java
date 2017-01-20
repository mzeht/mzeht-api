/**
 * 
 */
package com.wpmac.mzehtapi.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Package: cn.upg.credit.common.result
 * Description:  基础返回对象
 *
 * @author : yingxiaohong
 * @create : yingxiaohong 2016-11-10-下午5:02
 * @update : yingxiaohong (2016-11-10-下午5:02)
 **/

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicResult<T> implements Serializable {

	private static final long serialVersionUID = 517161603122400300L;
	@JsonProperty("success")
	private boolean success = false;
	@JsonProperty("message")
	private String message;
	@JsonProperty("data")
	private T data;
	@JsonProperty("code")
	private T code;
	

	public BasicResult(boolean success , String message){
		this.success = success ;
		this.message = message ;
	}

	public BasicResult(boolean success , String message, T data){
		this.success = success ;
		this.message = message ;
		this.data = data ;
	}
	
	public BasicResult(boolean success , T code , String message){
		this.success = success ;
		this.code = code ;
		this.message = message ;
		
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

	public T getCode() {
		return code;
	}

	public void setCode(T code) {
		this.code = code;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}