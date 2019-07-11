public class Utils {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = merge(nums1, nums2);
        if((temp.length & 1) == 0){
            return (double)(temp[temp.length / 2] + temp[temp.length / 2 - 1]) / 2;
        }else{
            return (double)temp[temp.length / 2];
        }

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
