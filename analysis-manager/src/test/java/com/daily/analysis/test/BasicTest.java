package com.daily.analysis.test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dailinyi on 15/5/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
//@ContextConfiguration(locations = {"file: webapp/WEB-INF/web.xml"})
public class BasicTest {
    @Before
    public void before(){
        System.out.println("------begin a testing class------");
    }

    @After
    public void after(){
        System.out.println("------end a testing class------");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("------begin testing------");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("------end testing------");
    }
}
