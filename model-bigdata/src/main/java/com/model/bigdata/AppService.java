package com.model.bigdata;

import com.model.bigdata.handler.DataHandler;
import com.model.bigdata.handler.FibHandler;
import com.model.bigdata.handler.InputHandler;
import com.model.bigdata.handler.OutputHandler;
import com.model.bigdata.model.InputModel;
import com.model.bigdata.model.OutputModel;
import com.model.bigdata.util.FileUtils;
import com.model.bigdata.util.JsonUtils;

public class AppService {

    public static void handler(String inputPath, String outputPath) {
        //输入端设置
        InputModel inputModel = setInputModel(inputPath);


        if (!handlerInput(inputModel)) {
            return;
        }
        String input = inputModel.getInput();
        //数据处理
        String output = "";
        if (input.startsWith("fib")) {
            output = handlerFib(input);
        } else {
            output = handlerData(input);
        }

        //输出结果
        boolean isFin = handlerOutput(outputPath, output);
        System.out.println("write file success is " + isFin);
    }

    public static InputModel setInputModel(String filePath) {
        String json = "";
        try {
            json = FileUtils.readFile(filePath);
        } catch (Exception e) {
            System.out.println("model input failed e= " + e.getMessage());
        }
        return JsonUtils.toObject(json, InputModel.class);
    }

    public static boolean handlerInput(InputModel inputModel) {
        if (inputModel == null) {
            return false;
        }
        InputHandler inputHandler = new InputHandler();
        return inputHandler.checkInputModel(inputModel.getInput());
    }

    public static String handlerData(String input) {
        DataHandler dataHandler = new DataHandler(input);
        return dataHandler.countBigSum(dataHandler.splitStr(dataHandler.replace()));
    }

    public static String handlerFib(String input) {
        FibHandler dataHandler = new FibHandler(input);
        return dataHandler.handler();
    }

    public static boolean handlerOutput(String path, String output) {
        OutputModel outputModel = new OutputModel();
        outputModel.setOutput(output);
        OutputHandler outputHandler = new OutputHandler(outputModel);
        return outputHandler.handlerOutput(path);
    }
}
