package com.cumt.enterprise.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    private String datePattern;

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    public String getDatePattern() {
        return datePattern;
    }

    @Override
    public Date convert(String s) {
        if (null != s){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
            try {
                Date date = simpleDateFormat.parse(s);
                return date;
            } catch (ParseException e) {
                throw new RuntimeException("类型转换错误");
            }
        }else {
            throw new  RuntimeException("参数不能为空");
        }
    }
}
