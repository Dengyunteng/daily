package cn.alogi;

public class 八皇后 {
    public static int[] result = new int[8];

    public static void printQueens(int[] result){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(j == result[i]){
                    System.out.print("Q ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isOk(int row, int column){
        int leftUp = column - 1;
        int rightUp = column + 1;
        for(int i = row - 1; i >= 0; i--){
            if(result[i] == column) return false;
            if(leftUp >= 0){
                if(result[i] ==  leftUp) return false;
            }
            if(rightUp < 8){
                if(result[i] == rightUp) return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    public static void cal8queens(int row){
        if(row == 8){
            printQueens(result);
            return;
        }

        for(int i = 0; i < 8; i++){
            if(isOk(row, i)){
                result[row] = i;
                cal8queens(row + 1);
            }
        }
    }

    public static void main(String[] args){
        cal8queens(0);
    }

    public static int maxW = Integer.MIN_VALUE;

    public static void f(int i, int cw, int[] items, int n, int w){
        if(cw == w || i == n){
            if(cw > maxW) maxW = cw;
            return;
        }
        f(i + 1, cw, items, n, w);
        if(cw + items[i] <= w){
            f(i + 1, cw + items[i], items, n, w);
        }
    }
}
