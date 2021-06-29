package service;

import java.text.SimpleDateFormat;
import java.util.Date;
public class test {
    public static void main(String[] args) {
        long timestamp = (long)(1624878745.0644886*1000);
        System.out.println(timestamp);
                             //1624881485868
        SimpleDateFormat sdf = new SimpleDateFormat();
        String sd = sdf.format(new Date(timestamp));
        System.out.println(sd);
        String k = "1.0";

        System.out.println("k="+(Double.valueOf(k)-1));
        System.out.println(System.currentTimeMillis());
        long stamp =System.currentTimeMillis();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        // 输出字符串
        System.out.println(df.format(new Date(timestamp)));
    }
}
