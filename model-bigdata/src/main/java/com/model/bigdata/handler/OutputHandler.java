package com.model.bigdata.handler;

import com.model.bigdata.model.OutputModel;
import com.model.bigdata.util.FileUtils;
import com.model.bigdata.util.JsonUtils;

public class OutputHandler {

    private OutputModel outputModel;

    public OutputHandler(OutputModel outputModel) {
        this.outputModel = outputModel;
    }

    public boolean handlerOutput(String path) {
        try {
            return FileUtils.writeFile(path, JsonUtils.toJson(outputModel));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
