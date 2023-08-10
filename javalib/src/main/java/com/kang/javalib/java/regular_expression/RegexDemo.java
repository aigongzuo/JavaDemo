package com.kang.javalib.java.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String regex = "((?:[^省]+自治区|.*?省|.*?行政区|.*?市))((?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县))?((?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛))?((?<town>[^区]+区|.+镇))?((?<village>.*)?)";
        String input = "新疆维吾尔自治区 昌吉回族自治州 昌吉市 新疆昌吉市建国西路华瑞城市花园9-6-502[6322]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String province = matcher.group(1);
            String city = matcher.group(2);
            String county = matcher.group(3);
            String town = matcher.group(4);
            String street = matcher.group(5);

            System.out.println("省：" + province);
            System.out.println("市：" + city);
            System.out.println("区/县：" + county);
            System.out.println("街道/路/巷/弄：" + street);
        } else {
            System.out.println("未匹配到地址信息");
        }
    }
}
