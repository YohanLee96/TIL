package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yohan Lee. Created on 2024-03-29 <br/> 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. <br/> 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다. <br/> 이 문제를 어떻게 할까
 * 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. <br/> 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라. <br/> 실패율은 다음과 같이 정의한다. <br/> - 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 /
 * 스테이지에 도달한 플레이어 수 <br/> 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, <br/> 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨 있는 배열을 return 하도록 solution 함수를 완성하라. <br/> <br/> 제한사항 <br/>
 * - 스테이지의 개수 N은 1 이상 500 이하의 자연수이다. <br/> - stages의 길이는 1 이상 200,000 이하이다. <br/> - stages에는 1 이상 N + 1 이하의 자연수가 담겨 있다. <br/> - 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다. <br/> - 단, N + 1 은 마지막 스테이지(N 번째
 * 스테이지) 까지 클리어 한 사용자를 나타낸다. <br/> - 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다. <br/> - 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다. <br/>
 **/
public class L1_실패율 {

    public static void main(String[] args) {
        L1_실패율 program = new L1_실패율();
        //3, 4, 2, 1, 5
        System.out.println(Arrays.toString(program.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        //4, 1, 2, 3
        System.out.println(Arrays.toString(program.solution(4, new int[]{4, 4, 4, 4, 4})));
    }

    public int[] solution(int stageCount, int[] stages) {
        int[] answer = {};
        Map<Integer, Double> stageMap = new HashMap<>();
        Arrays.sort(stages);
        double pi = 0;
        int num = stages[0];
        double length =  stages.length;
        for (int i = 0; i < stages.length; i++) {
            if (num != stages[i]) {
                if(stageCount < stages[i]) {
                    //모든 스테이지 클리어자 빼주기
                    stageMap.put(stages[i] - 1, (i - pi) - (length - i) / (length - pi));
                    break;
                } else {
                    stageMap.put(num, (i - pi) / (length - pi));
                    pi = i;
                    num = stages[i];
                }

            }
        }
        return answer;
    }
}
