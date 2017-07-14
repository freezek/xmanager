package com.ikm.test;


import com.ikm.xmanager.cms.model.User;
import com.ikm.xmanager.commons.utils.BeanProperty;
import com.ikm.xmanager.commons.utils.BeanUtils;
import com.ikm.xmanager.commons.utils.JsonUtils;

/**
 * cglib生成bean，给bean动态添加字段
 * @author L.cm
 */
public class BeanGeneratorTest {

	public static void main(String[] args) {
		// 新字段的名称和类型
		BeanProperty beanProp = new BeanProperty("$row", Integer.class);
		// 生成新Bean
		Object object = BeanUtils.generator(User.class, beanProp);
		
		User user = new User();
		user.setAge(10);
		user.setName("张三");
		// 结合copy使用，为新Bean copy字段，爽歪歪
		BeanUtils.copy(user, object);
		// 结合setProperty为新Bean设置字段
		BeanUtils.setProperty(object, "$row", 10);
		
		System.out.println(JsonUtils.toJson(object));
	}

}
