package cn.alogi;

import java.util.Arrays;

public class 归并排序 {
    public static void main(String[] args){
        int[] a = new int[]{2,4,6,2,8,3,9,3,4,5,6,3};

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(sort(a, 0 , a.length - 1)));
    }
    public static int[] sort(int[] a, int start, int end){
        if(start >= end){
            return new int[]{a[end]};
        }
        int q = start + (end - start) /2;
        return merge(sort(a, start,q), sort(a, q + 1, end));
    }
    public static int[] merge(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0){
            return nums2;
        }
        if(nums2 == null || nums2.length == 0){
            return nums1;
        }
        int i = 0,j = 0,k = 0;
        int[] result = new int[nums1.length + nums2.length];
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                result[k] = nums1[i];
                i++;
            }else{
                result[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < nums1.length){
            result[k] = nums1[i];
            k++;
            i++;
        }
        while(j < nums2.length){
            result[k] = nums2[j];
            k++;
            j++;
        }
        return result;
    }
}
