package com.arithmetic.sort;

import java.util.Arrays;

/**
 * @Project：TestJava
 * @Package：com.arithmetic.sort
 * @ClassName: ChooseSort
 * @Description: 选择排序  
 * 思想：每趟从待排序的记录序列中选择关键字最小的记录放置到已排序表的最前位置，直到全部排完。
 * •方法：
 * –直接选择排序
 *  –堆排序
 * @author Yhc yinhc@yinhu.com
 * @date 2015年9月14日 下午3:49:02
 */
public class ChooseSort {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={48,38,65,97,76,13,27,78,34,12,64,49,1,38};
		
		System.out.println("排序前：" + Arrays.toString(a));
		
//		ChooseSort.directChooseSort(a, true);
		ChooseSort.heapSort(a);
	}

	/**
	 * 
	 * @MethodName:directChooseSort
	 * @param a
	 * @param sortType
	 * void
	 * @Description: 简单的选择排序      不稳定    时间复杂度：T(n)=O(n2)。
	 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
	 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止
	 * @author Yhc yinhc@yinhu.com 
	 */
	public static void directChooseSort(int[] a,Boolean sortType){
		for (int i = 0; i < a.length; i++) {
			int min=a[i];
			int n=i;
			for (int j = i+1; j < a.length; j++) {
				if(a[j]<min){
					min=a[j];
					n=j;
				}
			}
			a[n]=a[i];
			a[i]=min;
		}
		System.out.println("升序排序,排序后：" + Arrays.toString(a));
	}
	
	/**
	 * 
	 * @MethodName:heapSort
	 * @param array
	 * void
	 * @Description: 堆排序 堆排序的最坏时间复杂度为O(nlogn)
	 * @author Yhc yinhc@yinhu.com
	 */
	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		buildMaxHeap(array);

		for (int i = array.length - 1; i >= 1; i--) {
			array[0] = array[0] + array[i];
			array[i] = array[0] - array[i];
			array[0] = array[0] - array[i];

			maxHeap(array, i, 0);
		}
		System.out.println("排序后：" + Arrays.toString(array));
	}

	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}

	private static void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		if (index != largest) {
			array[index] = array[index] + array[largest];
			array[largest] = array[index] - array[largest];
			array[index] = array[index] - array[largest];
			maxHeap(array, heapSize, largest);
		}
	}
}
