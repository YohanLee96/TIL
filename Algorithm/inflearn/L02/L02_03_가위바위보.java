package inflearn.L02;

import java.util.List;
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

    public List<String> solution(int n, int[] aResult, int[] bResult) {
        
        return null;
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
        System.out.println(program.solution(n, aArr, bArr));
    }
}
