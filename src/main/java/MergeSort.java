import java.util.Arrays;

public class MergeSort {
    public static int[] divideMerge(int[] array){
        if(array == null) return new int[0];
        if(array.length == 1) return array;
        int mid = array.length / 2;

        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return merge(left,right);
    }

    public static int[] merge(int[] one, int[] two){
        return null;
    }

}
