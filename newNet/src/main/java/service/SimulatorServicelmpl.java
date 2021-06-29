package service;

import grpc.*;
import io.grpc.stub.StreamObserver;

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
        int c = 0;
        get(netstream);
        System.out.println(data.number);
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
        System.out.println("**********************************");
    }
}
