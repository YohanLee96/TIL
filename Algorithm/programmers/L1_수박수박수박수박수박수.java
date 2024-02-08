package programmers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Yohan lee Created on 2/8/24. <br/>
 * 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.  <br/>
 * 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다. <br/>
 **/
public class L1_수박수박수박수박수박수 {
    public static void main(String[] args) {
        L1_수박수박수박수박수박수 program = new L1_수박수박수박수박수박수();
        System.out.println(program.solution(3));
        System.out.println(program.solution(4));
    }

    public String solution(int n) {
        return IntStream.range(1, n+1)
                        .mapToObj(value -> value % 2 == 0 ? "박" : "수")
                        .collect(Collectors.joining());
    }
}
