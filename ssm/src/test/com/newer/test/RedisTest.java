package com.newer.test;

import com.newer.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

public class RedisTest {

    @Test
    public void test1() {

        Jedis jedis = new Jedis("localhost", 6379);//连接Reids

        int i = 0;//记录次数

        try {
            long start = System.currentTimeMillis();//获取开始的毫秒数

            while (true) {
                long end = System.currentTimeMillis();//获取结束的毫秒数

                if (end - start >= 1000) { //大于一秒  操作结束
                    break;
                }
                i++;
            }

            jedis.set("test" + i, i + " ");

        } finally {
            jedis.close();//关闭连接
        }

        System.out.println("Redis每秒操作数:" + i + "次");

    }

    @Test
    public void test2(){
       //使用redisTemplate保存对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("redis.xml");

        RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);

        User user = new User();

        user.setUserName("吴彦祖");

        user.setPwd("123456");

        redisTemplate.opsForValue().set("user_1",user);

        User user1 = (User) redisTemplate.opsForValue().get("user_1");

        System.out.println(user1.getUserName());





    }
}
