package com.ikm.xmanager.cms.task;

import com.ikm.xmanager.cms.service.impl.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * spring task 定时任务测试，适用于单系统
 * 注意：不适合用于集群
 * @author L.cm
 */
@Component
public class TestTask {
	protected Logger logger = LogManager.getLogger(getClass());
	
	@Autowired private CacheManager cacheManager;
	@Autowired private TestService testService;
//	@Autowired private RedisTemplate<String, Object> redisTemplate;
	
	@Scheduled(cron = "0 59 23 * * ?")
	public void cronTest() {
		System.out.println("测试定时任务！");
		// 测试手动存储cache
		Cache cache = cacheManager.getCache("hour");
		Integer xx = cache.get("x", new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return 111111;
			}
			
		});
		// 测试redis
//		redisTemplate.boundListOps("xxxx").leftPush("xxxx");
		
		// 测试注解
		testService.selectById(1L);
		testService.selectById(1L);
		testService.selectById(1L);
		
		logger.debug(xx);
		logger.debug(new Date());
	}
}
/**
 * cron表达式:
 *   "0 0 08 * * ?" 每天上午8点触发
 "0 15 10 ? * *" 每天上午10:15触发
 "0 15 10 * * ?" 每天上午10:15触发
 "0 15 10 * * ? *" 每天上午10:15触发
 "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
 "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
 "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
 "0 0/5 14-18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
 "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
 "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
 "0 15 10 15 * ?" 每月15日上午10:15触发
 "0 15 10 L * ?" 每月最后一日的上午10:15触发
 "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
 "0 15 10 ? * 6L 2009-2019" 2009年至2019年的每月的最后一个星期五上午10:15触发
 "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
 *
 * */