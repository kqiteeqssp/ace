package com.info.utils;

import java.lang.reflect.Field;

/**
 * @Author shisp
 * @Date 2018/11/26 18:27
 */
public class EntityToString {
    public static String getString( Class< ? > c )
    {
        String result = "";

        // 获取父类。推断是否为实体类
        if ( c.getSuperclass( ).getName( ).indexOf( "entity" ) >= 0 )
        {
            result +="\n<" +getString( c.getSuperclass( ) )+">,\n";
        }

        // 获取类中的全部定义字段
        Field[ ] fields = c.getDeclaredFields( );

        // 循环遍历字段，获取字段相应的属性值
        for ( Field field : fields )
        {
            // 假设不为空。设置可见性，然后返回
            field.setAccessible( true );

            try
            {
                // 设置字段可见，就可以用get方法获取属性值。

                result += field.getName( )  +",";
            }
            catch ( Exception e )
            {
                // System.out.println("error--------"+methodName+".Reason is:"+e.getMessage());
            }
        }
        if(result.indexOf( "," )>=0) result = result.substring( 0 , result.length( )-2 );
        return result;
    }
}
