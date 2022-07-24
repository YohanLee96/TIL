package programmers;

import java.util.Locale;

/**
 * Created by Yohan lee Created on 2022/07/24.
 * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
 * s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
 * 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 **/
public class L1_문자열_내_p와_y의_개수 {

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }


    public static boolean solution(String s) {
        String lowerStr = s.toLowerCase(Locale.ROOT);
        int pCount = 0;
        int yCount = 0;
        for (char c : lowerStr.toCharArray()) {
            if(c == 'p') {
                ++pCount;
            } else if(c =='y') {
                ++yCount;
            }
        }

        if(pCount == 0 & yCount == 0) {
            return true;
        }


        return pCount == yCount;
    }
}
