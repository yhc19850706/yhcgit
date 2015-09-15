package com.arithmetic.sort;

import java.util.Arrays;

/**
 * @Project：TestJava
 * @Package：com.arithmetic.sort
 * @ClassName: ExchangeSort
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yhc yinhc@yinhu.com
 * @date 2015年9月14日 下午5:37:01
 */
public class ExchangeSort {

	/**
	 * @MethodName:main
	 * @param args
	 *            void
	 * @Description:
	 * @author Yhc yinhc@yinhu.com
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = { 48, 38, 65, 97, 76, 13, 27, 78, 34, 12, 64, 49, 1, 38 };
//		System.out.println("排序前：" + Arrays.toString(a));
//		ExchangeSort.bubbleSort(a);
//		ExchangeSort.quickSort(a, 0, a.length-1);
//		System.out.println("排序后：" + Arrays.toString(a));
		
		System.out.println("Pi=：" + montePi(1000000));
	}

	/**
	 * 
	 * @MethodName:bubbleSort
	 * @param a
	 * @return           void
	 * @Description:冒泡排序 稳定   平均时间复杂度为O(n2)
	 * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，
	 * 自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
	 * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
	 * @author Yhc yinhc@yinhu.com
	 */
	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {// 这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
				if (a[j] > a[j + 1]) {
					a[j] = a[j] + a[j + 1];
					a[j + 1] = a[j] - a[j + 1];
					a[j] = a[j] - a[j + 1];
				}
			}
		}
		System.out.println("排序后：" + Arrays.toString(a));
	}
	
	/**
	 * 
	 * @MethodName:quickSort
	 * @param a int[]
	 * @param low int 
	 * @param high int =a.length-1
	 * @return void
	 * @Description:快速排序  不稳定   时间复杂度为O(nlogn)  　当n较大时使用快排比较好
	 * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
	 * 一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分
	 * @author Yhc yinhc@yinhu.com
	 */
	private static void quickSort(int[] a, int low, int high) {
        if(low<high){ //如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle = getMiddle(a,low,high);
            quickSort(a, 0, middle-1);
            quickSort(a, middle+1, high);
        }
    }

    private static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];//基准元素
        while(low<high){
            //找到比基准元素小的元素位置
            while(low<high && a[high]>=temp){
                high--;
            }
            a[low] = a[high]; 
            while(low<high && a[low]<=temp){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }
    /**
     * 
     * @MethodName:montePi
     * @param n
     * @return
     * double
     * @Description:计算PI的近似值  n值越大越接近
     * @author Yhc yinhc@yinhu.com
     */
    private static double montePi(int n){
    	double pi;
    	double x;
    	double y;
    	int sum=0;
    	for (int i = 1; i <=n; i++) {
			x=Math.random();
			y=Math.random();
			if((x*x+y*y)<=1){
				sum++;
			}
		}
    	pi=4.0*sum/n;
    	return pi;
    }
}
