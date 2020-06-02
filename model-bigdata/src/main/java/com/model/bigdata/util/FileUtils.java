package com.model.bigdata.util;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;

public class FileUtils {

    /**
     * 读取文件
     *
     * @Param filePath 文件路径
     */
    public static String readFile(String filePath) throws Exception {
        if (filePath == null || filePath.isEmpty()) {
            return "";
        }
        try {
            final File file = new File(filePath);
            final String text = Files.asCharSource(file, Charsets.UTF_8).read();
            return text;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 写入文件
     *
     * @Param filePath 文件路径
     * @Param value    文件内容
     */
    public static boolean writeFile(String filePath, String value) throws Exception {
        try {
            final File file = new File(filePath);
            Files.write(value.getBytes(Charsets.UTF_8), file);
        } catch (Exception e) {
            throw e;
        }

        return true;
    }

}
