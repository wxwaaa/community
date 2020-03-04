package com.wxw.community;

import com.wxw.community.dao.UserMapper;
import com.wxw.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectTest(){
        User user=userMapper.selectById(101);
        System.out.println(user);
        user=userMapper.selectByName("liubei");
        System.out.println(user);
        user=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }
}
