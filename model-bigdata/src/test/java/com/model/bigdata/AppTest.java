package com.model.bigdata;

import org.junit.Test;

public class AppTest {

    @Test//测试用户输入的基本加减法
    public void app1() {
        String inputPath = "D:/vcnem/code/github/model-design/model-bigdata/src/main/resources/basetest.json";
        String outputPath = "D:/vcnem/code/github/model-design/model-bigdata/src/main/resources/baseout.json";
        AppService.handler(inputPath, outputPath);
    }

    @Test//测试用户输入的fib
    public void app2() {
        String inputPath = "D:/vcnem/code/github/model-design/model-bigdata/src/main/resources/testsuit.json";
        String outputPath = "D:/vcnem/code/github/model-design/model-bigdata/src/main/resources/testout.json";
        AppService.handler(inputPath, outputPath);
    }
}
