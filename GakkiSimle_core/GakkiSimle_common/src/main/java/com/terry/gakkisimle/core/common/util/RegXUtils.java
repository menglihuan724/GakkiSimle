package com.terry.gakkisimle.core.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by terrymeng
 */
public class RegXUtils {

    public static boolean ifMatch(String src, String regx) {
        String str = src;
        // 邮箱验证规则
        String regEx = regx;
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();

        return rs;
    }
}
