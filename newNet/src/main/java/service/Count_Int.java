package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count_Int implements Count<Integer,Integer>{

    //统计int类型变量的字节数
    @Override
    public Map<Integer, Integer> count(List<Integer> inArr, List<Integer> resultArr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inArr.size(); ++i){
            map.put(inArr.get(i), map.getOrDefault(inArr.get(i),0)+resultArr.get(i));
        }
        return map;
    }
}
