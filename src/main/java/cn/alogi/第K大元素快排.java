package cn.alogi;

import java.util.Arrays;

public class 第K大元素快排 {
    public static int sort(int[] n, int start, int end, int k){
        if(start >= end){
            return -1;
        }
        int p = part(n, start, end);
        if(p + 1 == k){
            return n[p];
        }
        if(p + 1 > k){
            return sort(n, start, p - 1, k);
        }else{
            return sort(n, p + 1, end, k);
        }
    }

    public static int part(int[] n, int start, int end){
        int center = end;
        int nextCenter = start;
        for(int i = nextCenter; i <= end; i++){
            if(n[i] < n[center]){
                int temp = n[i];
                n[i] = n[nextCenter];
                n[nextCenter] = temp;
                nextCenter++;
            }
        }
        if(center != nextCenter){
            int temp = n[center];
            n[center] = n[nextCenter];
            n[nextCenter] = temp;
        }
        return nextCenter;
    }

    public static void main(String[] args){
//        int[] a = new int[]{2,4,6,2,8,3,9,3,4,5,6,3};
        int[] a = new int[]{3,5,2,5,47,15,36,27,2,46,4,19};

        System.out.println(Arrays.toString(a));
        System.out.println(sort(a, 0,a.length - 1,13));
        System.out.println(Arrays.toString(a));
    }
}
