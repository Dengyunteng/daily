package cn.alogi;

import java.util.Arrays;

public class 计数排序 {
    public static int[] sort(int[] n){
        if(n == null || n.length <= 1){
            return n;
        }
        int max = findMax(n);
        int[] result = new int[n.length];
        int[] numArray = new int[max + 1];
        for(int i = 0; i < n.length; i++){
            numArray[n[i]]++;
        }
        for(int j = 1; j < numArray.length; j++){
            numArray[j] = numArray[j] + numArray[j - 1];
        }
        for(int k = 0 ; k < n.length; k++){
            int pos = numArray[n[k]]--;
            result[pos - 1] = n[k];
        }
        return result;
    }

    public static int findMax(int[] n){
        int max = n[0];
        for(int i = 0; i < n.length; i++){
            if(n[i] > max){
                max = n[i];
            }
        }
        return  max;
    }
    public static void main(String[] args){
        int[] a = new int[]{2,4,6,2,8,3,9,3,4,5,6,3};

        System.out.println(Arrays.toString(a));
        a = sort(a);
        System.out.println(Arrays.toString(a));
    }
}
