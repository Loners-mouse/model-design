package com.model.bigdata.handler;

import java.util.Stack;

public class StackData {

    private static Stack<Character> stack = new Stack<>();

    private static String INPUT_DATA = "(1+(42+5+22)+3)+(6+8)";

    public static void handler() {
        int size = INPUT_DATA.length();
        for (int i = 0; i < size; i++) {
            char ch = INPUT_DATA.charAt(i);
            if (ch == ')') {
                getPop();
            } else {
                stack.push(ch);
            }
        }

        System.out.println(cal());
    }

    public static void getPop() {
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        while (stack.size() > 0) {
            char ch = stack.pop();
            if (ch == '(') {
                break;
            } else if (ch == '+') {
                sb.reverse();
                sum += Integer.parseInt(sb.toString());
                sb = new StringBuffer();
            } else {
                sb.append(ch);
            }
        }
        sb.reverse();
        sum += Integer.parseInt(sb.toString());
        char[] chs = String.valueOf(sum).toCharArray();
        for (int i = 0; i < chs.length; i++)
            stack.push(chs[i]);
    }

    public static String cal() {
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        while (stack.size() > 0) {
            char ch = stack.pop();
            if (ch == '+') {
                sb.reverse();
                sum += Integer.parseInt(sb.toString());
                sb = new StringBuffer();
            } else {
                sb.append(ch);
            }
        }
        sb.reverse();
        sum += Integer.parseInt(sb.toString());
        return sum + "";
    }
}
