package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yohan lee Created on 2022/07/26.
 **/
public class L1_신고_결과_받기 {

    public static void main(String[] args) {
        solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
    }

    /**
     *
     * @param id_list 유저 ID 리스트
     * @param report 신고리포트(공백으로 이용자 ID, 신고자 ID 구별)
     * @param k 정지되는 신고횟수
     * return
     */
    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportResult = new HashMap<>();
        Map<String, String> reportHistory = new HashMap<>();
        for (String rIdMap : report) {
            String[] splitReport = rIdMap.split(" ");
            String reporter = splitReport[0];
            String problemer = splitReport[1];
            if(!reportHistory.getOrDefault(reporter, reporter).equals(problemer)) {
                reportResult.put(problemer, reportResult.getOrDefault(problemer, 0) +1);
                reportHistory.put(reporter, problemer);
            }
        }

        int[] answer = {};
        return answer;
    }





}
