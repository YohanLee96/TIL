package programmers;

/**
 * Created by Yohan Lee. Created on 2024-03-01 <br/>
 * 오래전 유행했던 콜라 문제가 있습니다. 콜라 문제의 지문은 다음과 같습니다.  <br/>
 * 정답은 아무에게도 말하지 마세요.
 * <br/>
 * <hr/>
 * 콜라 빈 병 2개를 가져다주면 콜라 1병을 주는 마트가 있다. 빈 병 20개를 가져다주면 몇 병을 받을 수 있는가?
 * <br/>
 * 단, 보유 중인 빈 병이 2개 미만이면, 콜라를 받을 수 없다.
 * <hr/>
 * <br/>
 * 문제를 풀던 상빈이는 콜라 문제의 완벽한 해답을 찾았습니다.
 * 상빈이가 푼 방법은 아래 그림과 같습니다.
 * 우선 콜라 빈 병 20병을 가져가서 10병을 받습니다. 받은 10병을 모두 마신 뒤, 가져가서 5병을 받습니다.
 * 5병 중 4병을 모두 마신 뒤 가져가서 2병을 받고, 또 2병을 모두 마신 뒤 가져가서 1병을 받습니다.
 * 받은 1병과 5병을 받았을 때 남은 1병을 모두 마신 뒤 가져가면 1병을 또 받을 수 있습니다.
 * 이 경우 상빈이는 총 10 + 5 + 2 + 1 + 1 = 19병의 콜라를 받을 수 있습니다.
 **/
public class L1_콜라_문제 {

    public static void main(String[] args) {
        L1_콜라_문제 program = new L1_콜라_문제();
        System.out.println(program.solution(2, 1, 20));
        System.out.println(program.solution(3, 1, 20));
        System.out.println(program.solution(4, 3, 20));
    }

    public int solution(int a, int b, int n) {
            int answer = 0;
            int temp = n;
            while(a <= temp) {
                int eat = temp/a * b;
                answer += eat;
                temp = eat + temp%a;
            }
            return answer;
        }

    }
