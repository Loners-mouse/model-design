package com.model.bigdata.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

    private static String REG_CHAR = "[0-9\\*\\/\\-\\+\\(\\)\\s]*";

    public InputHandler() {

    }

    //向后限制处理
    private static boolean checkAfter(char mid, char after) {
        boolean flag;
        switch (mid) {
            case '(':
                flag = after != '+' && after != ')';
                break;
            case ')':
                flag = after != '(';
                break;
            case '+':
                flag = after != ')';
                break;
            default:
                flag = true;

        }
        return flag;
    }

    public boolean checkInputModel(String input) {

        if (input == null || input.isEmpty()) {
            System.out.println("input failed is null! ");
            return false;
        }

        if (input.startsWith("fib")) {
            input = input.substring(3);
        }

        //检查具有特殊字符
        if (checkStr(input) && checkExpress(input) && checkCapBrackets(input)) {
            return true;
        } else {
            System.out.println("input check is failed! ");
            return false;
        }
    }

    public boolean checkStr(String input) {
        boolean flag = false;
        Pattern p = Pattern.compile(REG_CHAR);
        Matcher m = p.matcher(input);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }

    //括号成对检查
    public boolean checkCapBrackets(String input) {
        List<Integer> beforeBracket = new ArrayList<>();
        List<Integer> afterBracket = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                beforeBracket.add(i);
            }
            if (ch == ')') {
                afterBracket.add(i);
            }
        }
        if (beforeBracket.size() != afterBracket.size()) {
            return false;
        } else {
            for (int i = beforeBracket.size() - 1; i >= 0; i--) {
                int index = beforeBracket.get(i);
                Iterator<Integer> iterator = afterBracket.iterator();
                while (iterator.hasNext()) {
                    int afIndex = iterator.next();
                    if (index < afIndex) {
                        iterator.remove();
                        break;
                    }
                }
            }

        }
        return afterBracket.size() == 0 ? true : false;
    }

    //针对符号前后检查
    public boolean checkExpress(String input) {
        //去除空格
        input = input.replaceAll(" +", "");
        int len = input.length();
        if (len == 0) {
            return true;
        }
        if (len == 1) {
            char ch = input.charAt(0);
            if (ch == '(' || ch == ')' || ch == '+') {
                return false;
            }
            return true;
        }
        for (int i = 0; i < len - 1; i++) {
            char now = input.charAt(i);
            char after = input.charAt(i + 1);
            if (checkAfter(now, after)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
