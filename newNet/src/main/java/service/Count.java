package service;

import java.util.List;
import java.util.Map;

public interface Count<K,V> {
    //统计某个变量的字节数
    Map<K,V> count(List<K> inArr, List<V> resultArr);

}
