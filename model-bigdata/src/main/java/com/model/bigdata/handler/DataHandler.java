package com.model.bigdata.handler;

public class DataHandler {

    private String data;

    public DataHandler(String data) {
        this.data = data;
    }

    public static int getIndex(String sum) {
        int index = 0;
        for (int i = 0; i < sum.length(); i++) {
            if (sum.charAt(i) != '0') {
                index = i;
                break;
            }
        }
        return index;
    }

    public static String countBigData(String first, String second) {
        int lenFirst = first.length();
        int lenSecond = second.length();
        int len = Math.max(lenFirst, lenSecond);
        int[] firstData = new int[len];
        int[] secondData = new int[len];
        for (int i = 0; i < lenFirst; i++) {
            firstData[lenFirst - 1 - i] = Integer.parseInt(first.substring(i, i + 1));
        }
        for (int i = 0; i < lenSecond; i++) {
            secondData[lenSecond - 1 - i] = Integer.parseInt(second.substring(i, i + 1));
        }
        int[] sumi = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sumi[i] = firstData[i] + secondData[i];
        }
        for (int i = 0; i < len; i++) {
            sumi[i + 1] = sumi[i] / 10 + sumi[i + 1];
            sumi[i] = sumi[i] % 10;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = len; i >= 0; i--) {
            sb.append(sumi[i]);
        }
        return sb.toString();
    }

    public String replace() {
        return data.replace("(", "")
                .replace(")", "")
                .replace("++", "+");
    }

    public String[] splitStr(String data) {
        return data.split("\\+");
    }

    public String countSmallSum(String[] datas) {
        int sum = 0;
        for (int i = 0; i < datas.length; i++) {
            sum += Integer.parseInt(datas[i]);
        }
        return String.valueOf(sum);
    }

    public String countBigSum(String[] datas) {
        String sum = "0";
        for (int i = 0; i < datas.length; i++) {
            sum = countBigData(sum, datas[i]);
        }

        int index = getIndex(sum);

        return sum.substring(index);
    }
}
