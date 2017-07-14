package com.ikm.xmanager.commons.ueditor;

import com.ikm.xmanager.commons.ueditor.define.ActionMap;
import com.ikm.xmanager.commons.ueditor.manager.DefaultFileManager;
import com.ikm.xmanager.commons.ueditor.manager.IUeditorFileManager;
import com.ikm.xmanager.commons.utils.Charsets;
import com.ikm.xmanager.commons.utils.IOUtils;
import com.ikm.xmanager.commons.utils.JsonUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.InputStream;

/**
 * Ueditor配置
 * 
 * @author L.cm
 *
 */
@Component
public class UeditorManager implements InitializingBean {
	private static final String CONFIG_FILE_JSON = "/ueditor.config.json";
	private UeditorConfig jsonConfig = null;

	private IUeditorFileManager fileManager;
	
	public UeditorManager() {
		fileManager = new DefaultFileManager();
	}

	public IUeditorFileManager getFileManager() {
		return fileManager;
	}

	public void setFileManager(IUeditorFileManager fileManager) {
		this.fileManager = fileManager;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		InputStream input = UeditorManager.class.getResourceAsStream(CONFIG_FILE_JSON);
		Assert.notNull(input, "can't find ueditor.config.json");
		try {
			String configContent = IOUtils.copyToString(input, Charsets.UTF_8);
			jsonConfig = JsonUtils.parse(filter(configContent), UeditorConfig.class);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
	
	// 验证配置文件加载是否正确
	public boolean valid() {
		return jsonConfig != null;
	}

	public UeditorConfig getConfig() {
		return jsonConfig;
	}

	public ActionConfig getConfig(int type, String rootPath) {
		ActionConfig conf = new ActionConfig();
		String savePath = null;
		switch (type) {
		case ActionMap.UPLOAD_FILE:
			conf.setBase64(false);
			conf.setMaxSize(jsonConfig.getFileMaxSize());
			conf.setAllowFiles(jsonConfig.getFileAllowFiles());
			conf.setFieldName(jsonConfig.getFileFieldName());
			savePath = jsonConfig.getFilePathFormat();
			break;

		case ActionMap.UPLOAD_IMAGE:
			conf.setBase64(false);
			conf.setMaxSize(jsonConfig.getImageMaxSize());
			conf.setAllowFiles(jsonConfig.getImageAllowFiles());
			conf.setFieldName(jsonConfig.getImageFieldName());
			savePath = jsonConfig.getImagePathFormat();
			break;

		case ActionMap.UPLOAD_VIDEO:
			conf.setMaxSize(jsonConfig.getVideoMaxSize());
			conf.setAllowFiles(jsonConfig.getVideoAllowFiles());
			conf.setFieldName(jsonConfig.getVideoFieldName());
			savePath = jsonConfig.getVideoPathFormat();
			break;

		case ActionMap.UPLOAD_SCRAWL:
			conf.setFilename("scrawl");
			conf.setMaxSize(jsonConfig.getScrawlMaxSize());
			conf.setFieldName(jsonConfig.getScrawlFieldName());
			conf.setBase64(true);
			savePath = jsonConfig.getScrawlPathFormat();
			break;

		case ActionMap.CATCH_IMAGE:
			conf.setFilename("remote");
			conf.setFilter(jsonConfig.getCatcherLocalDomain());
			conf.setMaxSize(jsonConfig.getCatcherMaxSize());
			conf.setAllowFiles(jsonConfig.getCatcherAllowFiles());
			conf.setFieldName(jsonConfig.getCatcherFieldName() + "[]");
			savePath = jsonConfig.getCatcherPathFormat();
			break;

		case ActionMap.LIST_IMAGE:
			conf.setAllowFiles(jsonConfig.getImageManagerAllowFiles());
			conf.setDir(jsonConfig.getImageManagerListPath());
			conf.setCount(jsonConfig.getImageManagerListSize());
			break;

		case ActionMap.LIST_FILE:
			conf.setAllowFiles(jsonConfig.getFileManagerAllowFiles());
			conf.setDir(jsonConfig.getFileManagerListPath());
			conf.setCount(jsonConfig.getFileManagerListSize());
			break;
		}
		conf.setSavePath(savePath);
		conf.setRootPath(rootPath);
		return conf;
	}
	
	/**
	 * 过滤json, 剔除多行注释以及替换掉反斜杠
	 */
	private static String filter(String input) {
		return input.replaceAll("/\\*[\\s\\S]*?\\*/", "");
	}
}
