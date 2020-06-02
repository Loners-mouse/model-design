package com.model.bigdata;

import com.model.bigdata.handler.OutputHandler;
import com.model.bigdata.model.OutputModel;
import org.junit.Assert;
import org.junit.Test;

public class OutputTest {

    @Test
    public void write() {
        OutputModel outputModel = new OutputModel();
        outputModel.setOutput("1");
        OutputHandler outputHandler = new OutputHandler(outputModel);
        String path = "D:/vcnem/code/github/model-design/model-bigdata/src/main/resources/testout.json";
        Assert.assertTrue(outputHandler.handlerOutput(path));
    }

}
