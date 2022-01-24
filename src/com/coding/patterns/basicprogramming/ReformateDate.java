package com.coding.patterns.basicprogramming;

import java.util.HashMap;
import java.util.Map;

public class ReformateDate {
    private static Map<String, String> getMonths() {
        HashMap<String, String> months = new HashMap<String, String>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        return months;
    }

    public static String reformatDate(String date) {
        Map<String, String> months = getMonths();
        String[] ss = date.split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append(ss[2]).append("-");
        sb.append(months.get(ss[1])).append("-");
        sb.append(ss[0].length() == 3 ? ("0" + ss[0].substring(0, 1)) : (ss[0].substring(0, 2)));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformatDate("20th Oct 2052"));
    }
}
