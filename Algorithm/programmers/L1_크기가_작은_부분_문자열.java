package programmers;

/**
 * Created by Yohan Lee. Created on 2024-02-20 <br/> 숫자로 이루어진 문자열 t와 p가 주어질 때, t에서 p와 길이가 같은 부분문자열 중에서, <br/> 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성하세요. <br/>
 **/
public class L1_크기가_작은_부분_문자열 {

    public static void main(String[] args) {
        L1_크기가_작은_부분_문자열 program = new L1_크기가_작은_부분_문자열();

        System.out.println(program.solution("3141592", "271"));
        System.out.println(program.solution("500220839878", "7"));
        System.out.println(program.solution("10203", "15"));
    }

    public int solution(String t, String p) {
        int cnt = 0;
        long num = Long.parseLong(p);
        int part = p.length();
        if (Long.parseLong(t.substring(0, part)) <= num) {
            cnt++;
        }
        for (int i = 0; i < t.length() - part; i++) {
            String slice = t.substring(i + 1, i + 1 + part);
            if (Long.parseLong(slice) <= num) {
                cnt++;
            }

        }
        return cnt;
    }
}
