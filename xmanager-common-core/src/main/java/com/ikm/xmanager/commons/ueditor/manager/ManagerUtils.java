package com.ikm.xmanager.commons.ueditor.manager;

import java.util.ArrayList;
import java.util.List;

class ManagerUtils {
	@SuppressWarnings("unchecked")
	protected static List<String> getAllowFiles(Object fileExt) {
		List<String> list = new ArrayList<String>();
		if (fileExt == null) {
			return list;
		}
		List<String> exts = (List<String>) fileExt;
		for (String ext : exts) {
			list.add(ext.replace(".", ""));
		}
		return list;
	}
}
