package com.ikm.xmanager.commons.ueditor.hunter;


import com.ikm.xmanager.commons.ueditor.ActionConfig;
import com.ikm.xmanager.commons.ueditor.PathFormat;
import com.ikm.xmanager.commons.ueditor.define.*;
import com.ikm.xmanager.commons.ueditor.manager.IUeditorFileManager;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * 图片抓取器
 * 
 * @author hancong03@baidu.com
 * 
 */
public class ImageHunter {
	private String filename = null;
	private String savePath = null;
	private String rootPath = null;
	private List<String> allowTypes = null;
	private long maxSize = -1;
	private IUeditorFileManager fileManager;
	private List<String> filters = null;

	public ImageHunter(IUeditorFileManager fileManager, ActionConfig conf) {
		this.fileManager = fileManager;
		this.filename = conf.getFilename();
		this.savePath = conf.getSavePath();
		this.rootPath = conf.getRootPath();
		this.maxSize = conf.getMaxSize();
		this.allowTypes = conf.getAllowFiles();
		this.filters = conf.getFilter();
	}

	public State capture(String[] list) {
		MultiState state = new MultiState(true);
		for (String source : list) {
			state.addState(captureRemoteData(source));
		}
		return state;
	}

	public State captureRemoteData(String urlStr) {
		HttpURLConnection connection = null;
		URL url = null;
		String suffix = null;
		try {
			url = new URL(urlStr);

			if (!validHost(url.getHost())) {
				return new BaseState(false, AppInfo.PREVENT_HOST);
			}

			connection = (HttpURLConnection) url.openConnection();
			connection.setInstanceFollowRedirects(true);
			connection.setUseCaches(true);

			if (!validContentState(connection.getResponseCode())) {
				return new BaseState(false, AppInfo.CONNECTION_ERROR);
			}

			suffix = MIMEType.getSuffix(connection.getContentType());

			if (!validFileType(suffix)) {
				return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
			}

			if (!validFileSize(connection.getContentLength())) {
				return new BaseState(false, AppInfo.MAX_SIZE);
			}

			String savePath = this.getPath(this.savePath, this.filename, suffix);

			State state = fileManager.saveFile(connection.getInputStream(), rootPath, savePath);

			if (state.isSuccess()) {
				state.putInfo("url", PathFormat.format(savePath));
				state.putInfo("source", urlStr);
			}
			return state;
		} catch (Exception e) {
			return new BaseState(false, AppInfo.REMOTE_FAIL);
		}
	}

	private String getPath(String savePath, String filename, String suffix) {
		return PathFormat.parse(savePath + suffix, filename);
	}

	private boolean validHost(String hostname) {
		return !filters.contains(hostname);
	}

	private boolean validContentState(int code) {
		return HttpURLConnection.HTTP_OK == code;
	}

	private boolean validFileType(String type) {
		return this.allowTypes.contains(type);
	}

	private boolean validFileSize(int size) {
		return size < this.maxSize;
	}

}
