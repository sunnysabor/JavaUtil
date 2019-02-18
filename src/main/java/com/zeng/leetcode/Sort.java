/**
 * Copyright (C), 2018, Jerry
 *
 * @ProjectName: JavaUtil
 * @Package: com.zeng.leetcode
 * @ClassName: Sort
 * @Author: jerry
 * @Date: 2018/8/21 13:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zeng.leetcode;

/**
 * @Description: 排序
 * @author jerry
 * @createDateTime 2019-02-18 10:08
 */
public class Sort {

    public static void main(String[] args) {
        int[] test = {7,1, 3, 5, 4, 2, 3, 9,11,8};
        //int[] result=ascSort(test);
        int[] result = selectSort(test);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] exchangeSort(int[] a){

        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }

        return  a;
    }

    public static int[] selectSort(int[] a){

        for(int i=0;i<a.length-1;i++){
            int min=a[i];
            int index=i;
            for(int j=i+1;j<a.length;j++){
                if(min>a[j]){
                    min=a[j];
                    index=j;
                }
            }
            if(index!=i){
                int temp=a[i];
                a[i]=a[index];
                a[index]=temp;
            }
        }
        return  a;
    }
}
