package com.daily.analysis.test;

import com.daily.analysis.model.mapper.TestUserMapper;
import com.daily.analysis.model.pojo.TestUser;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by dailinyi on 15/5/13.
 */
public class MybatisTest extends BasicTest {

    @Resource
    protected TestUserMapper testUserMapper;

    @Test
    public void testSearch(){
        TestUser testUser = testUserMapper.selectByPrimaryKey("1");
        System.out.println(testUser);
    }
}
