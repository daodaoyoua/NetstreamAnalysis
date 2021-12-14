package service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

//关于Properties类常用的操作
public class dataProperties {
    //根据Key读取Value
    public static String GetValueByKey(String filePath, String key) {
        Properties pps = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            pps.load(in);
            String value = pps.getProperty(key);
            //System.out.println(key + " = " + value);
            return value;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //读取Properties的全部信息
    public static Map<String,Object> GetAllProperties(String filePath) throws IOException {
        Properties pps = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(filePath));
        pps.load(in);
        Enumeration en = pps.propertyNames(); //得到配置文件的名字
        Map<String,Object> map = new HashMap<>();
        while(en.hasMoreElements()) {
            String strKey = (String) en.nextElement();
            String strValue = pps.getProperty(strKey);
            map.put(strKey,strValue);
            //System.out.println(strKey + "=" + strValue);
        }
        return map;
    }

    //写入Properties信息
    public static void WriteProperties (String filePath, String pKey, String pValue) throws IOException {
        Properties pps = new Properties();

        InputStream in = new FileInputStream(filePath);
        //从输入流中读取属性列表（键和元素对）
        pps.load(in);
        //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
        //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
        OutputStream out = new FileOutputStream(filePath);
        pps.setProperty(pKey, pValue);
        //以适合使用 load 方法加载到 Properties 表中的格式，
        //将此 Properties 表中的属性列表（键和元素对）写入输出流
        pps.store(out, "Update " + pKey + " name");
    }
    public static void WriteProperties (String filePath, Map<String,Integer> map) throws IOException {
        Properties pps = new Properties();

        InputStream in = new FileInputStream(filePath);
        //从输入流中读取属性列表（键和元素对）
        pps.load(in);
        //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
        //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
        OutputStream out = new FileOutputStream(filePath);
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            pps.setProperty(entry.getKey(), entry.getValue().toString());
        }
        //pps.setProperty(pKey, pValue);
        //以适合使用 load 方法加载到 Properties 表中的格式，
        //将此 Properties 表中的属性列表（键和元素对）写入输出流
        pps.store(out, "Update " + " name");
    }
    public static void Clear(String filePath) throws IOException{
        Properties pps = new Properties();
        InputStream in = new FileInputStream(filePath);
        pps.load(in);
        pps.clear();
        OutputStream out = new FileOutputStream(filePath);
        pps.store(out, "Update " + " name");
    }
    public static void main(String [] args) throws IOException{
        //String value = GetValueByKey("Test.properties", "name");
        //System.out.println(value);
        //GetAllProperties("Test.properties");
//        WriteProperties("C:\\Users\\Mloong\\Desktop\\demo\\src\\main\\resources\\" +
//                "data.properties","tian", "212");
//        GetAllProperties("C:\\Users\\Mloong\\Desktop\\demo\\src\\main\\resources\\data.properties");
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        System.out.println(sdf.format(new Date((long) (1633873633.5892965* 1000))));
//        System.out.println(data.currentTime);
        //1.6340524188074884E9
        Clear("C:\\Users\\Mloong\\Desktop\\demo\\src\\main\\resources\\curent_time.properties");
    }
}
