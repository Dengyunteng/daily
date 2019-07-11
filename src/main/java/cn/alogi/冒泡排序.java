package cn.alogi;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args){
        int[] a = new int[]{2,4,6,2,8,3,9,3,4,5,6,3};

        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] array){
        for(int i = 0; i < array.length; i++){
            boolean flag = true;
            for(int j = 0 ; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    flag = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if(flag){
                return;
            }
        }
    }
}
