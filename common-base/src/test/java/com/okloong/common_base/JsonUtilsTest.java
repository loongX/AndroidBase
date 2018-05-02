package com.okloong.common_base;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by loongago on 2018-5-1 0001.
 */
public class JsonUtilsTest {

    JSONObject obj;

    @Before
    public void setUp() throws Exception {
        obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));
        //{"balance": 1000.21, "num":100, "is_vip":true, "name":"foo"}

        System.out.println(obj);

        //解析对象
        JSONObject jsonObjectx = new JSONObject("{'Name':'Tom','age':'11'}");
        JSONObject jsonObjectx2 = new JSONObject();
        jsonObjectx2.put("jsonObject", jsonObjectx);

        System.out.println("解析对象:");
        System.out.println(jsonObjectx2.getJSONObject("jsonObject").toString());

        JSONObject jsonObject = new JSONObject("{'Name':'Tom','age':'11'}");
        JSONArray jsonArray = new JSONArray("['abc','xyz']");

        //JSONObject内嵌JSONObject
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("object1", jsonObject);
        jsonObject1.put("object2", jsonObject);

        //JSONObject内嵌JSONArray
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("JSONArray1", jsonArray);
        jsonObject2.put("JSONArray2", jsonArray);

        //JSONArray内嵌JSONArray
        JSONArray jsonArray1 = new JSONArray();
        jsonArray1.put(jsonArray);
        jsonArray1.put(jsonArray);

        //JSONArray内嵌JSONObject
        JSONArray jsonArray2 = new JSONArray();
        jsonArray2.put(jsonObject);
        jsonArray2.put(jsonObject);

        System.out.println("JSONObject内嵌JSONObject:" + "\n" + jsonObject1.toString());
        System.out.println("JSONObject内嵌JSONArray:" + "\n" + jsonObject2.toString());
        System.out.println("JSONArray内嵌JSONArray:" + "\n" + jsonArray1.toString());
        System.out.println("JSONArray内嵌JSONObject:" + "\n" + jsonArray2.toString());
    }

    @Test
    public void getBoolean() throws Exception {
        assertEquals("获取Json Boolean", JsonUtils.getBoolean(obj,"is_vip",false), true);
    }

    @Test
    public void getInteger() throws Exception {
        assertEquals("获取Json Integer", JsonUtils.getInteger(obj,"num",0), 100);
    }

    @Test
    public void getString() throws Exception {
        assertEquals("获取Json String", JsonUtils.getString(obj,"name","null"), "foo");
    }

}