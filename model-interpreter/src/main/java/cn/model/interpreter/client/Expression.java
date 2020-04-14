package cn.model.interpreter.client;

import cn.model.interpreter.model.Context;

public abstract class Expression {

    public void Interpreter(Context context) {
        if (context.getPlayText().length() == 0) {
            return;
        } else {
            String key = context.getPlayText().substring(0, 1);
            String value = context.getPlayText().substring(2);
            String outValue = value.substring(0, value.indexOf(" "));
            double doubleValue = Double.parseDouble(outValue);
            context.setPlayText(value.substring(value.indexOf(" ") + 1));
            execute(key, doubleValue);
        }

    }

    protected abstract void execute(String key, double value);
}
