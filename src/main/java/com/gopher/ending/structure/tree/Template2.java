package com.gopher.ending.structure.tree;

import java.util.*;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-14 16:24
 * @Description 二叉树的属性计算
 */
public class Template2 {
    static class Code690{
        static class Employee {
            public int id;
            public int importance;
            public List<Integer> subordinates;
        }
        Map<Integer,Employee> map=new HashMap<>();
        public int getImportance(List<Employee> employees, int id) {
            for (Employee employee:employees){
                map.put(employee.id,employee);
            }
            return calculate(id);
        }
        int calculate(int id){
            if (!map.containsKey(id)){
                return 0;
            }
            int res=map.get(id).importance;
            for (int child:map.get(id).subordinates){
                res+=calculate(child);
            }
            return res;
        }
    }
}
