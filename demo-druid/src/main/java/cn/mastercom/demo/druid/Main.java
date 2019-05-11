package cn.mastercom.demo.druid;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        for (String arg:args)
            System.out.println(arg);
    }
    public static String stringTwoDimensionalArraySort(String srcString, String delimiterLeftOut,
                                                       String delimiterRightOut, String delimiterGroup, String delimiterLeftIn, String delimiterRightIn,
                                                       String delimiterInGroup) {
        if (isEmpty(srcString))
            return null;
        String srcArrsString = srcString.substring(delimiterLeftOut.length(),
                srcString.length() - delimiterRightOut.length());
        TreeMap<String, String> sortMap = new TreeMap<>();
        List<String> srcArrs = new LinkedList<>();
        int from = 0;
        int to = 0;
        for (int end = srcArrsString.length() - 1; to < end;) {
            from = srcArrsString.indexOf(delimiterLeftIn, to);
            to = srcArrsString.indexOf(delimiterRightIn, to);
            srcArrs.add(srcArrsString.substring(from, ++to));
        }
        for (String arr : srcArrs) {
            String[] srcArr = arr.substring(delimiterLeftIn.length(), arr.length() - delimiterRightIn.length())
                    .split(delimiterInGroup);
            sortMap.put(srcArr[0], srcArr[1]);
        }
        StringBuilder sbResult = new StringBuilder(delimiterLeftOut);
        boolean firstAdd = true;
        for ( Map.Entry<String, String> arr : sortMap.entrySet()) {
            if (firstAdd)
                firstAdd = false;
            else
                sbResult.append(delimiterGroup);
            sbResult.append(delimiterLeftIn).append(arr.getKey()).append(delimiterInGroup).append(arr.getValue())
                    .append(delimiterRightIn);
        }
        sbResult.append(delimiterRightOut);
        return sbResult.toString();
    }
    public static boolean isEmpty(String srcString) {
        return (srcString == null || srcString.trim().isEmpty());
    }
    }
