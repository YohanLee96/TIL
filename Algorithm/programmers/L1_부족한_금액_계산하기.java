package programmers;

/**
 * Created by Yohan Lee. Created on 2024-02-14 <br/>
 * 새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다. <br/>
 * 이 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다. <br/>
 * 즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다. <br/>
 * 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요. <br/>
 * 단, 금액이 부족하지 않으면 0을 return 하세요.
 **/
public class L1_부족한_금액_계산하기 {
    public static void main(String[] args) {
        L1_부족한_금액_계산하기 solution = new L1_부족한_금액_계산하기();
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(solution.solution(price, money, count));
    }

    public long solution(int price, int money, int count) {
        long answer = 0L;
        for (int i = 1; i <= count; i++) {
            answer += (long) price * i;
        }
        answer -= money;
        return Math.max(answer, 0);
    }
}
