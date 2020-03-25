package com.ares.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author fansheng
 * @date 2020/2/25
 */
public class Test {

    public static void main(String[] args) {
        String str = "[{\"type\": \"select\",\"value\": [\"3\", \"6\", \"12\", \"24\", \"36\"],\"key\": \"period\","
            + "\"name\": \"分期数\"}]";
        for (JSONObject json : JSONArray.parseArray(str, JSONObject.class)) {
            Map<String, String> extra = Maps.newHashMap();
            if (StringUtils.isNotBlank(json.getString("key"))) {
                extra.put("key", json.getString("key"));
            }
            if (StringUtils.isNotBlank(json.getString("value"))) {
                extra.put("value", json.getString("value"));
            }
            if (StringUtils.isNotBlank(json.getString("name"))) {
                extra.put("name", json.getString("name"));
            }
            if (StringUtils.isNotBlank(json.getString("type"))) {
                extra.put("type", json.getString("type"));
            }
            System.out.println(extra);
        }
    }

}
