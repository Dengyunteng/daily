package cn.alogi;

public class 字符串匹配 {
    private static final int SIZE = 256;
    private static void generateBC(char[] b, int m, int[] bc){//缓存模式串各个字符所在的索引
        for(int i = 0; i < SIZE; i++){
            bc[i] = -1;
        }
        for(int i = 0; i < m; i++){
            bc[(int)b[i]] = i;
        }
    }
    //b表示模式串，m表示长度，suffix数组下标k表示后缀子串的长度，值存储的是在模式串中跟好后缀相匹配的子串的起始下标值，prefix用来记录模式串的后缀子串是否能匹配模式串的前缀子串
    private static void generateGS(char[] b, int m, int[] suffix, boolean[] prefix){
        for(int i = 0; i < m; i++){
            suffix[i] = -1;
            prefix[i] = false;
        }
        for(int i = 0; i < m - 1; i++){
            int j = i;
            int k = 0;
            while(j >= 0 && b[j] == b[m - k - 1]){//与b求公共后缀子串
                j--;
                k++;
                suffix[k] = j + 1;//因为上边j--，所有要+1，表示公共后缀子串在b[0,i]中的起始下标
            }
            if(j == -1) prefix[k] = true;
        }
    }

    public static int moveByGS(int j, int m, int[] suffix, boolean[] prefix){
        int k = m - 1 - j;//好后缀长度
        if(suffix[k] != -1) return j - suffix[k] + 1;
        for(int r = j + 2; r <= m - 1; r++){
            if(prefix[m - r]){
                return r;
            }
        }
        return m;
    }

    public static int bm(char[] a,int n, char[] b, int m){
        int[] bc = new int[SIZE];
        generateBC(b, m, bc);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0;
        while(n >= i + m){
            int j;
            for(j = m - 1; i >= 0; j--){
                if(a[i + j] != b[j])break;
            }
            if(j < 0){
                return i;
            }

            int x = j - bc[(int)a[i + j]];
            int y = 0;
            if(j < m - 1){//有好后缀
                y = moveByGS(j, m , suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    //*********KMP***********
    public static int[] getNexts(char[] b, int m){
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for(int i = 0; i < m; i++){
            while(k != -1 && b[k + 1] != b[i]){
                k = next[k];
            }
            if(b[k + 1] == b[i]){
                k++;
            }
            next[i] = k;
        }
        return next;
    }
    public static int kmp(char[] a, int n, char[] b, int m){
        int[] next = getNexts(b, m);
        int j = 0;
        for(int i = 0; i < n; i++){
            while(j > 0 && a[i] != b[j]){
                j = next[j - 1] + 1;
            }

            if(a[i] == b[j]){
                j++;
            }

            if(j == m){
                return i - m + 1;
            }
        }
        return -1;
    }

}
