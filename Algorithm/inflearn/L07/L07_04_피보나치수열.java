package inflearn.L07;

/**
 * Created by Yohan lee
 * Created on 2023/02/01.
 * 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 입력은 피보나치 수열의 총 항 수이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하게 된다.
 * <p>
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 * <p>
 * 첫 줄에 피보나치 수열을 출력한다.
 **/
public class L07_04_피보나치수열 {

    static int[] fibo;

    public static int DFS(int n) {
        if(0 < fibo[n]) { //이미 구한값은 계산하지 않는다. (메모이제이션 기법)
            return fibo[n];
        }
        if (n == 1) {
            return fibo[n] =  1;
        } else if (n == 2) {
            return fibo[n] = 1;
        }
        return fibo[n] = DFS(n - 2) + DFS(n - 1);
    }

    public static void main(String[] args) {
        int n = 45;
        fibo = new int[n + 1];
        DFS(n);
        for(int i=1; i<=n; i++) {
            System.out.println  (fibo[i]);
        }
    }
}
