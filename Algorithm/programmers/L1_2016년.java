package programmers;

import java.time.LocalDate;

/**
 * Created by Yohan Lee. Created on 2024-03-03 <br/> 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각
 * SUN,MON,TUE,WED,THU,FRI,SAT입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요. <br/>
 * <b>제한 조건</b>  <br/>
 * 2016년은 윤년입니다. <br/> 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다) <br/>
 **/
public class L1_2016년 {

    public static void main(String[] args) {
        L1_2016년 program = new L1_2016년();
        System.out.println(program.solution(5, 24));
    }

    public String solution(int a, int b) {
        return LocalDate.of(2016, a, b)
                        .getDayOfWeek()
                        .name()
                        .substring(0, 3);
    }
}
