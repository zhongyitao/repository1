package com.cumt.enterprise.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类型转换工具类
 */
public class TypeConversionUtils {

    /**
     * 日期类型转字符串
     * @param date
     * @param datePattern 转换格式
     * @return
     */
    public static String dateToString(Date date,String datePattern){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        return simpleDateFormat.format(date);
    }

}
