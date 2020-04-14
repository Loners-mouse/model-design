package cn.model.interpreter.impl;

import cn.model.interpreter.client.Expression;

/**
 * 123 慢中高
 */
public class Scale extends Expression {

    @Override
    protected void execute(String key, double value) {
        String outValue = "";
        int scale = (int) value;

        switch (scale) {
            case 1:
                outValue = "慢速";
                break;
            case 2:
                outValue = "中速";
                break;
            case 3:
                outValue = "高速";
                break;
            default:
                outValue = "xx";
        }
        System.out.print(outValue + " ");
    }
}
