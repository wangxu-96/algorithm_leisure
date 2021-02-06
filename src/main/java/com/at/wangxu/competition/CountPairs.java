package com.at.wangxu.competition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPairs {
    static Set<Integer> set = new HashSet<>();

    static {
        int i = 1;
        for (int j = 0; j < 31; j++) {
            set.add(i << j);
        }
    }

    static final int MOD = 1000000007;
    public int countPairs(int[] deliciousness) {
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deliciousness) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            int keyCount = map.get(key);
            if (set.contains(key + key)) count += (long) keyCount * (keyCount - 1) / 2;
            for (Integer sum : set) {
                int sub = sum - key;
                if (sub == key) continue;
                if (sub < key) continue;
                Integer subCount = map.get(sub);
                if (subCount == null) continue;
                count += (long) subCount * map.get(key);
            }
        }
        return (int) (count % MOD);
    }

    public static void main(String[] args) {
        CountPairs pairs = new CountPairs();
        System.out.println(pairs.countPairs(new int[]{1,3,5,7,9}));
        System.out.println(pairs.countPairs(new int[]{1,1,1,3,3,3,7}));
        System.out.println(pairs.countPairs(new int[]{2,14,11,5,1744,2352,0,1,1300,2796,0,4,376,1672,73,55,2006,42,10,6,0,2,2,0,0,1,0,1,0,2,271,241,1,63,1117,931,3,5,378,646,2,0,2,0,15,1}));
    }
}