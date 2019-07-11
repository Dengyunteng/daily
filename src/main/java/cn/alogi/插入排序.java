package cn.alogi;

import java.util.Arrays;

public class 插入排序 {
    public static void sort(int[] n, int len){
        for(int i = 1; i < len; i++){
            int value = n[i];
            int j = i - 1;
            for(; j >= 0; j--){
                if(value < n[j]){
                    n[j + 1] = n[j];
                }else{
                    break;
                }
            }
            n[j + 1] = value;
        }
    }
    public static void main(String[] args){
        int[] a = new int[]{2,4,6,2,8,3,9,3,4,5,6,3};

        System.out.println(Arrays.toString(a));
        sort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
