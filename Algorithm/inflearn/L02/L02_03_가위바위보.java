package inflearn.L02;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/08/07.
 * A, B 두 사람이 가위바위보 게임을 합니다.
 * 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다.
 * 비길 경우에는 D를 출력합니다.
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면
 * 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 **/
public class L02_03_가위바위보 {

    public String solution(int n, int[] a, int[] b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int aResult = a[i];
            int bResult = b[i];
            if(aResult == 1 && bResult == 3) {
                result.append("A");
            } else if (aResult == 2 && bResult ==1) {
                result.append("A");
            } else if (aResult == 3 && bResult ==2) {
                result.append("A");
            } else if(aResult == bResult) {
                result.append("D");
            } else { //A가 이기는 경우와 비기는경우를 모두 체크했으니, 나머지는 B승리.
                result.append("B");
            }

        }

        return result.toString();
    }


    public static void main(String[] args) {
        L02_03_가위바위보 program = new L02_03_가위바위보();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] aArr = new int[n];
        int[] bArr = new int[n];
        for (int i = 0; i < n; i++) {
            aArr[i] = kb.nextInt();
        }
        for (int i = 0; i <n; i++) {
            bArr[i] = kb.nextInt();
        }
        for (char c : program.solution(n, aArr, bArr).toCharArray()) {
            System.out.println(c);
        }
    }
}
