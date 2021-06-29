package service;

import grpc.*;
import io.grpc.stub.StreamObserver;
import mysql.NetStreamUpdate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SimulatorServicelmpl extends SimulatorServiceGrpc.SimulatorServiceImplBase {//chongxie fangfa zhuti
    @Override

    public void sendNetStream(NetStream netstream, StreamObserver<SimResponse> responseObserver) {
        boolean x = netstream.isInitialized();
        SimResponse response = SimResponse.newBuilder().setIsArrived(x).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        int c = 1;
        //get(netstream);
        show_proto(netstream);
//        for(NSbody b:netstream.getBodyList()){
//            System.out.println("第"+c+"个"+"DstPort:::"+b.getDstAS());
//            System.out.println("第"+c+"个"+"SrcPort:::"+b.getNextIP());
//            c++;
//        }
    }
    public void get(NetStream netstream){

        long timestamp = (long)(netstream.getHead().getUnixSecs()*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        //String sd = sdf.format(new Date(timestamp));
        //System.out.println(sd);

        List<String> ipList = new ArrayList<String>(30);
        List<Integer> ipSize = new ArrayList<Integer>(30);
        data.number += 1;
        if(data.timeStamp.isEmpty()){
            String time = sdf.format(new Date((long)(netstream.getHead().getUnixSecs()*1000)));
            data.currentTime = netstream.getHead().getUnixSecs();
            data.timeStamp.add(time);
            data.len.add(0);
        }
        if(netstream.getHead().getUnixSecs()-data.currentTime > 0.3){
            String time = sdf.format(new Date((long)(netstream.getHead().getUnixSecs()*1000)));
            data.currentTime = netstream.getHead().getUnixSecs();
            data.timeStamp.add(time);
            data.len.add(0);
        }

        for(NSbody ns : netstream.getBodyList()){
            data.len.set(data.len.size()-1,data.len.get(data.len.size()-1)+ns.getByteCount());

            ipList.add(ns.getSrcIP());
            ipSize.add(ns.getByteCount());
        }
        System.out.println(data.timeStamp.size());
        System.out.println(data.len.get(0));
        if(data.number==2000){
            System.out.println("11111111111111111111111111111111111");
            new IPshow("fourString","ip->size","ip",
                    "size",data.timeStamp,data.len).showTable();
            data.number=0;
            data.len.clear();
            data.timeStamp.clear();
        }
        NetStreamUpdate.netStreamInsert(netstream);
        System.out.println("**********************************");
    }
    public void show_special_ip(NetStream netstream){
        List<String> ip = new ArrayList<>(30);
        List<Integer> size = new ArrayList<>(30);
        int i = 0;//计数
        for(NSbody b:netstream.getBodyList()){
            ip.add(b.getSrcIP());
            size.add(b.getByteCount());
        }
        new IPshow("fourString","ip->size","ip",
                "size",new Count_String().count(ip,size)).showTable();
    }
    public void show_special_mac(NetStream netstream){
        List<String> mac = new ArrayList<>(30);
        List<Integer> size = new ArrayList<>(30);
        int i = 0;//计数
        for(NSbody b:netstream.getBodyList()){
            mac.add(b.getInInterface());
            size.add(b.getByteCount());
        }
        new IPshow("sepcial_mac","MAC-SIZE","Mac",
                "Size",new Count_String().count(mac,size)).showTable();
    }
    public void show_proto(NetStream netstream){
        List<String> proto = new ArrayList<>(30);
        List<Integer> size = new ArrayList<>(30);
        int i = 0;//计数

        for(NSbody b:netstream.getBodyList()){
            int k = b.getProtocolType();
            switch (k){
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
        new IPshow("show_proto","Protocol-Size","Protocol",
                "Size",new Count_String().count(proto,size)).showTable();
    }
}
