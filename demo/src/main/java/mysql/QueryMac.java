package mysql;

import grpc.NSbody;
import grpc.NShead;
import grpc.NetStream;
import service.data;
import tools.MysqlTool;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;


public class QueryMac {
    public static Map<String,Object> selectMac(String mac) {
        Connection connection = MysqlTool.getConnection();
        Map<String,Object> map = new LinkedHashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        String select_mac = "select (\n" +
                "           case\n" +
                "               when T between max-3 and max THEN max     # 1\n" +
                "               when T between max-6 and max-3 THEN max-3 # 2\n" +
                "               when T between max-9 and max-6 THEN max-6 # 3\n" +
                "               when T between max-12 and max-9 THEN max-9 # 4\n" +
                "               when T between max-15 and max-12 THEN max-12 # 5\n" +
                "               when T between max-18 and max-15 THEN max-15 # 6\n" +
                "               when T between max-21 and max-18 THEN max-18 # 7\n" +
                "               when T between max-24 and max-21 THEN max-21 # 8\n" +
                "               when T between max-27 and max-24 THEN max-24 # 9\n" +
                "               else max-27\n" +
                "               end) time,sum(Size) size\n" +
                "from (select End_time T,Byte_count Size,? max\n" +
                "      from body\n" +
                "    where End_time between ?-30 and ?\n" +
                "    AND In_interface = ?\n" +
                "            ) mybody\n" +
                "group by(\n" +
                "    case\n" +
                "    when T between max-3 and max THEN max     # 1\n" +
                "    when T between max-6 and max-3 THEN max-3 # 2\n" +
                "    when T between max-9 and max-6 THEN max-6 # 3\n" +
                "    when T between max-12 and max-9 THEN max-9 # 4\n" +
                "    when T between max-15 and max-12 THEN max-12 # 5\n" +
                "    when T between max-18 and max-15 THEN max-15 # 6\n" +
                "    when T between max-21 and max-18 THEN max-18 # 7\n" +
                "    when T between max-24 and max-21 THEN max-21 # 8\n" +
                "    when T between max-27 and max-24 THEN max-24 # 9\n" +
                "    else max-27\n" +
                "end) order by time ;";
        try {

            PreparedStatement st = connection.prepareStatement(select_mac);
            //int  i = 1;

            //st = connection.prepareStatement(select_ip);
            double current_time = Double.valueOf(service.dataProperties.GetValueByKey("C:\\Users\\Mloong\\Desktop\\" +
                    "demo\\src\\main" + "\\resources\\curent_time.properties","current_time"));
            System.out.println(current_time);
            st.setDouble(1, current_time);
            st.setDouble(2, current_time);
            st.setDouble(3, current_time);
            st.setString(4, mac);
            ResultSet rs=st.executeQuery(); //查询结果
            while (rs.next()){
                map.put(sdf.format(new Date((long) (rs.getDouble("time")* 1000))),rs.getInt("size"));
                System.out.println(sdf.format(new Date((long) (rs.getDouble("time")* 1000))));
                System.out.println(rs.getDouble("size"));
            }
//            for (int i = 0; i < args.length; i++) {
//                st.setObject(i + 1, args[i]);
//            }
            //rs = rs.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

//    public static void main(String[] args) {
//        selectIp();
//    }
}

