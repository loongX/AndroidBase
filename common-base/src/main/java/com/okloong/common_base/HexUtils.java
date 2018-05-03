/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.okloong.common_base;

import java.io.UnsupportedEncodingException;

public class HexUtils {
    private static final char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] emptybytes = new byte[0];

    public HexUtils() {
    }

    /**
     * 但字节转换成字符串
     * @param b
     * @return
     */
    public static String byte2HexStr(byte b) {
        char[] buf = new char[]{'\u0000', digits[b & 15]};
        b = (byte)(b >>> 4);
        buf[0] = digits[b & 15];
        return new String(buf);
    }

    /**
     * 字节转换成16进制字符串
     * @param bytes
     * @return
     */
    public static String bytes2HexStr(byte[] bytes) {
        if(bytes != null && bytes.length != 0) {
            char[] buf = new char[2 * bytes.length];

            for(int i = 0; i < bytes.length; ++i) {
                byte b = bytes[i];
                buf[2 * i + 1] = digits[b & 15];
                b = (byte)(b >>> 4);
                buf[2 * i + 0] = digits[b & 15];
            }

            return new String(buf);
        } else {
            return null;
        }
    }

    /**
     * bcd字符扩展两倍到16进制字符串
     * @param bytes
     * @param offset  开始
     * @param count   数量
     * @return
     */
    public static String bytes2HexStr(byte[] bytes, int offset, int count) {
          if(bytes != null && bytes.length != 0) {
            char[] buf = new char[2 * count];
            int size = offset + count;

            for(int i = offset, j = 0; i < size; ++i,j++) {
                byte b = bytes[i];
                buf[2 * j + 1] = digits[b & 15];
                b = (byte)(b >>> 4);
                buf[2 * j + 0] = digits[b & 15];
            }

            return new String(buf);
        } else {
            return null;
        }
    }

    /**
     * 十六进制数转换成十进制数，单字符，超出范围的值为0
     * @param str string类型
     * @return
     */
    public static byte hexStr2Byte(String str) {
        return str != null && str.length() == 1?char2Byte(str.charAt(0)):0;
    }

    /**
     * 48-57:0-9
     * 65-70:A-F
     * 97-102:a-f
     * 十六进制数转换成十进制数，单字符，超出范围的值为0
     * @param ch char类型
     * @return
     */
    public static byte char2Byte(char ch) {
        return ch >= 48 && ch <= 57?(byte)(ch - 48):(ch >= 97 && ch <= 102?(byte)(ch - 97 + 10):(ch >= 65 && ch <= 70?(byte)(ch - 65 + 10):0));
    }

    /**
     * 16进制字符串转bcd数组
     * @param str
     * @return
     */
    public static byte[] hexStr2Bytes(String str) {
        if(str != null && !str.equals("")) {
            byte[] bytes = new byte[str.length() / 2];

            for(int i = 0; i < bytes.length; ++i) {
                char high = str.charAt(i * 2);
                char low = str.charAt(i * 2 + 1);
                bytes[i] = (byte)(char2Byte(high) * 16 + char2Byte(low));
            }

            return bytes;
        } else {
            return emptybytes;
        }
    }

    public static void main(String[] args) {
        try {
            byte[] bytes = "Hello WebSocket World?".getBytes("gbk");
            System.out.println(bytes2HexStr(bytes));
        } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
        }

    }
}