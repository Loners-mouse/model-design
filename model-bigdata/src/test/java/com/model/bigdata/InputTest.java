package com.model.bigdata;

import com.model.bigdata.handler.InputHandler;
import com.model.bigdata.model.InputModel;
import org.junit.Assert;
import org.junit.Test;

public class InputTest {

    @Test//读取文件内容测试
    public void checkFile() {
        //读取JSON文件成功
        String filePath = "D:/vcnem/code/github/model-design/model-bigdata/src/main/resources/test1.json";
        InputModel inputModel = AppService.setInputModel(filePath);
        Assert.assertEquals(inputModel.getInput(), "1+1");

        //读取JSON文件失败:内容为空
        filePath = "D:/vcnem/code/github/model-design/model-bigdata/src/main/resources/test2.json";
        inputModel = AppService.setInputModel(filePath);
        Assert.assertEquals(inputModel, null);

        //读取JSON文件失败:没有文件
        filePath = "D:/vcnem/code/github/model-design/model-bigdata/src/main/resources/test3.json";
        inputModel = AppService.setInputModel(filePath);
        Assert.assertEquals(inputModel, null);
    }

    @Test//表达式包含特殊字符
    public void checkStr() {
        //正常表达式包含数字，+、-、*、/ 和空格
        String input = "12+(10+20 ))(  +23+4";
        InputHandler inputHandler = new InputHandler();
        boolean flag = inputHandler.checkStr(input);
        Assert.assertTrue(flag);

        //特殊表达式包含字母、特殊字符！@#
        input = "12ad+(10+20 )+23+4";
        flag = inputHandler.checkStr(input);
        Assert.assertFalse(flag);

        input = "12#$+(10+20 )+23+4";
        flag = inputHandler.checkStr(input);
        Assert.assertFalse(flag);
    }

    @Test//表达式格式校验
    public void checkExpress() {

        String input = "12+(10+20 ))(  +23+4";
        InputHandler inputHandler = new InputHandler();
        boolean flag = inputHandler.checkExpress(input);
        Assert.assertFalse(flag);

        input = " ";
        flag = inputHandler.checkExpress(input);
        Assert.assertTrue(flag);

        input = "(";
        flag = inputHandler.checkExpress(input);
        Assert.assertFalse(flag);

        input = ")";
        flag = inputHandler.checkExpress(input);
        Assert.assertFalse(flag);

        input = "+";
        flag = inputHandler.checkExpress(input);
        Assert.assertFalse(flag);

        input = "1";
        flag = inputHandler.checkExpress(input);
        Assert.assertTrue(flag);

        input = "1+1";
        flag = inputHandler.checkExpress(input);
        Assert.assertTrue(flag);

        input = "120+(10+20 )+23+40+)";
        flag = inputHandler.checkExpress(input);
        Assert.assertFalse(flag);
    }

    @Test//表达式括号成对校验
    public void checkCapBrackets() {

        String input = "12+(10+20))(23+4";
        InputHandler inputHandler = new InputHandler();
        boolean flag = inputHandler.checkCapBrackets(input);
        Assert.assertFalse(flag);

        input = "(12+((10)+20))+(23+4)";
        flag = inputHandler.checkCapBrackets(input);
        Assert.assertTrue(flag);

        input = "120+(10+20 )+23+40+()";
        flag = inputHandler.checkCapBrackets(input);
        Assert.assertTrue(flag);
    }

    @Test//fib表达式错误处理
    public void fibExpress() {
        InputHandler inputHandler = new InputHandler();
        Assert.assertEquals(inputHandler.checkInputModel("fib((78+1)(+1)"), false);
    }

}
