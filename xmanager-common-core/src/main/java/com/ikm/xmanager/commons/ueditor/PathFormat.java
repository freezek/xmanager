package com.ikm.xmanager.commons.ueditor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文件路径格式化，使用UEditor的路径规则
 * @author L.cm
 */
public class PathFormat {
	private static final String TIME	   = "time";
	private static final String FULL_YEAR  = "yyyy";
	private static final String YEAR	   = "yy";
	private static final String MONTH	  = "mm";
	private static final String DAY		= "dd";
	private static final String HOUR	   = "hh";
	private static final String MINUTE	 = "ii";
	private static final String SECOND	 = "ss";
	private static final String RAND	   = "rand";

	/**
	 * 解析路径
	 * @param input 路径表达式
	 * @return 路径
	 */
	public static String parse(String input) {
		return PathFormat.parse(input, null);
	}

	/**
	 * 解析路径
	 * @param input 路径表达式
	 * @param filename 原文件名
	 * @return 路径
	 */
	public static String parse(String input, String filename) {
		Pattern pattern = Pattern.compile("\\{([^\\}]+)\\}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		Date currentDate = new Date();
		StringBuffer sb = new StringBuffer();
		String matchStr = null;
		while (matcher.find()) {
			matchStr = matcher.group(1);
			if (null != filename && matchStr.indexOf("filename") != -1) {
				filename = filename.replace("$", "\\$").replaceAll("[\\/:*?\"<>|]", "");
				matcher.appendReplacement(sb, filename);
			} else {
				matcher.appendReplacement(sb, PathFormat.getString(matchStr, currentDate));
			}
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	private static String getString(String pattern, Date currentDate) {
		pattern = pattern.toLowerCase();
		// time 处理
		if (pattern.indexOf(PathFormat.TIME) != -1) {
			return PathFormat.getTimestamp();
		} else if (pattern.indexOf(PathFormat.FULL_YEAR) != -1) {
			return PathFormat.format(currentDate, "yyyy");
		} else if (pattern.indexOf(PathFormat.YEAR) != -1) {
			return PathFormat.format(currentDate, "yy");
		} else if (pattern.indexOf(PathFormat.MONTH) != -1) {
			return PathFormat.format(currentDate, "MM");
		} else if (pattern.indexOf(PathFormat.DAY) != -1) {
			return PathFormat.format(currentDate, "dd");
		} else if (pattern.indexOf(PathFormat.HOUR) != -1) {
			return PathFormat.format(currentDate, "HH");
		} else if (pattern.indexOf(PathFormat.MINUTE) != -1) {
			return PathFormat.format(currentDate, "mm");
		} else if (pattern.indexOf(PathFormat.SECOND) != -1) {
			return PathFormat.format(currentDate, "ss");
		} else if (pattern.indexOf(PathFormat.RAND) != -1) {
			return PathFormat.getRandom(pattern);
		}
		return pattern;
	}

	private static String getTimestamp() {
		return String.valueOf(System.currentTimeMillis());
	}

	/**
	 * 格式化路径, 把windows路径替换成标准路径
	 * 
	 * @param input
	 *			待格式化的路径
	 * @return 格式化后的路径
	 */
	public static String format(String input) {
		return input.replace("\\", "/");
	}
	
	/**
	 * 日期格式化
	 * @param date 时间
	 * @param pattern 表达式
	 * @return 格式化后的时间
	 */
	private static String format(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	private static String getRandom(String pattern) {
		int length = 0;
		pattern = pattern.split(":")[1].trim();
		length = Integer.parseInt(pattern);
		return (Math.random() + "").replace(".", "").substring(0, length);
	}

}