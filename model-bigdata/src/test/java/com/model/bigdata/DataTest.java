package com.model.bigdata;

import com.model.bigdata.handler.DataHandler;
import org.junit.Assert;
import org.junit.Test;

public class DataTest {

    @Test//表达式处理：去除所有的（）和++
    public void replace() {
        String input = "(12+(10+20))+(23+4)";
        String reStr = new DataHandler(input).replace();
        Assert.assertEquals(reStr, "12+10+20+23+4");
    }

    @Test//表达式处理：转成数组
    public void split() {
        String input = "(12+(10+20))+(23+4)";
        DataHandler dataHandler = new DataHandler(input);
        String reStr = dataHandler.replace();
        String[] reStrs = dataHandler.splitStr(reStr);
        Assert.assertArrayEquals(reStrs, new String[]{"12", "10", "20", "23", "4"});
    }

    @Test//数据求和：小数据求和
    public void sumSmallData() {
        String input = "(12+(10+20))+(23+4)";
        DataHandler dataHandler = new DataHandler(input);
        String reStr = dataHandler.replace();
        String[] reStrs = dataHandler.splitStr(reStr);
        Assert.assertEquals(dataHandler.countSmallSum(reStrs), "69");
    }

    @Test//数据求和：大数据求和
    public void sumBigData() {
        String input = "(12+(10+20))+(23+4)";
        DataHandler dataHandler = new DataHandler(input);
        String reStr = dataHandler.replace();
        String[] reStrs = dataHandler.splitStr(reStr);
        Assert.assertEquals(dataHandler.countBigSum(reStrs), "69");

        input = "(1212121244551451455144+(1212121244551451455144+9212121244551451455144))+(9212121244551451455144+4)";
        DataHandler dataHandlers = new DataHandler(input);
        reStr = dataHandlers.replace();
        reStrs = dataHandlers.splitStr(reStr);
        System.out.println(dataHandlers.countBigSum(reStrs));
        Assert.assertEquals(dataHandler.countBigSum(reStrs), "20848484978205805820580");
    }
}
