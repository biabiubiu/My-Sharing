package com.sorting_algorithm.Insertion_sort;

import java.util.*;

/**
 * @author hallele
 * @date 2019/7/22 22:35
 * version 1.0
 * <p>
 * 说明：插入排序，一种简单直观且稳定的排序算法
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] ints = {8, 10, 1, 2, 3, 6, 9, 8, 74, 4, 1, 2, 5, 2, 3, 6, 4, 9};
        insertSort01(ints);
        test();


    }

    /**
     * 直接插入排序，时间复杂度O(n^2)
     *
     * @param ints 排序的数组
     */
    private static void insertSort01(int[] ints) {
        for (int i = 2; i < ints.length; i++) {
            if (ints[i] < ints[i - 1]) {
                ints[0] = ints[i];

                //将ints[i]插入有序区，int[0]为监视哨
                int j;
                for (j = i - 1; ints[0] < ints[j]; j--) {

                    //后移记录
                    ints[j + 1] = ints[j];
                }

                //插入到相应位置
                ints[j + 1] = ints[0];
            }
        }

        //为了打印好看，不用管、、、
        System.out.println("排序后：");
        for (int i = 0; i < ints.length; i++) {
            if (i == 0) {
                System.out.print("监视哨：(" + ints[i] + ")\t");
            } else {
                System.out.print(ints[i]);
                if (i < ints.length - 1) {
                    System.out.print("-->");
                }
            }
        }
    }

    /**
     * 选出集合中出现次数最多的前十个数
     */
    private static void test() {
        List<Double> list = new ArrayList<>();

        //随机产生10000个数，存入list
        for (int i = 0; i < 10000; i++) {
            list.add(Math.round(Math.random() * 1000) * 1.0);
        }
        Set<Double> set = new HashSet<>();
        Map<Double, Integer> map = new HashMap<>(1000);

        //遍历list，计算出重复的数的次数，并将他们存入map  k:数值  v:出现的次数
        for (Double aDouble : list) {
            if (set.contains(aDouble)) {
                map.put(aDouble, map.get(aDouble) + 1);
            } else {
                set.add(aDouble);
                map.put(aDouble, 1);
            }
        }

        //将map的键值对存入list进行从打到小排序
        List<Map.Entry<Double, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        //打印前10
        System.out.println("\n\n出现次数最多的前十个：");
        for (int i = 0; i < entryList.size(); i++) {
            if (i < 10) {
                Map.Entry<Double, Integer> entry = entryList.get(i);
                System.out.println(entry.getKey() + "\t: " + entry.getValue());
            }
        }


    }
}
