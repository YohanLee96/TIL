package programmers;


/**
 * Created by Yohan lee Created on 2/6/24. <br/>
 * String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. <br/>
 * seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.<br/>
 * <p>
 *  seoul은 길이 1 이상, 1000 이하인 배열입니다. <br/>
 *  seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.<br/>
 * "Kim"은 반드시 seoul 안에 포함되어 있습니다.<br/>
 * </p>
 **/
public class L1_서울에서_김서방_찾기 {

    public static void main(String[] args) {
        L1_서울에서_김서방_찾기 program = new L1_서울에서_김서방_찾기();
        System.out.println(program.solution(new String[]{"Jane", "Kim"}));;
    }

    public String solution(String[] seoul) {
        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                return "김서방은 %d에 있다".formatted(i);
            }
        }
        return null;
    }
}
