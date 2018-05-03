package com.okloong.common;

import com.okloong.commom.HexUtils;

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

 //       System.out.println(HexUtils.bytes2HexStr(bytes, 2, 5));
 //      System.out.println(HexUtils.hexStr2Bytes("Hello WebSocket World?"));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void byte2HexStr() throws Exception {
        assertEquals("HexUtils 单字节转16进制字符串", HexUtils.byte2HexStr(bytes[0]), "48");
    }

    @Test
    public void bytes2HexStr() throws Exception {
        assertEquals("HexUtils 字节转16进制字符串", HexUtils.bytes2HexStr(bytes), "48656C6C6F20576562536F636B657420576F726C643F");
    }

    @Test
    public void bytes2HexStr1() throws Exception {
        assertEquals("HexUtils 字节转16进制字符串，可控长度", HexUtils.bytes2HexStr(bytes, 2, 5), "6C6C6F2057");
    }

    @Test
    public void hexStr2Byte() throws Exception {
        byte h2b = 0xf;
        assertEquals("十六进制数转换成十进制数，单字符，超出范围的值为0", HexUtils.hexStr2Byte("F"), h2b);
    }

    @Test
    public void char2Byte() throws Exception {
        byte c2b = 0xa;
        assertEquals("十六进制数转换成十进制数，单字符，超出范围的值为0", HexUtils.char2Byte("a".charAt(0)), c2b);
    }

    @Test
    public void hexStr2Bytes() throws Exception {
        byte[] h2b = {(byte) 0xab, (byte) 0xcd};
        assertArrayEquals("16进制字符串转bcd数组", HexUtils.hexStr2Bytes("abcd"), h2b);
    }

}