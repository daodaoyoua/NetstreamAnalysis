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


public class executeQuery {
    public static Map<String,Object> selectIp(String ip,int number) {
        Connection connection = MysqlTool.getConnection();
        Map<String,Object> map = new LinkedHashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        String select_ip = "select (\n" +
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
                "    AND Src_IP = ?\n" +
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

        String select_ip_10min = "select (\n" +
                "           case\n" +
                "               when T between max-60 and max THEN max     # 1\n" +
                "               when T between max-120 and max-60 THEN max-60 # 2\n" +
                "               when T between max-180 and max-120 THEN max-120 # 3\n" +
                "               when T between max-240 and max-180 THEN max-180 # 4\n" +
                "               when T between max-300 and max-240 THEN max-240  # 5\n" +
                "               when T between max-360 and max-300 THEN max-300 # 6\n" +
                "               when T between max-420 and max-360 THEN max-360 # 7\n" +
                "               when T between max-480 and max-420 THEN max-420 # 8\n" +
                "               when T between max-540 and max-480 THEN max-480 # 9\n" +
                "               else max-540\n" +
                "               end) time,sum(Size) size\n" +
                "from (select End_time T,Byte_count Size,? max #1634031075.2619662\n" +
                "      from body\n" +
                "      where End_time between ?-600 and ?\n" +
                "        AND Src_IP =  ?\n" +
                "     ) mybody\n" +
                "group by(\n" +
                "            case\n" +
                "                when T between max-60 and max THEN max     # 1\n" +
                "                when T between max-120 and max-60 THEN max-60 # 2\n" +
                "                when T between max-180 and max-120 THEN max-120 # 3\n" +
                "                when T between max-240 and max-180 THEN max-180 # 4\n" +
                "                when T between max-300 and max-240 THEN max-240  # 5\n" +
                "                when T between max-360 and max-300 THEN max-300 # 6\n" +
                "                when T between max-420 and max-360 THEN max-360 # 7\n" +
                "                when T between max-480 and max-420 THEN max-420 # 8\n" +
                "                when T between max-540 and max-480 THEN max-480 # 9\n" +
                "                else max-540\n" +
                "                end)\n" +
                "order by time;";
        try {

            PreparedStatement st = connection.prepareStatement(number==1?select_ip:select_ip_10min);
            //int  i = 1;

            //st = connection.prepareStatement(select_ip);
            double current_time = Double.valueOf(service.dataProperties.GetValueByKey("C:\\Users\\Mloong\\Desktop\\" +
                    "demo\\src\\main" + "\\resources\\curent_time.properties","current_time"));
            System.out.println(current_time);
            st.setDouble(1, current_time);
            st.setDouble(2, current_time);
            st.setDouble(3, current_time);
            st.setString(4, ip);
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

