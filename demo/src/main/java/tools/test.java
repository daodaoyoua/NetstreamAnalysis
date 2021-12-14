package tools;

import service.dataProperties;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class test {
    public static void main(String[] args) {
        //String file_current_time = "C:\\Users\\Mloong\\Desktop\\demo\\src\\main\\resources\\curent_time.properties";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(new Date((long) (1633873633.5892965* 1000))));

        System.out.println(sdf.format(new Date((long) (1634198461.1878195* 1000)))); //
    }
}
