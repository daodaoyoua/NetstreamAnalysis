package service;

import com.google.protobuf.DoubleValue;
import grpc.*;
import io.grpc.stub.StreamObserver;
import mysql.NetStreamUpdate;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class SimulatorServicelmpl extends SimulatorServiceGrpc.SimulatorServiceImplBase {//chongxie fangfa zhuti

    @Override

    public void sendNetStream(NetStream netstream, StreamObserver<SimResponse> responseObserver) {
        boolean x = netstream.isInitialized();
        SimResponse response = SimResponse.newBuilder().setIsArrived(x).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        get(netstream);
        show_proto(netstream);
        show_special_ip(netstream);
        //System.out.println(data.currentTime);
    }

    public void get(NetStream netstream) {
        long timestamp = (long) (netstream.getHead().getUnixSecs() * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        List<String> ipList = new ArrayList<String>(30);
        List<Integer> ipSize = new ArrayList<Integer>(30);
        data.number += 1;
        String file_current_time = "C:\\Users\\Mloong\\Desktop\\demo\\src\\main\\resources\\curent_time.properties";
        if (data.timeStamp.isEmpty()) {  // 初始化
            String time = sdf.format(new Date((long) (netstream.getHead().getUnixSecs() * 1000)));
            data.currentTime = netstream.getHead().getUnixSecs();
            try {
                dataProperties.WriteProperties(file_current_time,
                        "current_time",String.valueOf(netstream.getHead().getUnixSecs())); //初始化curren_time
            } catch (IOException e) {
                e.printStackTrace();
            }
            data.timeStamp.add(time);
            data.len.add(0);
        }

        if (netstream.getHead().getUnixSecs() - data.currentTime >= 3) { //
            String time = sdf.format(new Date((long) (netstream.getHead().getUnixSecs() * 1000)));
            data.currentTime = netstream.getHead().getUnixSecs();

            data.timeStamp.add(time);
            data.len.add(0);
            try { // 三秒间隔 将数据写入properties，准备发送
                dataProperties.WriteProperties("C:\\Users\\Mloong\\Desktop\\demo\\src\\main\\resources\\data.properties"
                        ,data.map_proto_size);
                dataProperties.WriteProperties(file_current_time,
                        "current_time",String.valueOf(netstream.getHead().getUnixSecs()));  //更新curren_time
            } catch (IOException e) {
                e.printStackTrace();
            }
            data.map_proto_size.clear();

            try { // 三秒间隔 将数据写入properties，准备发送
                dataProperties.Clear("C:\\Users\\Mloong\\Desktop\\demo\\src\\main\\resources\\data_ip.properties");
                dataProperties.WriteProperties("C:\\Users\\Mloong\\Desktop\\demo\\src\\main\\resources\\data_ip.properties"
                        ,data.map_ip_size);




            } catch (IOException e) {
                e.printStackTrace();
            }
            data.map_ip_size.clear();
        }

        for (NSbody ns : netstream.getBodyList()) {
            data.len.set(data.len.size() - 1, data.len.get(data.len.size() - 1) + ns.getByteCount());

            ipList.add(ns.getSrcIP());
            ipSize.add(ns.getByteCount());
        }
        // System.out.println(data.timeStamp.size());
        // System.out.println(data.len.get(0));
//        if (data.number == 2000) {
//            System.out.println("11111111111111111111111111111111111");
//            new IPshow("fourString", "ip->size", "ip",
//                    "size", data.timeStamp, data.len).showTable();
//            data.number = 0;
//            data.len.clear();
//            data.timeStamp.clear();
//        }
        NetStreamUpdate.netStreamInsert(netstream);

        //System.out.println("**********************************");
    }

    public void show_special_ip(NetStream netstream) {
        List<String> ip = new ArrayList<>(30);
        List<Integer> size = new ArrayList<>(30);
        int i = 0;//计数
        for (NSbody b : netstream.getBodyList()) {
            ip.add(b.getSrcIP());
            size.add(b.getByteCount());
        }
        for (int k = 0; k < ip.size(); k++) {
            data.map_ip_size.put(ip.get(k),data.map_ip_size.getOrDefault(ip.get(k),0)+size.get(k));
            //System.out.println("1"+data.map_proto_size.hashCode());
            //System.out.println(data.map_proto_size);
        }
//        new IPshow("fourString", "ip->size", "ip",
//                "size", new Count_String().count(ip, size)).showTable();
    }

    public void show_special_mac(NetStream netstream) {
        List<String> mac = new ArrayList<>(30);
        List<Integer> size = new ArrayList<>(30);
        int i = 0;//计数
        for (NSbody b : netstream.getBodyList()) {
            mac.add(b.getInInterface());
            size.add(b.getByteCount());
        }

//        new IPshow("sepcial_mac", "MAC-SIZE", "Mac",
//                "Size", new Count_String().count(mac, size)).showTable();
    }

    public void show_proto(NetStream netstream) {
        List<String> proto = new ArrayList<>(30);
        List<Integer> size = new ArrayList<>(30);
        //Map<String,Integer> map = new HashMap<>();
        int i = 0;//计数

        for (NSbody b : netstream.getBodyList()) {
            int k = b.getProtocolType();
            switch (k) {
                case 1:
                    proto.add("ICMP");
                    break;
                case 2:
                    proto.add("IGMP");
                    break;
                case 6:
                    proto.add("TCP");
                    break;
                case 17:
                    proto.add("UDP");
                    break;
            }
            size.add(b.getByteCount());
        }
        for (int k = 0; k < proto.size(); k++) {
            data.map_proto_size.put(proto.get(k),data.map_proto_size.getOrDefault(proto.get(k),0)+size.get(k));
            //System.out.println("1"+data.map_proto_size.hashCode());
            //System.out.println(data.map_proto_size);
        }


//        new IPshow("show_proto","Protocol-Size","Protocol",
//                "Size",new Count_String().count(proto,size)).showTable();
    }
}
