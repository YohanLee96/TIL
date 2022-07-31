package inflearn;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/07/31.
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 **/
public class L01_10_가장_짧은_문자거리 {


    public int[] solution(String str, char t) {
        int[] result = new int[str.length()];
        int p = 1000; //첫번째인덱스에선 비교할 문자가 없으므로, 문자개수 생각해서 넉넉하게 1000으로 초기화.(1000이상으로 지정된값은 역탐색 시, 변경됨)
        //왼쪽부터 탐색
        for (int i = 0; i < str.length(); i++) {
            if (t == str.charAt(i)) {
                p = 0;
            } else {
                p++;
            }
            result[i] = p;
        }

        //오른쪽 탐색
        p = 1000; //거리 초기화
        for (int i = str.length()-1; 0 <= i; i--) {
            if(t == str.charAt(i)) {
                p = 0; //이미 0이니까 값 초기화만함.
            } else {
                p++;
                //왼쪽에서 탐색할때 할당한값보다 작을 경우, 변경
                result[i] = Math.min(p, result[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        L01_10_가장_짧은_문자거리 program = new L01_10_가장_짧은_문자거리();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        char t = kb.next().charAt(0);
        for (int i : program.solution(s,t)) {
            System.out.print(i + " ");
        }
    }
}
