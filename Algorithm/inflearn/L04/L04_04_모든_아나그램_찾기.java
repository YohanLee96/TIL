package inflearn.L04;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Created by Yohan lee Created on 2022/10/02.
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 * Input
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 * Output
 * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 **/
public class L04_04_모든_아나그램_찾기 {

    public int solution(String s, String t) {
        int result = 0;


        Map<Character, Integer> anagram = new HashMap<>();
        for (char c : t.toCharArray()) { //아나그램 체크 해시 생성
            anagram.put(c, anagram.getOrDefault(c, 0) + 1);
        }

        //Sliding Window 처리를 위해 t-1 만큼의 put.
        Map<Character, Integer> checkHash = new HashMap<>();
        for (int i = 0; i < t.length() -1; i++) {
            increase(checkHash, s.charAt(i));
        }
        for (int i = t.length() -1; i < s.length(); i++) {
            increase(checkHash, s.charAt(i));
            if(checkHash.equals(anagram)) {
                result++;
            }
            decrease(checkHash, s.charAt(i - (t.length() -1)));
        }

        return result;
    }

    private void increase(Map<Character, Integer> checkHash, char c) {
        checkHash.put(c, checkHash.getOrDefault(c, 0) + 1);
    }

    private void decrease(Map<Character, Integer> checkHash, char c) {
        if(checkHash.get(c) == 1) {
            checkHash.remove(c);
        } else {
            checkHash.put(c, checkHash.get(c) -1);
        }
    }


    public static void main(String[] args) {
        L04_04_모든_아나그램_찾기 program = new L04_04_모든_아나그램_찾기();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        String k = kb.nextLine();
        System.out.println(program.solution(s, k));
    }
}
