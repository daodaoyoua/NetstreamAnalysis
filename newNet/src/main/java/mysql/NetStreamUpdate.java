package mysql;

import grpc.NSbody;
import grpc.NShead;
import grpc.NetStream;
import tools.MysqlTool;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;


public class NetStreamUpdate {
    public static boolean netStreamInsert(NetStream ns) {
        NShead head = ns.getHead();
        List<NSbody> body = ns.getBodyList();
        String updateHead = "INSERT INTO head (NS_ID,version,count,SysUptime,unix_secs,unix_nsecs,flow_sequence," +
                "engine_type,engine_id,reserved) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Connection connection = MysqlTool.getConnection();


        try {
            PreparedStatement st = connection.prepareStatement(updateHead);
            int  i = 1;
            for(Object s : head.getAllFields().values().toArray()){
                System.out.println(s.toString());
                st.setString(i++,s.toString());
            }
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
