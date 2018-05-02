package com.okloong.common_base;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

/**
 * @author pxl
 * @date 5/2 0002
 * @time 下午 3:57.
 */
public class HexUtilsTest {
    byte[] bytes ;
    @Before
    public void setUp() throws Exception {
        try {
            bytes = "Hello WebSocket World?".getBytes("gbk");
            System.out.println(HexUtils.bytes2HexStr(bytes));
        } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void byte2HexStr() throws Exception {

    }

    @Test
    public void bytes2HexStr() throws Exception {
        assertEquals("HexUtils 字节转16进制", HexUtils.bytes2HexStr(bytes), "48656C6C6F20576562536F636B657420576F726C643F");
    }

    @Test
    public void bytes2HexStr1() throws Exception {
    }

    @Test
    public void hexStr2Byte() throws Exception {
    }

    @Test
    public void char2Byte() throws Exception {
    }

    @Test
    public void hexStr2Bytes() throws Exception {
    }

}