package com.arithmetic.sort;

import java.util.Arrays;

/**
 * 
 * @Project: TestJava
 * @Package: com.arithmetic.sort
 * @ClassName: InsertSort 
 * @Description: 插入排序
 *  基本思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止
 * @author Yhc yinhc@yinhu.com
 * @date 2015年9月11日 下午5:11:52
 */
public class InsertSort {

	public InsertSort() {
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={48,38,65,97,76,13,27,78,34,12,64,49,1,38};
//		InsertSort.directInsertionSort(a,true);
//		InsertSort.bisectionInsertSort(a, true);
		InsertSort.hillSort(a, false);
	}


	 /**
	  * 
	  * @MethodName:directInsertionSort
	  * @param a 排序数据 int[]
	  * @param sortType Boolean 排序类型 升序 true 降序 false
	  * @return int[]
	  * @author Yhc yinhc@yinhu.com
	  * @Description: 直接插入排序 平均时间复杂度为O(n2) 最差 O(n^2) 最好 O(n)
	  */
	public static int[] directInsertionSort(int[] a,Boolean sortType) {
		System.out.println("排序前：" + Arrays.toString(a));
		if(sortType){
			for (int i = 1; i < a.length; i++) {
				for (int j = i - 1; j >= 0; j--) {
					if (a[j] > a[j + 1]) {
						a[j] = a[j] + a[j + 1];
						a[j + 1] = a[j] - a[j + 1];
						a[j] = a[j] - a[j + 1];
					} else {
						break;
					}
				}
			}
			System.out.println("升序排序,排序后：" + Arrays.toString(a));
		}else{
			for (int i = 1; i < a.length; i++) {
				for (int j = i - 1; j >= 0; j--) {
					if (a[j] < a[j + 1]) {
						a[j] = a[j] ^ a[j + 1];
						a[j + 1] = a[j + 1] ^ a[j];
						a[j] = a[j + 1] ^ a[j];
					} else {
						break;
					}
				}
			}
			System.out.println("降序排序,排序后：" + Arrays.toString(a));
		}
		return a;
	}
	/**
	 * 
	 * @MethodName:bisectionInsertSort
	 * @param a int[]
	 * @param sortType Boolean 排序类型 升序 true 降序 false
	 * @return int[]
	 * @Description:二分插入排序
	 *  基本思想：二分法插入排序的思想和直接插入一样，只是找合适的插入位置的方式不同，
	 *  这里是按二分法找到合适的位置，可以减少比较的次数。稳定
	 * @author Yhc yinhc@yinhu.com
	 */
	public static int[] bisectionInsertSort(int[] a,Boolean sortType){
		System.out.println("排序前：" + Arrays.toString(a));
		if(sortType){
			for (int i = 1; i < a.length; i++) {
				int left=0;
				int right=i-1;
				int mid=0;
				while(left<=right){
					mid=(left+right)/2;
					if(a[mid]>a[i]){
						right=mid-1;
					}else{
						left=mid+1;
					}
				}
				
				for (int j = i; j>left; j--) {
					a[j] = a[j] ^ a[j - 1];
					a[j-1] = a[j - 1] ^ a[j];
					a[j] = a[j - 1] ^ a[j];
				}
			}
			System.out.println("升序排序,排序后：" + Arrays.toString(a));
		}else{
			for (int i = 1; i < a.length; i++) {
				int left=0;
				int right=i-1;
				int mid=0;
				while(left<=right){
					mid=(left+right)/2;
					if(a[mid]<a[i]){
						right=mid-1;
					}else{
						left=mid+1;
					}
				}
				
				for (int j = i; j>left; j--) {
					a[j] = a[j] ^ a[j - 1];
					a[j-1] = a[j - 1] ^ a[j];
					a[j] = a[j - 1] ^ a[j];
				}
			}
			System.out.println("降序排序,排序后：" + Arrays.toString(a));
		}
		return a;
	}
	
	/**
	 * 
	 * @MethodName:hillSort
	 * @param a
	 * @param sortType
	 * @return
	 * int[]
	 * @Description:希尔排序
	 * 基本思想：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。
	 * 所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；
	 * 然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<…<d2<d1)，
	 * 即所有记录放在同一组中进行直接插入排序为止。该方法实质上是一种分组插入方法.不稳定 平均时间复杂度为O(nlogn)
	 * @author Yhc yinhc@yinhu.com
	 */
	public static int[] hillSort(int[] a,Boolean sortType){
		System.out.println("排序前：" + Arrays.toString(a));
		int d=a.length;
		if(sortType){
			while(true){
				d=d/2;
				for(int x=0;x<d;x++){
					for (int i = x+d; i < a.length; i=i+d) {
						for (int j = i-d; j >=0; j=j-d) {
							if (a[j] > a[j + d]) {
								a[j] = a[j] + a[j + d];
								a[j + d] = a[j] - a[j + d];
								a[j] = a[j] - a[j + d];
							} else {
								break;
							}
						}
					}
				}
				if(1==d){
					break;
				}
			}
			System.out.println("升序排序,排序后：" + Arrays.toString(a));
		}else{
			while(d>1){
				d=d/2;
				for(int x=0;x<d;x++){
					for (int i = x+d; i < a.length; i=i+d) {
						for (int j = i-d; j >= 0; j=j-d) {
							
							if (a[j] < a[j + d]) {
								a[j] = a[j] ^ a[j + d];
								a[j + d] = a[j + d] ^ a[j];
								a[j] = a[j + d] ^ a[j];
							} else{
								break;
							}
						}
					}
				}
			}
			System.out.println("降序排序,排序后：" + Arrays.toString(a));
		}
		return a;
	}
}
