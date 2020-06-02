package com.model.bigdata.handler;

public class FibHandler {

    private String input;

    public FibHandler(String input) {
        this.input = input;
    }

    public static String fib(int n) {
        if (n == 0 || n == 1) {
            return n + "";
        }
        String f0 = "0";
        String f1 = "1";
        String sum = "0";
        for (int i = 2; i <= n; i++) {
            sum = DataHandler.countBigData(f0, f1);
            f0 = f1;
            f1 = sum;
        }
        int index = DataHandler.getIndex(sum);
        return sum.substring(index);
    }

    public String handler() {
        DataHandler dataHandler = new DataHandler(input.substring(3));
        String sum = dataHandler.countBigSum(dataHandler.splitStr(dataHandler.replace()));
        if (sum.length() > 3 || Integer.parseInt(sum) > 800) {
            System.out.println("fib length >800" + sum);
            return null;
        } else {
            return fib(Integer.parseInt(sum));
        }

    }
}
