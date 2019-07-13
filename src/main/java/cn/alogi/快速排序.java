package cn.alogi;

import java.util.Arrays;

public class 快速排序 {
    public static void sort(int[] n, int start, int end){
        if(start >= end){
            return;
        }
        int p = part2(n, start, end);
        sort(n, start, p - 1);
        sort(n, p + 1, end);
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

    public static int part2(int[] n, int start, int end){
        int center = start;
        int nextCenter = start + 1;
        for(int i = nextCenter; i <= end; i++){
            if(n[i] < n[center]){
                int temp = n[i];
                n[i] = n[nextCenter];
                n[nextCenter] = temp;
                nextCenter++;
            }
        }
        int temp = n[center];
        n[center] = n[nextCenter - 1];
        n[nextCenter - 1] = temp;
        return nextCenter - 1;
    }
    public static void main(String[] args){
//        int[] a = new int[]{2,4,6,2,8,3,9,3,4,5,6,3};
        int[] a = new int[]{3,5,2,5,47,15,36,27,2,46,4,19};

        System.out.println(Arrays.toString(a));
        sort(a, 0,a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
