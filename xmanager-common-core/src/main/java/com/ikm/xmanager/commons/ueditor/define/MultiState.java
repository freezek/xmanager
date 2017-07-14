package com.ikm.xmanager.commons.ueditor.define;


import com.ikm.xmanager.commons.ueditor.Encoder;
import com.ikm.xmanager.commons.utils.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多状态集合状态 其包含了多个状态的集合, 其本身自己也是一个状态
 * @author hancong03@baidu.com
 */
public class MultiState implements State {

	private boolean state = false;
	private String info = null;
	private Map<String, Object> infoMap = new HashMap<String, Object>();
	private List<Map<String, Object>> stateList = new ArrayList<Map<String, Object>>();

	public MultiState(boolean state) {
		this.state = state;
	}

	public MultiState(boolean state, String info) {
		this.state = state;
		this.info = info;
	}

	public MultiState(boolean state, int infoKey) {
		this.state = state;
		this.info = AppInfo.getStateInfo(infoKey);
	}

	@Override
	public boolean isSuccess() {
		return this.state;
	}

	public void addState(State state) {
		stateList.add(state.toJSONObject());
	}

	/**
	 * 该方法调用无效果
	 */
	@Override
	public void putInfo(String name, String val) {
		this.infoMap.put(name, val);
	}

	@Override
	public Map<String, Object> toJSONObject() {
		String stateVal = this.isSuccess() ? AppInfo.getStateInfo(AppInfo.SUCCESS) : this.info;
		this.infoMap.put("state", stateVal);
		this.infoMap.put("list", stateList);
		return infoMap;
	}
	
	@Override
	public String toJSONString() {
		this.toJSONObject();
		return Encoder.toUnicode(JsonUtils.toJson(infoMap));
	}

	@Override
	public void putInfo(String name, long val) {
		this.infoMap.put(name, val);
	}

}
