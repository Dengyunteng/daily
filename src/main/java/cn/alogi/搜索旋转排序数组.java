package cn.alogi;

import java.util.HashMap;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。ps.二分查找
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 搜索旋转排序数组 {
//    public static int search(int[] nums, int target) {
//        if(nums == null || nums.length == 0){
//            return -1;
//        }
//        boolean isSort = false;
//        int low = 0;
//        int high = nums.length - 1;
//        while(low <= high){
//            int mid = low + ((high - low) >> 1);
//            if(nums[mid] == target)return mid;
//            if(!isSort){//非有序
//                if(nums[low] <= nums[mid]){//左边有序
//                    if(target >= nums[low] && target <= nums[mid]){
//                        isSort = true;
//                        high = mid;
//                    }else{
//                        low = mid + 1;
//                    }
//                }else{//右边有序
//                    if(target <= nums[high] && target >= nums[mid]){
//                        isSort = true;
//                        low = mid;
//                    }else{
//                        high = mid - 1;
//                    }
//                }
//            }else{
//                if(target > nums[mid]){
//                    low = mid + 1;
//                }else if(target < nums[mid]){
//                    high = mid - 1;
//                }else{
//                    return mid;
//                }
//            }
//        }
//        return -1;
//}
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
            else{
                if(nums[left] <= target && target < nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a = new int[]{1,3};
        System.out.println(search(a, 21));
    }
}
