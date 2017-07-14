package com.ikm.xmanager.commons.ueditor;

import java.util.List;

/**
 * Ueditor json 配置文件解析
 * @author L.cm
 */
public class UeditorConfig {
	/* 执行上传图片的action名称 */
	private String imageActionName;
	/* 提交的图片表单名称 */
	private String imageFieldName;
	/* 上传大小限制，单位B */
	private long imageMaxSize;
	/* 上传图片格式显示 */
	private List<String> imageAllowFiles;
	private boolean imageCompressEnable;
	/* 图片压缩最长边限制 */
	private int imageCompressBorder;
	/* 插入的图片浮动方式 */
	private String imageInsertAlign;
	/* 图片访问路径前缀 */
	private String imageUrlPrefix;
	/* 上传保存路径,可以自定义保存路径和文件名格式 */
	private String imagePathFormat;
	
	/* 执行上传涂鸦的action名称 */
	private String scrawlActionName;
	/* 提交的图片表单名称 */
	private String scrawlFieldName;
	/* 上传保存路径,可以自定义保存路径和文件名格式 */
	private String scrawlPathFormat;
	/* 上传大小限制，单位B */
	private long scrawlMaxSize;
	/* 图片访问路径前缀 */
	private String scrawlUrlPrefix;
	/* 插入的图片浮动方式 */
	private String scrawlInsertAlign;
	
	/* 执行上传截图的action名称 */
	private String snapscreenActionName;
	/* 上传保存路径,可以自定义保存路径和文件名格式 */
	private String snapscreenPathFormat;
	/* 图片访问路径前缀 */
	private String snapscreenUrlPrefix;
	/* 插入的图片浮动方式 */
	private String snapscreenInsertAlign;

	private List<String> catcherLocalDomain;
	/* 执行抓取远程图片的action名称 */
	private String catcherActionName;
	/* 提交的图片列表表单名称 */
	private String catcherFieldName;
	/* 上传保存路径,可以自定义保存路径和文件名格式 */
	private String catcherPathFormat;
	/* 图片访问路径前缀 */
	private String catcherUrlPrefix;
	/* 上传大小限制，单位B */
	private long catcherMaxSize;
	/* 抓取图片格式显示 */
	private List<String> catcherAllowFiles;

	/* 执行上传视频的action名称 */
	private String videoActionName;
	/* 提交的视频表单名称 */
	private String videoFieldName;
	/* 上传保存路径,可以自定义保存路径和文件名格式 */
	private String videoPathFormat;
	/* 视频访问路径前缀 */
	private String videoUrlPrefix;
	/* 上传大小限制，单位B，默认100MB */
	private long videoMaxSize;
	/* 上传视频格式显示 */
	private List<String> videoAllowFiles;

	/* controller里,执行上传视频的action名称 */
	private String fileActionName;
	/* 提交的文件表单名称 */
	private String fileFieldName;
	/* 上传保存路径,可以自定义保存路径和文件名格式 */
	private String filePathFormat;
	/* 文件访问路径前缀 */
	private String fileUrlPrefix;
	/* 上传大小限制，单位B，默认50MB */
	private long fileMaxSize;
	/* 上传文件格式显示 */
	private List<String> fileAllowFiles;

	/* 执行图片管理的action名称 */
	private String imageManagerActionName;
	/* 指定要列出图片的目录 */
	private String imageManagerListPath;
	/* 每次列出文件数量 */
	private int imageManagerListSize;
	/* 图片访问路径前缀 */
	private String imageManagerUrlPrefix;
	/* 插入的图片浮动方式 */
	private String imageManagerInsertAlign;
	/* 列出的文件类型 */
	private List<String> imageManagerAllowFiles;

	/* 执行文件管理的action名称 */
	private String fileManagerActionName;
	/* 指定要列出文件的目录 */
	private String fileManagerListPath;
	/* 文件访问路径前缀 */
	private String fileManagerUrlPrefix;
	/* 每次列出文件数量 */
	private int fileManagerListSize;
	/* 列出的文件类型 */
	private List<String> fileManagerAllowFiles;
	
