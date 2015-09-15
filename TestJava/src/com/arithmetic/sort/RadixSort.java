package com.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Project：TestJava
 * @Package：com.arithmetic.sort
 * @ClassName: RadixSort
 * @Description: 基数排序  稳定的排序算法   时间复杂度为O(d(n+r)),d为位数，r为基数
 * @author Yhc yinhc@yinhu.com
 * @date 2015年9月15日 上午10:08:12
 */
public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 48, 38, -65, 97, 76, 13, 27, -78, 34, 12, 64, 49, 1, 38 };
		System.out.println("排序前：" + Arrays.toString(a));
		sort(a);
		System.out.println("排序后：" + Arrays.toString(a));
	}

	private static void sort(int[] array) {
		// 找到最大数，确定要排序几趟
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		// 判断位数
		int times = 0;
		while (max > 0) {
			max = max / 10;
			times++;
		}
		// 建立十个队列
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for (int i = 0; i < 10; i++) {
			ArrayList queue1 = new ArrayList();
			queue.add(queue1);
		}
		// 进行times次分配和收集
		for (int i = 0; i < times; i++) {
			// 分配
			for (int j = 0; j < array.length; j++) {
				int x = array[j] % (int) Math.pow(10, i + 1)
						/ (int) Math.pow(10, i);
				ArrayList queue2 = queue.get(x);
				queue2.add(array[j]);
				queue.set(x, queue2);
			}
			// 收集
			int count = 0;
			for (int j = 0; j < 10; j++) {
				while (queue.get(j).size() > 0) {
					ArrayList<Integer> queue3 = queue.get(j);
					array[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
	}

}
