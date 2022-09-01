package inflearn.L02;

import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/09/01.
 * 지도 정보가 N*N 격자판에 주어집니다.
 * 각 격자에는 그 지역의 높이가 쓰여있습니다.
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다.
 * 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 * 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
 * Input
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50) 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다.
 * 각 자연수는 100을 넘지 않는다.
 * Output
 * 봉우리의 개수를 출력하세요.
 **/
public class L02_10_봉우리 {

    //위, 오른쪽, 아래, 왼
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] arr, int n) { //Good Case
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if((nx >=0 &&  nx < n &&  ny>=0 && ny < n) && arr[nx][ny]>= arr[i][j] ) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    result++;
                }
            }
        }
        return result;
    }

    public int solutionByIf(int[][] arr, int n) { //Bad Case
        int result = 0; //봉우리 개수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = arr[i][j];
                CheckEdgePeak check = new CheckEdgePeak(arr, i, j);
                if(check.isPeak()) {
                    result++;
                }
            }
        }
        return result;
    }

    static class CheckEdgePeak {

        private final int me;
        private int left;
        private int right;
        private int top;
        private int bottom;

        public boolean isPeak() {
            return left < me && right < me && top < me && bottom < me;
        }

        public CheckEdgePeak(int[][] arr, int rowIdx, int colIdx) {
//            System.out.println("현재 인덱스 : " + rowIdx + "," + colIdx);
            int lastIdx = arr.length -1;
            this.me = arr[rowIdx][colIdx];
            if(rowIdx == 0 && colIdx == 0) { //왼쪽 위 모서리
                this.right = arr[rowIdx][colIdx+1];
                this.bottom = arr[rowIdx +1][colIdx];
            } else if(rowIdx == 0 && colIdx != lastIdx) { //위 중간
                this.left = arr[rowIdx][colIdx-1];
                this.right = arr[rowIdx][colIdx+1];
                this.bottom = arr[rowIdx +1][colIdx];
            } else if (rowIdx == 0) { //오른쪽 위 모서리
                this.left = arr[rowIdx][colIdx-1];
                this.bottom = arr[rowIdx +1][colIdx];
            } else if (rowIdx != lastIdx && 0 == colIdx) { //왼쪽 가장자리 중간
                this.right = arr[rowIdx][colIdx+1];
                this.top = arr[rowIdx-1][colIdx];
                this.bottom = arr[rowIdx +1][colIdx];
            } else if(rowIdx == lastIdx && colIdx == 0) { //왼쪽 가장자리 아래 모서리
                this.right = arr[rowIdx][colIdx+1];
                this.top = arr[rowIdx-1][colIdx];
            } else if(rowIdx == lastIdx && colIdx != lastIdx) { //아래 중간
                this.top = arr[rowIdx-1][colIdx];
                this.left = arr[rowIdx][colIdx-1];
                this.right = arr[rowIdx][colIdx+1];
            } else if(rowIdx == lastIdx) { //오른쪽 가장자리 아래 모서리
                this.top = arr[rowIdx-1][colIdx];
                this.left = arr[rowIdx][colIdx-1];
            } else if (colIdx == lastIdx) { //오른쪽 가장자리 중간
                this.top = arr[rowIdx-1][colIdx];
                this.left = arr[rowIdx][colIdx-1];
                this.bottom = arr[rowIdx +1][colIdx];
            } else { //나머지 정상
                this.left = arr[rowIdx][colIdx-1];
                this.right = arr[rowIdx][colIdx+1];
                this.top = arr[rowIdx-1][colIdx];
                this.bottom = arr[rowIdx+1][colIdx];
            }
        }
    }




    public static void main(String[] args) {
        L02_10_봉우리 program = new L02_10_봉우리();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.print(program.solution(arr, n));
    }
}
