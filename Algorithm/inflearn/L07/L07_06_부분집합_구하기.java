package inflearn.L07;

/**
 * Created by Yohan lee
 * Created on 2023/02/06.
 * 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램 작성하세요.
 * <p>
 * Input
 * 첫번째줄에 자연수 N(1<=N<=10)이 주어집니다.
 * <p>
 * Output
 * 첫번째줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
 * 단 공집합은 출력하지 않는다.
 **/
public class L07_06_부분집합_구하기 {

    static int n;
    static int[] ch;

    public static void DFS(int l) {
        if (l == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += i + " ";
                }
            }
            if (0 < tmp.length()) {
                System.out.println(tmp);
            }
        } else {
            ch[l] = 1;
            DFS(l + 1);
            ch[l] = 0;
            DFS(l + 1);
        }
    }

    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];
        DFS(1);
    }
}
