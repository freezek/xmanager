package com.ikm.xmanager.commons.ueditor.define;


import com.ikm.xmanager.commons.ueditor.Encoder;
import com.ikm.xmanager.commons.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

public class BaseState implements State {

	private boolean state = false;
	private String info = null;

	private Map<String, Object> infoMap = new HashMap<String, Object>();

	public BaseState() {
		this.state = true;
	}

	public BaseState(boolean state) {
		this.setState(state);
	}

	public BaseState(boolean state, String info) {
		this.setState(state);
		this.info = info;
	}

	public BaseState(boolean state, int infoCode) {
		this.setState(state);
		this.info = AppInfo.getStateInfo(infoCode);
	}

	public boolean isSuccess() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setInfo(int infoCode) {
		this.info = AppInfo.getStateInfo(infoCode);
	}

	@Override
	public String toJSONString() {
		this.toJSONObject();
		return Encoder.toUnicode(JsonUtils.toJson(this.infoMap));
	}

	@Override
	public void putInfo(String name, String val) {
		this.infoMap.put(name, val);
	}

	@Override
	public void putInfo(String name, long val) {
		this.putInfo(name, val + "");
	}

	@Override
	public Map<String, Object> toJSONObject() {
		String stateVal = this.isSuccess() ? AppInfo.getStateInfo(AppInfo.SUCCESS) : this.info;
		this.infoMap.put("state", stateVal);
		return infoMap;
	}

}
