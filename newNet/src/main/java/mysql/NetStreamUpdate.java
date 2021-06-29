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
        List<NSbody> bodys = ns.getBodyList();
        String updateHead = "INSERT INTO head (version,count,SysUptime,unix_secs,unix_nsecs,flow_sequence," +
                "engine_type,engine_id,reserved) VALUES (?,?,?,?,?,?,?,?,?)";
        Connection connection = MysqlTool.getConnection();
        String updateBody = "INSERT INTO body (Start_time,End_time,Package_count,Byte_count,Protocol_type," +
                "Dst_IP,Src_IP,Next_IP,Dstmask,Srcmask,Dst_AS,Src_AS,Out_interface,In_interface," +
                "Dst_port,Src_port,Tos,Reserved) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(updateHead);
            int  i = 1;
            for(Object s : head.getAllFields().values().toArray()){
                st.setString(i++,s.toString());
            }
            st.executeUpdate();

            for (NSbody body : bodys) {
                i = 1;
                st = connection.prepareStatement(updateBody);
                for (Object s : body.getAllFields().values().toArray()) {
                    System.out.println(i+"::::"+s.toString());
                    st.setString(i++, s.toString());
                }
                st.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
