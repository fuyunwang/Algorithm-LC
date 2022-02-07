package com.gopher.leetcode.order.or500;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Title Code599
 * @Author fyw
 * @Date 2022/2/7 15:08
 * @Description:
 * 同一个字符串在数组1和数组2出现过，找到下标和最小的字符串
 */
public class Code599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> indexMap=new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            indexMap.put(list1[i],i);
        }
        int min=Integer.MAX_VALUE;
        List<String> list=new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            // 通过覆盖的手段来实现一次遍历的效果，类似二叉树的右视图覆盖效果
            if (indexMap.containsKey(list2[i])){
                if (min>i+indexMap.get(list2[i])){
                    list=new ArrayList<>();
                    list.add(list2[i]);
                    min=i+indexMap.get(list2[i]);
                }else if (min==i+indexMap.get(list2[i])){
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] findRestaurant2(String[] list1, String[] list2) {
        return IntStream.range(0, list1.length + list2.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> i < list1.length ? list1[i] : list2[i - list1.length]))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() == 2)
                .collect(Collectors.groupingBy(entry -> entry.getValue().get(0) + entry.getValue().get(1), TreeMap::new, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .values()
                .iterator()
                .next()
                .toArray(new String[0]);
    }

}
