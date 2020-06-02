package com.model.bigdata;

public class UserApp {

    //端到端实现
    public static void main(String[] args) {
        String inputPath = "D:/vcnem/code/github/model-design/model-bigdata/src/main/resources/testsuit.json";
        String outputPath = "D:/vcnem/code/github/model-design/model-bigdata/src/main/resources/testout.json";
        AppService.handler(inputPath, outputPath);
    }

}
