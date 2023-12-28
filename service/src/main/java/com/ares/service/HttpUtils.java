package com.ares.service;

import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author fansheng
 * @date 2021/4/11
 */
@Slf4j
public class HttpUtils {



    /**
     * 获取 文件 流
     */
    public static byte[] getBytes(String url) {
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

    public static String post(String url, String body) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.connect();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8));
            writer.write(body);
            writer.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                }
                return result.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public static InputStream getInputStream(String url) {
        return new ByteArrayInputStream(getBytes(url));
    }

}
