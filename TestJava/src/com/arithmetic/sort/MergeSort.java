package com.arithmetic.sort;

import java.util.Arrays;

/**
 * @Project：TestJava
 * @Package：com.arithmetic.sort
 * @ClassName: MergeSort
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yhc yinhc@yinhu.com
 * @date 2015年9月14日 下午5:58:09
 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 48, 38, 65, -97, 76, 13, 27, 78, -34, 12, 64, 49, 1, 38 };
		System.out.println("排序前：" + Arrays.toString(a));
		mergeSort(a,0,a.length-1);
		System.out.println("排序后：" + Arrays.toString(a));
	}

	/**
	 * 
	 * @MethodName:mergeSort
	 * @param a int[]
	 * @param left  0
	 * @param right a.length-1
	 * @return void
	 * @Description:归并排序  稳定   时间复杂度为O(nlogn)  速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列。
	 * 基本思想:归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
	 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
	 * @author Yhc yinhc@yinhu.com
	 */
	private static void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			// 对左边进行递归
			mergeSort(a, left, middle);
			// 对右边进行递归
			mergeSort(a, middle + 1, right);
			// 合并
			merge(a, left, middle, right);
		}
	}

	private static void merge(int[] a, int left, int middle, int right) {
		int[] tmpArr = new int[a.length];
		int mid = middle + 1; // 右边的起始位置
		int tmp = left;
		int third = left;
		while (left <= middle && mid <= right) {
			// 从两个数组中选取较小的数放入中间数组
			if (a[left] <= a[mid]) {
				tmpArr[third++] = a[left++];
			} else {
				tmpArr[third++] = a[mid++];
			}
		}
		// 将剩余的部分放入中间数组
		while (left <= middle) {
			tmpArr[third++] = a[left++];
		}
		while (mid <= right) {
			tmpArr[third++] = a[mid++];
		}
		// 将中间数组复制回原数组
		while (tmp <= right) {
			a[tmp] = tmpArr[tmp++];
		}
	}
}
