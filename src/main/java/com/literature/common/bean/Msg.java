package com.literature.common.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * 封装返回的消息
 * @author Literature
 * @date 2018年10月28日
 *
 */
public class Msg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//状态码
	private int code;
	//状态
	private String status;
	//结果
	private Map<String,Object> map=new HashMap<>();
	
	private static final int SUCCESS_CODE=100;
	private static final int FAILURE_CODE=200;
	private static final String SUCCESS_STATUS="操作成功";
	private static final String FAILURE_STATUS="操作失败";
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public static Msg success() {
		Msg msg=new Msg();
		msg.code=SUCCESS_CODE;
		msg.status=SUCCESS_STATUS;
		return msg;
	}
	public static Msg failure() {
		Msg msg=new Msg();
		msg.code=FAILURE_CODE;
		msg.status=FAILURE_STATUS;
		return msg;
	}
	public Msg add(String key,Object value) {
		map.put(key, value);
		return this;
	}
}
