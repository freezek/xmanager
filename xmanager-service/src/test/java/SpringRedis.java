import com.ikm.xmanager.cms.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Tom Chen on 2017/7/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-redis-service.xml","classpath:spring-config-service.xml" })
public class SpringRedis {

    @Resource(name = "redisTemplate")
    private RedisTemplate stringRedisTemplate;

    /**
     * redis 读写测试
     */
    @Test
    public void testSpringRedis() {

        try {
            // ApplicationContext context = new
            // ClassPathXmlApplicationContext("spring-redis.xml");
            // StringRedisTemplate stringRedisTemplate =
            // context.getBean("stringRedisTemplate",
            // StringRedisTemplate.class);
            // String读写
            stringRedisTemplate.delete("myStr");
            stringRedisTemplate.opsForValue().set("myStr", "http://aikaimen.com/");
            System.out.println(stringRedisTemplate.opsForValue().get("myStr"));
            System.out.println("---------------");

            // List读写
            stringRedisTemplate.delete("myList");
            stringRedisTemplate.opsForList().rightPush("myList", "A");
            stringRedisTemplate.opsForList().rightPush("myList", "B");
            stringRedisTemplate.opsForList().leftPush("myList", "0");
            List<String> listCache = stringRedisTemplate.opsForList().range("myList", 0, -1);
            for (String s : listCache) {
                System.out.println(s);
            }
            System.out.println("---------------");

            // Set读写
            stringRedisTemplate.delete("mySet");
            stringRedisTemplate.opsForSet().add("mySet", "A");
            stringRedisTemplate.opsForSet().add("mySet", "B");
            stringRedisTemplate.opsForSet().add("mySet", "C");
            Set<String> setCache = stringRedisTemplate.opsForSet().members("mySet");
            for (String s : setCache) {
                System.out.println(s);
            }
            System.out.println("---------------");

            // Hash读写
            stringRedisTemplate.delete("myHash");
            stringRedisTemplate.opsForHash().put("myHash", "PEK", "北京");
            stringRedisTemplate.opsForHash().put("myHash", "SHA", "上海虹桥");
            stringRedisTemplate.opsForHash().put("myHash", "PVG", "浦东");
            Map<Object, Object> hashCache = stringRedisTemplate.opsForHash().entries("myHash");
            for (Map.Entry<Object, Object> entry : hashCache.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            System.out.println("---------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * redis 得到所有的master and slave 信息
     */
    @Test
    public void testGetAllMasterAndSlave() {

        RedisSentinelConnection conn = stringRedisTemplate.getConnectionFactory().getSentinelConnection();

        for (RedisServer master : conn.masters()) {
            System.out.println("master => " + master);// 打印master信息
            Collection<RedisServer> slaves = conn.slaves(master);
            // 打印该master下的所有slave信息
            for (RedisServer slave : slaves) {
                System.out.println("slaves of " + master + " => " + slave);
            }
            System.out.println("--------------");
        }
    }

    /*
     * 测试redis 缓存object 和 list 类型数据(方案：用json将object和list序列化)
     */
    @Test
    public void testRedisCacheObjectAndList() {

        User user1 = new User();
//      // fastJson 序列化
//      String jsonStr = JSONObject.toJSONString(user1);
//      System.out.println(">>>>>>>>>>>>>>>>" + jsonStr);
//      // fastJson 反序列化
//      user1 = JSONObject.parseObject(jsonStr, User.class);
//      System.out.println(">>>>>>>>>>>>>>>>>>" + user1);

        stringRedisTemplate.delete("user1");
        // 将object 用 json 序列化后保存redis
//        stringRedisTemplate.opsForValue().set("user1", JSONObject.toJSONString(user1));
//
//        user1 = JSONObject.parseObject(stringRedisTemplate.opsForValue().get("user1"), User.class);
        System.out.println("-----------------------" + user1);
    }
    /**测试redis客户端*/
    @Test
    public void testRedis(){

        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.set("name", "mrdg");
        jedis.set("age", "24");

        System.out.println("name:"+jedis.get("name"));
        System.out.println("age:"+jedis.get("age"));
        System.out.println("tel:"+jedis.get("Tel"));
        System.out.println("no:"+jedis.get("No"));
    }
    /**测试redis集群方案*/
    @Test
    public void testCluster(){

        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("192.168.12.90", 7001));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("foo", "bar");
        String value = jc.get("foo");

        System.out.println(value);
        try {
            jc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
