package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yohan Lee. Created on 2024-03-03 <br/>
 * 코니는 영어 단어가 적힌 카드 뭉치 두 개를 선물로 받았습니다.  <br/>
 * 코니는 다음과 같은 규칙으로 카드에 적힌 단어들을 사용해 원하는 순서의 단어 배열을 만들 수 있는지 알고 싶습니다. <br/>
 * <hr/>
 * 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다. <br/>
 * 한 번 사용한 카드는 다시 사용할 수 없습니다. <br/>
 * 카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다. <br/>
 * 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다. <br/>
 * <hr/>
 * 예를 들어 첫 번째 카드 뭉치에 순서대로 ["i", "drink", "water"],  <br/>
 * 두 번째 카드 뭉치에 순서대로 ["want", "to"]가 적혀있을 때 ["i", "want", "to", "drink", "water"] 순서의 단어 배열을 만들려고 한다면  <br/>
 * 첫 번째 카드 뭉치에서 "i"를 사용한 후 두 번째 카드 뭉치에서 "want"와 "to"를 사용하고  <br/>
 * 첫 번째 카드뭉치에 "drink"와 "water"를 차례대로 사용하면 원하는 순서의 단어 배열을 만들 수 있습니다. <br/>
 * 문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때,  <br/>
 * cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return하는 solution 함수를 완성해주세요.
 **/
public class L1_카드_뭉치 {

    public static void main(String[] args) {
        L1_카드_뭉치 program = new L1_카드_뭉치();
        System.out.println(program.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
        System.out.println(program.solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> c1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> c2 = new LinkedList<>(Arrays.asList(cards2));
        for (String s : goal) {
            if(!c1.isEmpty() && c1.peek().equals(s)) {
                c1.poll();
            } else if(!c2.isEmpty() && c2.peek().equals(s)) {
                c2.poll();
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
