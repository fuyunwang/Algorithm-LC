package com.gopher.ending.simulation.joseph_ring;

import java.util.*;

/**
 * @Title Template
 * @Author fyw
 * @Date 2022-03-12 13:56
 * @Description
 */
public class Template {
    static class Code950{
        public int[] deckRevealedIncreasing(int[] deck) {
            int n = deck.length;
            Arrays.sort(deck);
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                q.add(i);
            }
            int[] res = new int[n];
            int id = 0;
            while (q.size() > 0) {
                int t = q.poll();
                res[t] = deck[id++];
                if (q.size() > 0) {
                    q.add(q.poll());
                }
            }
            return res;
        }
    }
}
