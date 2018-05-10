package com.ancrazyking.conversion;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 转换日期的类型
 * S:页面传递过来的类型
 * T:转换后的类型
 * @author Ancrazyking
 * @date 2018/5/10 21:03
 **/
public class DateConveter implements Converter<String,Date>
{
    @Override
    public Date convert(String s)
    {
        try{
            if(null!=s){
                DateFormat df=new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
                return df.parse(s);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
