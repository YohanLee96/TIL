package inflearn.L06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Yohan lee
 * Created on 2023/01/04.
 * 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
 * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
 *
 * Input
 * 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
 * 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
 * Output
 * 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
 **/
public class L06_08_이분검색 {


    public int solution(int n, int m, int[] arr) {
        int result = 0;
        Arrays.sort(arr);
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] < m) {
                low = mid +1;
            } else if(m < arr[mid]) {
                high = mid -1;
            } else {
                result = mid+1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L06_08_이분검색 program = new L06_08_이분검색();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(program.solution(n, m, arr));
    }
}
