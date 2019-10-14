package cn.alogi;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class 回溯算法 {

    private static int minDist = Integer.MAX_VALUE;

    public static void minDistBt(int i, int j, int dist, int[][] w, int n){
        if(i == n && j == n){
            if(dist < minDist) minDist = dist;
            return;
        }
        if(i < n){
            minDistBt(i + 1, j, dist + w[i][j], w, n);
        }
        if(j > n){
            minDistBt(i, j + 1, dist + w[i][j], w, n);
        }
    }

    public static void run(int last, int count){
        if(last <= 0){
            if(minDist > count && last == 0) minDist = count;
            return;
        }
        run(last - 1, count + 1);
        run(last - 3, count + 1);
        run(last - 5, count + 1);
    }

    private static char[] a = "mitcmu".toCharArray();
    private static char[] b = "mtacnu".toCharArray();
    private static int n = 6;
    private static int m = 6;
    public static void lwstBT(int i, int j, int edist){
        if(i == n || j == m){
            if(i < n) edist = edist + (n - i);
            if(j < m) edist = edist + (m - j);
            if(edist < minDist) minDist = edist;
            return;
        }
        if(a[i] == b[j]){
            lwstBT(i + 1, j + 1, edist);
        }else{
            lwstBT(i, j + 1, edist + 1);//删除b[j]或者在a[i]之前添加b[j]
            lwstBT(i + 1, j, edist + 1);//删除a[i]或者在b[j]之前添加a[i]
            lwstBT(i + 1, j + 1, edist + 1);//将a[i]替换成b[j]或者将b[j]替换成a[i]
        }
    }


    public static void main(String[] args){
        run(9, 0);
        System.out.print(minDist);
    }
}
