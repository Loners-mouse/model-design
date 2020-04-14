package cn.model.interpreter.impl;

import cn.model.interpreter.client.Expression;

/**
 * ABCDEFG 分别代表1234567
 */
public class Note extends Expression {

    @Override
    public void execute(String key, double value) {

        String note = "";
        switch (key) {
            case "A":
                note = "1";
                break;
            case "B":
                note = "2";
                break;
            case "C":
                note = "3";
                break;
            case "D":
                note = "4";
                break;
            case "E":
                note = "5";
                break;
            case "F":
                note = "6";
                break;
            case "G":
                note = "7";
                break;
            default:
                note = "0";
                break;
        }

        System.out.print(note + " ");
    }
}
