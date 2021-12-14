package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class data {
    static List<Integer> len = new ArrayList<>();
    static List<String> timeStamp = new ArrayList<>();
    public static Double currentTime = new Double(0);
    public static int number = 1;

    //for web
    public static Map<String,Integer> map_proto_size = new HashMap<>();

    public static Map<String,Integer> map_ip_size = new HashMap<>();

    public static Map<String,Integer> map_mac_size = new HashMap<>();
    static Double start_time;
    //static Double end_time;
}
