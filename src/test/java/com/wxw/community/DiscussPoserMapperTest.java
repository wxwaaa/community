package com.wxw.community;

import com.wxw.community.dao.DiscussPostMapper;
import com.wxw.community.entity.DiscussPost;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.DISCARDING;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class DiscussPoserMapperTest {
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void selectDiscussPostsTest(){
       List<DiscussPost> list=discussPostMapper.selectDiscussPosts(0,0,10);
        for (DiscussPost d:list) {
            System.out.println(d);
        }
    }
    @Test
    public void selectDiscussPostRowsTest(){
        int count =discussPostMapper.selectDiscussPostRows(0);
        System.out.println(count);
    }
}
