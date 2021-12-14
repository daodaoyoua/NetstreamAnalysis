package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count_String implements Count<String,Integer> {
    //统计String类型变量字节数
    @Override
    public Map<String, Integer> count(List<String> inArr, List<Integer> resultArr) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < resultArr.size(); ++i){
            map.put(inArr.get(i), map.getOrDefault(inArr.get(i),0)+resultArr.get(i));
        }
        return map;
    }
}
