package cn.alogi;

public class BinarySearch {
    public static int getIndex(int[] a, int b){
        int low = 0;
        int high = a.length;
        while(low <= high){
            int mid = low + ((high - low)>>1);
            if(a[mid] > b){
                high = mid - 1;
            }else if(a[mid] < b){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int recursion(int[] a, int b, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = start + ((end - start)>>1);
        if(a[mid] > b){
            return recursion(a, b, start, mid - 1);
        }else if(a[mid] < b){
            return recursion(a, b, mid + 1, end);
        }else{
            return mid;
        }
    }
    public static void main(String[] args){
//        int a[] = new int[]{1,2,3,4,7,9,23,46};
//        System.out.println(getIndex(a, 0));
    }
}
