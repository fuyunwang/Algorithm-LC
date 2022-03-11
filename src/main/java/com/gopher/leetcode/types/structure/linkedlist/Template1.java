package com.gopher.leetcode.types.structure.linkedlist;

import java.util.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022/3/12 0:26
 * @Description:
 */
public class Template1 {
    static class Code133{
        // 类似复制带有随机指针的链表
        static HashMap<Node, Node> map = new HashMap<Node, Node>();

        void dfs(Node node)
        {
            map.put(node, new Node(node.val));

            for(int i = 0;i < node.neighbors.size();i ++)
            {
                Node t = node.neighbors.get(i);
                if(!map.containsKey(t))
                    dfs(t);
            }
        }
        public Node cloneGraph(Node node) {
            if(node == null) return null;
            map.clear();
            dfs(node);//加入所有的点

            for(Map.Entry<Node,Node> entry : map.entrySet()) {
                Node a = entry.getKey();
                Node b = entry.getValue();

                List<Node> res = new ArrayList<Node>();
                for(int i = 0;i < a.neighbors.size();i ++)
                    res.add(map.get(a.neighbors.get(i)));

                b.neighbors = res;
            }

            return map.get(node);
        }

        class Node {
            public int val;
            public List<Node> neighbors;
            public Node() {
                val = 0;
                neighbors = new ArrayList<Node>();
            }
            public Node(int _val) {
                val = _val;
                neighbors = new ArrayList<Node>();
            }
            public Node(int _val, ArrayList<Node> _neighbors) {
                val = _val;
                neighbors = _neighbors;
            }
        }
    }

}
