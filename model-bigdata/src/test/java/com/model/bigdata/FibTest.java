package com.model.bigdata;

import com.model.bigdata.handler.FibHandler;
import org.junit.Assert;
import org.junit.Test;

public class FibTest {

    @Test//FIB：算法测试
    public void fib() {
        Assert.assertEquals(FibHandler.fib(0), "0");
        Assert.assertEquals(FibHandler.fib(1), "1");
        Assert.assertEquals(FibHandler.fib(2), "1");
        Assert.assertEquals(FibHandler.fib(80), "23416728348467685");
        Assert.assertEquals(FibHandler.fib(800), "69283081864224717136290077681328518273399124385204820718966040597691435587278383112277161967532530675374170857404743017623467220361778016172106855838975759985190398725");
    }

    @Test//长度大于800不处理
    public void len800() {
        FibHandler fibHandler = new FibHandler("fib(801)");
        Assert.assertEquals(fibHandler.handler(), null);
    }

    @Test//长度小于800处理
    public void little() {
        FibHandler fibHandler = new FibHandler("fib((78+1)+1)");
        Assert.assertEquals(fibHandler.handler(), "23416728348467685");
    }
}
