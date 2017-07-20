package com.ikaimen.model.util;

import java.io.Serializable;
import java.util.List;

/**
 * 创建时间：2015年10月13日 下午11:28:08
 * 
 * @author andy
 * @version 2.2
 */

public class ResponseData  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6478017818699106018L;
	private List<?> list = null;
	private Object cont = null;
	private String extra ;


	public ResponseData(List<?> list, Object cont,String extra) {
		super();
		this.list = list;
		this.cont = cont;
		this.extra = extra;
	}

	public ResponseData(List<?> list, Object cont) {
		super();
		this.list = list;
		this.cont = cont;
	}

	public ResponseData() {
		super();
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Object getCont() {
		return cont;
	}

	public void setCont(Object cont) {
		this.cont = cont;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}


}
