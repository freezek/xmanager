package com.ikm.xmanager.commons.ueditor;

import java.util.List;

public class ActionConfig {
	private boolean isBase64;
	private long maxSize;
	private List<String> allowFiles;
	private String fieldName;
	private String filename;
	private List<String> filter;
	private String dir;
	private int count;
	
	private String savePath;
	private String rootPath;
	
	public boolean isBase64() {
		return isBase64;
	}
	public void setBase64(boolean isBase64) {
		this.isBase64 = isBase64;
	}
	public long getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}
	public List<String> getAllowFiles() {
		return allowFiles;
	}
	public void setAllowFiles(List<String> allowFiles) {
		this.allowFiles = allowFiles;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public List<String> getFilter() {
		return filter;
	}
	public void setFilter(List<String> filter) {
		this.filter = filter;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getRootPath() {
		return rootPath;
	}
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
}
