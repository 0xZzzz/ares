package com.ares.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Objects;

/**
 * @author fansheng
 * @date 2023/1/10
 */
public class CodeLines {

    private static long lines = 0;
    private static long files = 0;

    public static void main(String[] args) {
        File root = new File("absolute path");
        count(root);
        System.out.println(lines);
        System.out.println(files);
    }

    private static void count(File dir) {
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isDirectory()) {
                count(file);
            } else if (file.getName().endsWith(".java")) {
                files++;
                try (InputStream is = Files.newInputStream(file.toPath());
                     InputStreamReader isr = new InputStreamReader(is);
                     BufferedReader br = new BufferedReader(isr)) {
                    lines += br.lines().count();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
