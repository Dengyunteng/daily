package cn.alogi;

import javafx.concurrent.Task;

import javax.xml.transform.Result;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public class 动态规划 {
    public static int knapsack(int[] weight, int n, int w){
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        if(weight[0] <= w){
            states[0][weight[0]] = true;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < w; j++){
                if(states[i - 1][j]) states[i][j] = true;
            }
            for(int j = 0; j < w - weight[i]; j++){
                if(states[i - 1][j]) states[i][j + weight[i]] = true;
            }
        }
        for(int j = w; j >= 0; j--){
            if(states[n - 1][j]) return j;
        }
        return 0;
    }

    public static int min(int a, int b){
        if(a > b){
            return b;
        }
        return a;
    }

    public static int min(int a, int b, int c){
        if(a > b){
            return b;
        }
        return a;
    }

    public static int dyn(int[][] w, int n){
        int[][] r = new int[n][n];
        r[0][0] = w[0][0];
        for(int p = 1; p < n; p++){
            r[0][p] = r[0][p - 1] + w[0][p];
        }
        for(int q = 1; q < n; q++){
            r[q][0] = r[q -1][0] + w[q][0];
            for(int p = 1; p < n; p++){
                r[q][p] = w[q][p] + min(r[q-1][p], r[q][p-1]);
            }
        }
        return r[n - 1][n - 1];
    }

    public static int countMoneyMin(int[] moneyItems, int resultMemory){
        if(null == moneyItems || moneyItems.length < 1){
            return -1;
        }
        if(resultMemory < 1){
            return -1;
        }

        int maxCount = resultMemory / moneyItems[0];
        int length = moneyItems.length;

        int[][] status = new int[maxCount][resultMemory + 1];

        for(int i = 0; i < maxCount; i++){
            for(int j = 0; j < resultMemory + 1; j++){
                status[i][j] = -1;
            }
        }
        for(int i = 0; i < length; i++){
            status[0][moneyItems[i]] = moneyItems[i];
        }

        int minNum = -1;

        for(int i = 1; i < maxCount; i++){
            for(int j = 0; i < resultMemory; j++){
                if(status[i - 1][j] != -1){
                    for(int k = 0; k < length; k++){
                        if(j + moneyItems[k] <= resultMemory){
                            status[i][j + moneyItems[k]] = moneyItems[k];
                        }
                    }
                }
                if(status[i][resultMemory] >= 0){
                    minNum = i + 1;
                    break;
                }
            }
            if(minNum > 0){
                break;
            }
        }
        int befValue = resultMemory;

        for(int i = minNum - 1; i >=0; i--){
            for(int j = resultMemory; j >= 0; j--){
                if(j == befValue){
                    System.out.println("当前的为：" + status[i][j]);
                    befValue = befValue - status[i][j];
                    break;
                }
            }
        }
        return minNum;
    }

    public static int lwstDP(char[] a, int n, char[] b, int m){
        int[][] minDist = new int[n][m];
        for(int j = 0; j < m; j++){
            if(a[0] == b[j]) minDist[0][j] = j;
            else if(j != 0) minDist[0][j] = minDist[0][j - 1] + 1;
            else minDist[0][j] = 1;
        }
        for(int i = 0; i < n; i++){
            if(b[0] == a[i]) minDist[i][0] = i;
            else if(i != 0) minDist[i][0] = minDist[i - 1][0] + 1;
            else minDist[i][0] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(a[i] == b[j])minDist[i][j] = min(minDist[i - 1][j], minDist[i][j - 1], minDist[i - 1][j - 1]);
                else minDist[i][j] = min(minDist[i - 1][j], minDist[i][j - 1], minDist[i - 1][j - 1]) + 1;
            }
        }
        return minDist[n - 1][m - 1];
    }
}
