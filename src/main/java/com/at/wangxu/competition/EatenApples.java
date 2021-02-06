package com.at.wangxu.competition;

import java.util.ArrayList;
import java.util.List;

public class EatenApples {
    static class AppleNode {
        int fromIndex;
        int toIndex;
        int values;

        public AppleNode(int fromIndex, int toIndex, int values) {
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            this.values = values;
        }
    }

    public int eatenApples(int[] apples, int[] days) {
        List<AppleNode> list = new ArrayList<>();
        list.add(new AppleNode(-1, -1, -1));//dummy

        for (int i = 0; i < apples.length; i++) {
            list.add(new AppleNode(i + 1, i + 1 + days[i], Math.min(apples[i], days[i])));
        }
        //foreach list
        int count = 0;
        int index = 1;
        int maxReached = 0;
        while (index < list.size()) {
            AppleNode appleNode = list.get(index);
            if (appleNode.values == 0) {
                //do nothing
                index ++;
            }else if (appleNode.toIndex - appleNode.fromIndex == appleNode.values) {
                maxReached = Math.max(maxReached, appleNode.toIndex);
                count += appleNode.values;
                index = maxReached;
            }else {
                maxReached = Math.max(maxReached, appleNode.toIndex);
                int sum = appleNode.values;
                for (int i = index + 1; i < maxReached && i < list.size(); i++) {
                    //
                    AppleNode appleNode1 = list.get(i);
                    sum += appleNode1.values;
                    maxReached = Math.max(maxReached, appleNode1.toIndex);
                }
                count += Math.min(maxReached - appleNode.fromIndex, sum);
                index = maxReached;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        EatenApples eatenApples = new EatenApples();
        System.out.println(eatenApples.eatenApples(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2}));
//        System.out.println(eatenApples.eatenApples(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}));
//        System.out.println(eatenApples.eatenApples(new int[]{1}, new int[]{2}));
//        System.out.println(eatenApples.eatenApples(new int[]{9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5
//        }, new int[]{3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7}));
    }

}
