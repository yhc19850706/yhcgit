package com.random;

/**
 * @Project：TestJava
 * @Package：com.random
 * @ClassName: BuilderRadom
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yhc yinhc@yinhu.com
 * @date 2015年9月15日 下午2:22:37
 */
public class BuilderRadom {

	/**
	 * @MethodName:main
	 * @param args
	 *            void
	 * @Description:
	 * @author Yhc yinhc@yinhu.com
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        double[] r={5.0};
//        for (int i = 0; i < 10; i++) {
//			System.out.println(rand01(r));
//		}
        int m,n;
        m=0;
        n=300;
        // [m,n]之间的随机数   公式=m+(object)((n-m)*rand01(r))
//        for (int i = 0; i < 100; i++) {
//			System.out.println(m+(int)((n-m)*rand01(r)));
//		}
        double u,t;
        u=2.0; //均值
        t=3.5;//方差
        // 产生十个正太分布的随机数
        for (int i = 0; i < 10; i++) {
        	System.out.println(randZT(u, t, r));
		}
	}

	/**
	 * 
	 * @MethodName:rand
	 * @param r
	 * @return
	 * double
	 * @Description:产生[0,1]均匀分布的随机数
	 * 推算公式： ri=mod(a*rj+b,base)    i=1..n  j=i-1
	 *        pi=ru/base;            pi是递推得到的第i个随机数
	 * @author Yhc yinhc@yinhu.com
	 */
	private static double rand01(double []r)
	{
		double base,u,p,v,temp1,temp2,temp3;
		base=256.0;//2的倍数
		u=17.0;
		v=139.0;
		temp1=u*(r[0])+v; //就算总数
		temp2=(int)(temp1/base);//计算商
		temp3=temp1-temp2*base;//余数
		r[0]=temp3;//更新随机种子，为下一次使用
		p=r[0]/base;//产生随机数
		return p;
		
	}
	/**
	 * 
	 * @MethodName:randZT
	 * @param u 均值
	 * @param t 方差
	 * @param r
	 * @return
	 * double
	 * @Description: 正太分布的随机数生成
	 * @author Yhc yinhc@yinhu.com
	 */
	private static double randZT(double u,double t,double[] r) {
		double total=0.0;
		double result=0.0;
		for (int i = 0; i < 12; i++) {
			total+=rand01(r);
		}
		result=u+t*(total-(12/2));
		return result;
	}
	
}
