package com.at.wangxu.competition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximumUnits {

    static class BoxNode {
        int num;
        int perUnit;

        public BoxNode(int num, int perUnit) {
            this.num = num;
            this.perUnit = perUnit;
        }
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<BoxNode> list = new ArrayList<>();
        for (int[] boxType : boxTypes) {
            list.add(new BoxNode(boxType[0],boxType[1] ));
        }

        list.sort((o1, o2) -> o2.perUnit- o1.perUnit);
        int res = 0;
        for (BoxNode boxNode : list) {
            if (boxNode.num < truckSize) {
                res += boxNode.num* boxNode.perUnit;
                truckSize -= boxNode.num;
            }else {
                res += boxNode.perUnit * truckSize;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumUnits maximumUnits = new MaximumUnits();
        System.out.println(maximumUnits.maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4));

        System.out.println(Integer.MAX_VALUE);
        int i = 1;
//        i <<= 31;
        System.out.println(i);
        System.out.println(10 * 10 * 10 * 10 * 10 * (i << 19));
    }
}
