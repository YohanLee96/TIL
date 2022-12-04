package inflearn.L06;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/11/30.
 * 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
 * 필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
 * 철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
 * LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
 *
 * 캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
 * https://cote.inflearn.com/public/upload/c366c701c2.jpg
 * 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
 * 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
 *
 * Input
 * 첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
 * 두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.
 *
 * Output
 * 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.
 **/
public class L06_04_Least_Recently_Used {


    public int[] solution(int n, int s, int[] arr) {
        int[] cache = new int[s];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < s; i++) {
                if(cache[i] == x) {
                    pos = i;
                }
            }
            if(pos == -1) { //캐시미스일 경우, 한칸씩 밀기.
                for (int i = s-1; 1 <= i; i--) {
                    cache[i] = cache[i-1];
                }
            } else { //캐시히트일 경우, 캐시히트한 인덱스부터 한칸씩 밀기.
                for (int i =pos; 1 <= i; i--) {
                    cache[i] = cache[i-1];
                }
            }

            //미스든 히트든간에 항상 첫번째에 위치.
            cache[0] = x;
        }

        return cache;
    }

    public static void main(String[] args) {
        L06_04_Least_Recently_Used program = new L06_04_Least_Recently_Used();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int i : program.solution(n, s, arr)) {
            System.out.print(i + " ");
        }
    }
}
