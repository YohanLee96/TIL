package programmers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Yohan lee Created on 2022/07/21. 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다. 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의
 * 이름을 return 하도록 solution 함수를 작성해주세요
 **/
public class L1_완주하지못한선수 {

    public static void main(String[] args) {
        solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
    }

    /**
     * @param participants 참여자 배열
     * @param completions  완주자 배열
     * @return 완주하지 못한자
     */
    public static String solution(String[] participants, String[] completions) {
        Arrays.sort(completions);
        Arrays.sort(participants);
        for (int i = 0; i < participants.length; i++) {
            if(participants.length -1 == i) {
                System.out.println(participants[participants.length-1]);
                return participants[participants.length-1];
            }
            String participant = participants[i];
            String completion = completions[i];
            if(!participant.equals(completion)) {
                System.out.println(participant);
                return participant;
            }
        }

        return null;
    }

    //해시맵을 이용한 정답
    public static String solutionHash(String[] participants, String[] completions) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participants) {
            hm.put(player, hm.getOrDefault(player, 0) +1);
        }
        for (String player : completions) {
            hm.put(player, hm.get(player) -1);
        }

        for (String key : hm.keySet()) {
            if(hm.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }

}
