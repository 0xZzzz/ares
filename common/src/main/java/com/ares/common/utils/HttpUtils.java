package com.ares.common.utils;

import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author fansheng
 * @date 2021/4/11
 */
@Slf4j
public class HttpUtils {

    /**
     * 获取 文件 流
     */
    public static byte[] getFile(String url) {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier((urlHostName, session) -> true);
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(4 * 1000);
            try (InputStream inStream = con.getInputStream();
                 ByteArrayOutputStream outStream = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                    outStream.flush();
                }
                byte[] data = outStream.toByteArray();
                outStream.flush();
                return data;
            }
        } catch (Exception e) {
            log.error("getFile error! url: {}", url, e);
            throw new RuntimeException("get bytes from url error!");
        }
    }

    public static void main(String[] args) {
        getFile("https://image-dev2.zacz.cn/tny/item/idcardImage/20210409/9cb8546d756fa2c72bf33fc6def3a5e8.jpg");
    }

}