	public String getImageActionName() {
		return imageActionName;
	}
	public void setImageActionName(String imageActionName) {
		this.imageActionName = imageActionName;
	}
	public String getImageFieldName() {
		return imageFieldName;
	}
	public void setImageFieldName(String imageFieldName) {
		this.imageFieldName = imageFieldName;
	}
	public long getImageMaxSize() {
		return imageMaxSize;
	}
	public void setImageMaxSize(long imageMaxSize) {
		this.imageMaxSize = imageMaxSize;
	}
	public List<String> getImageAllowFiles() {
		return imageAllowFiles;
	}
	public void setImageAllowFiles(List<String> imageAllowFiles) {
		this.imageAllowFiles = imageAllowFiles;
	}
	public boolean isImageCompressEnable() {
		return imageCompressEnable;
	}
	public void setImageCompressEnable(boolean imageCompressEnable) {
		this.imageCompressEnable = imageCompressEnable;
	}
	public int getImageCompressBorder() {
		return imageCompressBorder;
	}
	public void setImageCompressBorder(int imageCompressBorder) {
		this.imageCompressBorder = imageCompressBorder;
	}
	public String getImageInsertAlign() {
		return imageInsertAlign;
	}
	public void setImageInsertAlign(String imageInsertAlign) {
		this.imageInsertAlign = imageInsertAlign;
	}
	public String getImageUrlPrefix() {
		return imageUrlPrefix;
	}
	public void setImageUrlPrefix(String imageUrlPrefix) {
		this.imageUrlPrefix = imageUrlPrefix;
	}
	public String getImagePathFormat() {
		return imagePathFormat;
	}
	public void setImagePathFormat(String imagePathFormat) {
		this.imagePathFormat = imagePathFormat;
	}
	public String getScrawlActionName() {
		return scrawlActionName;
	}
	public void setScrawlActionName(String scrawlActionName) {
		this.scrawlActionName = scrawlActionName;
	}
	public String getScrawlFieldName() {
		return scrawlFieldName;
	}
	public void setScrawlFieldName(String scrawlFieldName) {
		this.scrawlFieldName = scrawlFieldName;
	}
	public String getScrawlPathFormat() {
		return scrawlPathFormat;
	}
	public void setScrawlPathFormat(String scrawlPathFormat) {
		this.scrawlPathFormat = scrawlPathFormat;
	}
	public long getScrawlMaxSize() {
		return scrawlMaxSize;
	}
	public void setScrawlMaxSize(long scrawlMaxSize) {
		this.scrawlMaxSize = scrawlMaxSize;
	}
	public String getScrawlUrlPrefix() {
		return scrawlUrlPrefix;
	}
	public void setScrawlUrlPrefix(String scrawlUrlPrefix) {
		this.scrawlUrlPrefix = scrawlUrlPrefix;
	}
	public String getScrawlInsertAlign() {
		return scrawlInsertAlign;
	}
	public void setScrawlInsertAlign(String scrawlInsertAlign) {
		this.scrawlInsertAlign = scrawlInsertAlign;
	}
	public String getSnapscreenActionName() {
		return snapscreenActionName;
	}
	public void setSnapscreenActionName(String snapscreenActionName) {
		this.snapscreenActionName = snapscreenActionName;
	}
	public String getSnapscreenPathFormat() {
		return snapscreenPathFormat;
	}
	public void setSnapscreenPathFormat(String snapscreenPathFormat) {
		this.snapscreenPathFormat = snapscreenPathFormat;
	}
	public String getSnapscreenUrlPrefix() {
		return snapscreenUrlPrefix;
	}
	public void setSnapscreenUrlPrefix(String snapscreenUrlPrefix) {
		this.snapscreenUrlPrefix = snapscreenUrlPrefix;
	}
	public String getSnapscreenInsertAlign() {
		return snapscreenInsertAlign;
	}
	public void setSnapscreenInsertAlign(String snapscreenInsertAlign) {
		this.snapscreenInsertAlign = snapscreenInsertAlign;
	}
	public List<String> getCatcherLocalDomain() {
		return catcherLocalDomain;
	}
	public void setCatcherLocalDomain(List<String> catcherLocalDomain) {
		this.catcherLocalDomain = catcherLocalDomain;
	}
	public String getCatcherActionName() {
		return catcherActionName;
	}
	public void setCatcherActionName(String catcherActionName) {
		this.catcherActionName = catcherActionName;
	}
	public String getCatcherFieldName() {
		return catcherFieldName;
	}
	public void setCatcherFieldName(String catcherFieldName) {
		this.catcherFieldName = catcherFieldName;
	}
	public String getCatcherPathFormat() {
		return catcherPathFormat;
	}
	public void setCatcherPathFormat(String catcherPathFormat) {
		this.catcherPathFormat = catcherPathFormat;
	}
	public String getCatcherUrlPrefix() {
		return catcherUrlPrefix;
	}
	public void setCatcherUrlPrefix(String catcherUrlPrefix) {
		this.catcherUrlPrefix = catcherUrlPrefix;
	}
	public long getCatcherMaxSize() {
		return catcherMaxSize;
	}
	public void setCatcherMaxSize(long catcherMaxSize) {
		this.catcherMaxSize = catcherMaxSize;
	}
	public List<String> getCatcherAllowFiles() {
		return catcherAllowFiles;
	}
	public void setCatcherAllowFiles(List<String> catcherAllowFiles) {
		this.catcherAllowFiles = catcherAllowFiles;
	}
	public String getVideoActionName() {
		return videoActionName;
	}
	public void setVideoActionName(String videoActionName) {
		this.videoActionName = videoActionName;
	}
	public String getVideoFieldName() {
		return videoFieldName;
	}
	public void setVideoFieldName(String videoFieldName) {
		this.videoFieldName = videoFieldName;
	}
	public String getVideoPathFormat() {
		return videoPathFormat;
	}
	public void setVideoPathFormat(String videoPathFormat) {
		this.videoPathFormat = videoPathFormat;
	}
	public String getVideoUrlPrefix() {
		return videoUrlPrefix;
	}
	public void setVideoUrlPrefix(String videoUrlPrefix) {
		this.videoUrlPrefix = videoUrlPrefix;
	}
	public long getVideoMaxSize() {
		return videoMaxSize;
	}
	public void setVideoMaxSize(long videoMaxSize) {
		this.videoMaxSize = videoMaxSize;
	}
	public List<String> getVideoAllowFiles() {
		return videoAllowFiles;
	}
	public void setVideoAllowFiles(List<String> videoAllowFiles) {
		this.videoAllowFiles = videoAllowFiles;
	}
	public String getFileActionName() {
		return fileActionName;
	}
	public void setFileActionName(String fileActionName) {
		this.fileActionName = fileActionName;
	}
	public String getFileFieldName() {
		return fileFieldName;
	}
	public void setFileFieldName(String fileFieldName) {
		this.fileFieldName = fileFieldName;
	}
	public String getFilePathFormat() {
		return filePathFormat;
	}
	public void setFilePathFormat(String filePathFormat) {
		this.filePathFormat = filePathFormat;
	}
	public String getFileUrlPrefix() {
		return fileUrlPrefix;
	}
	public void setFileUrlPrefix(String fileUrlPrefix) {
		this.fileUrlPrefix = fileUrlPrefix;
	}
	public long getFileMaxSize() {
		return fileMaxSize;
	}
	public void setFileMaxSize(long fileMaxSize) {
		this.fileMaxSize = fileMaxSize;
	}
	public List<String> getFileAllowFiles() {
		return fileAllowFiles;
	}
	public void setFileAllowFiles(List<String> fileAllowFiles) {
		this.fileAllowFiles = fileAllowFiles;
	}
	public String getImageManagerActionName() {
		return imageManagerActionName;
	}
	public void setImageManagerActionName(String imageManagerActionName) {
		this.imageManagerActionName = imageManagerActionName;
	}
	public String getImageManagerListPath() {
		return imageManagerListPath;
	}
	public void setImageManagerListPath(String imageManagerListPath) {
		this.imageManagerListPath = imageManagerListPath;
	}
	public int getImageManagerListSize() {
		return imageManagerListSize;
	}
	public void setImageManagerListSize(int imageManagerListSize) {
		this.imageManagerListSize = imageManagerListSize;
	}
	public String getImageManagerUrlPrefix() {
		return imageManagerUrlPrefix;
	}
	public void setImageManagerUrlPrefix(String imageManagerUrlPrefix) {
		this.imageManagerUrlPrefix = imageManagerUrlPrefix;
	}
	public String getImageManagerInsertAlign() {
		return imageManagerInsertAlign;
	}
	public void setImageManagerInsertAlign(String imageManagerInsertAlign) {
		this.imageManagerInsertAlign = imageManagerInsertAlign;
	}
	public List<String> getImageManagerAllowFiles() {
		return imageManagerAllowFiles;
	}
	public void setImageManagerAllowFiles(List<String> imageManagerAllowFiles) {
		this.imageManagerAllowFiles = imageManagerAllowFiles;
	}
	public String getFileManagerActionName() {
		return fileManagerActionName;
	}
	public void setFileManagerActionName(String fileManagerActionName) {
		this.fileManagerActionName = fileManagerActionName;
	}
	public String getFileManagerListPath() {
		return fileManagerListPath;
	}
	public void setFileManagerListPath(String fileManagerListPath) {
		this.fileManagerListPath = fileManagerListPath;
	}
	public String getFileManagerUrlPrefix() {
		return fileManagerUrlPrefix;
	}
	public void setFileManagerUrlPrefix(String fileManagerUrlPrefix) {
		this.fileManagerUrlPrefix = fileManagerUrlPrefix;
	}
	public int getFileManagerListSize() {
		return fileManagerListSize;
	}
	public void setFileManagerListSize(int fileManagerListSize) {
		this.fileManagerListSize = fileManagerListSize;
	}
	public List<String> getFileManagerAllowFiles() {
		return fileManagerAllowFiles;
	}
	public void setFileManagerAllowFiles(List<String> fileManagerAllowFiles) {
		this.fileManagerAllowFiles = fileManagerAllowFiles;
	}
}
