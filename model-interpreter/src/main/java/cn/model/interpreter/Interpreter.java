package cn.model.interpreter;

import cn.model.interpreter.client.Expression;
import cn.model.interpreter.impl.Note;
import cn.model.interpreter.impl.Scale;
import cn.model.interpreter.model.Context;

public class Interpreter {

    public static void main(String[] args) {

        Context context = new Context();

        context.setPlayText("O 1 E 2 D 4 F 2.5 A 1 ");

        Expression expression = null;

        while (context.getPlayText().length() > 0) {
            String value = context.getPlayText();
            String key = value.substring(0, 1);
            switch (key) {
                case "O":
                    expression = new Scale();
                    break;
                case "A":
                case "B":
                case "C":
                case "D":
                case "E":
                case "F":
                case "G":
                    expression = new Note();
                    break;
            }

            expression.Interpreter(context);
        }

    }
}
