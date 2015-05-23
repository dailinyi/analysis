package com.daily.analysis.test;

import com.daily.analysis.utils.PropertiesUtils;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * Created by dailinyi on 15/5/23.
 */
public class PropertiesUtilsTest {
    @Test
    public void testProperties(){
        System.out.println(PropertiesUtils.getProperty("config.default.server.charset"));
        System.out.println(Charset.forName(PropertiesUtils.getProperty("config.default.server.charset")).toString());
    }
}
