package com.at.wangxu.leetcode;

/**
 * 面试题 08.03. 魔术索引
 * <p>
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * 说明:
 * <p>
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 */
public class FindMagicIndex {


    public int findMagicIndex(int[] nums) {
        //从左到右循环遍历。官方题解为二分思想，但是好像还没有直接遍历效率高
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == i)
//                return i;
//        }
//        return -1;
        return findMin(nums, 0, nums.length-1);
    }

    public int findMin(int[] nums,int l,int r) {

        if (l > r)
            return -1;
        int m = (l + r) / 2;
        //先找左边
        int min = findMin(nums, l, m - 1);
        if (min != -1)
            return min;
            //判断当前节点
        else if (nums[m] == m)
            return m;
        //再找右边
        return findMin(nums, m + 1, r);
    }

    public static void main(String[] args) {
        FindMagicIndex magicIndex = new FindMagicIndex();
        System.out.println(magicIndex.findMagicIndex(new int[]{0, 2, 3, 4, 5}));
        System.out.println(magicIndex.findMagicIndex(new int[]{12296169, 14481887, 19365401, 71948694, 101256536, 137449705, 147615033, 169095970, 182939974, 183054331, 191033174, 200069688, 210281043, 211549396, 227193353, 252408327, 263757832, 268669870, 271916258, 293898012, 322628245, 329246885, 348479255, 405807814, 431800160, 449369511, 477566467, 481431749, 481880069, 487953610, 509211052, 520721303, 527744664, 550058864, 571603718, 571617555, 579098239, 582152388, 645340207, 681566032, 685774515, 706348591, 708774328, 717815831, 721421995, 724666698, 745560058, 746289154, 769651867, 781893631, 789714924, 807615645, 882508445, 884260053, 916797901, 920985226, 924045345, 932899253, 950715182, 987825772, 1015158842, 1016121780, 1065377233, 1072449577}));
    }
}
