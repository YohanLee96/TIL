package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yohan lee Created on 1/21/24. 선물을 직접 전하기 힘들 때 카카오톡 선물하기 기능을 이용해 축하 선물을 보낼 수 있습니다. 당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.<br/> 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두
 * 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.<br/> 예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.<br/> 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나
 * 받습니다.<br/> 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.<br/> 예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다. B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다.<br/> 만약 A와 B가 선물을 주고받은 적이
 * 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.<br/> 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.<br/> 위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.<br/> <br/> 친구들의 이름을 담은
 * 1차원 문자열 배열 friends 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 gifts가 매개변수로 주어집니다.<br/> 이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.<br/>
 **/
public class L1_가장_많이_받은_선물 {

    public static void main(String[] args) {
        L1_가장_많이_받은_선물 program = new L1_가장_많이_받은_선물();
        String[] friends1 = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts1 = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        String[] friends2 = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts2 = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        String[] friends3 = {"a", "b", "c"};
        String[] gifts3 = new String[]{"a b", "b a", "c a", "a c", "a c", "c a"};
        System.out.println(program.solution(friends1, gifts1));
        System.out.println(program.solution(friends2, gifts2));
        System.out.println(program.solution(friends3, gifts3));
    }

    public int solution(String[] friends, String[] gifts) {
        GiftInfoList giftInfoList = new GiftInfoList();
        for (String friendName : friends) {
            giftInfoList.add(friendName);
        }
        giftInfoList.bindHistories(gifts);
        return giftInfoList.getBestFriendGiftCount();
    }


    static class GiftInfoList {
        private final List<GiftInfo> list;

        public GiftInfoList() {
            this.list = new ArrayList<>();
        }

        public void bindHistories(String[] gifts) {
            for (String gift : gifts) {
                String[] giftInfo = gift.split(" ");
                String giverName = giftInfo[0];
                String receiverName = giftInfo[1];
                GiftInfo giverInfo = null;
                GiftInfo receiverInfo = null;
                for (GiftInfo info : list) {
                    if (info.name.equals(giverName)) {
                        giverInfo = info;
                        continue;
                    }
                    if (info.name.equals(receiverName)) {
                        receiverInfo = info;
                    }
                }
                //선물을 주었으므로 선물지수 +1
                giverInfo.giftIndex = giverInfo.giftIndex + 1;
                giverInfo.history.put(receiverName, giverInfo.history.getOrDefault(receiverName, 0) + 1);
                //선물을 받았으므로 선물지수 -1
                receiverInfo.giftIndex = receiverInfo.giftIndex - 1;
                receiverInfo.history.put(giverName, receiverInfo.history.getOrDefault(giverName, 0) -1);
            }
        }


        public void add(String friendName) {
            list.add(new GiftInfo(friendName));
        }

        public int getBestFriendGiftCount() {
            int bestGiftCount = 0;
            for (GiftInfo myGift : list) {
                int myGiftIndex = 0;
                String myName = myGift.name;
                for (GiftInfo friendGift : list) {
                    if(!friendGift.name.equals(myName)) {
                        String friendName = friendGift.name;
                        //내가 친구랑 주고받은 선물 카운트
                        int myGivenCount = myGift.history.getOrDefault(friendName, 0);
                        if(myGivenCount == 0) { //선물카운트가 동일하다면..
                            if(friendGift.giftIndex < myGift.giftIndex) { //선물지수 체크
                                myGiftIndex++;
                            }
                        } else if(0 < myGivenCount) { //내가준 횟수가 많다면..
                            myGiftIndex++;
                        }
                    }
                }
                if(bestGiftCount < myGiftIndex) {
                    bestGiftCount = myGiftIndex;
                }
            }
            return bestGiftCount;
        }
    }


    static class GiftInfo {

        //친구명
        public final String name;

        //선물지수
        public int giftIndex;
        //주고받은 선물 지수
        public Map<String, Integer> history;

        public GiftInfo(String name) {
            this.name = name;
            this.giftIndex = 0;
            this.history = new HashMap<>();
        }
    }


}
