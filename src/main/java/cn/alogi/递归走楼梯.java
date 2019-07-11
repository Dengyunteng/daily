package cn.alogi;

/**
 * n个台阶，每次走1或2，有多少种走法
 */
public class 递归走楼梯 {
    public static int recursion(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        return recursion(n - 1) + recursion(n - 2);
    }
    public static int iteration(int n){
        int ret1 = 1;
        int ret2 = 2;
        if(n == 1) return ret1;
        if(n == 2) return ret2;
        for(int i = 3; i < n; i++){
            int ret = ret2;
            ret2 = ret1 + ret2;
            ret1 = ret;
        }
        return ret1 + ret2;
    }
    public static void main(String[] args){
        System.out.println(recursion(7));
        System.out.println(iteration(7));
    }

}
