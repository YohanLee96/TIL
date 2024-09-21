package programmers;

import java.time.Duration;

/**
 * Created by Yohan Lee. Created on 2024-09-22 <br/> 
 **/
public class L1_동영상_재생기_PCCP {


    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] videoArr = video_len.split(":");
        String[] posArr = pos.split(":");
        String[] opsArr = op_start.split(":");
        String[] opeArr = op_end.split(":");
        Duration videoTotalTime = Duration.ofMinutes(Integer.parseInt(videoArr[0])).plusSeconds(Integer.parseInt(videoArr[1]));
        Duration opStartTime = Duration.ofMinutes(Integer.parseInt(opsArr[0])).plusSeconds(Integer.parseInt(opsArr[1]));
        Duration opEndTime = Duration.ofMinutes(Integer.parseInt(opeArr[0])).plusSeconds(Integer.parseInt(opeArr[1]));
        Duration posTime = validationTime(
            Duration.ofMinutes(Integer.parseInt(posArr[0])).plusSeconds(Integer.parseInt(posArr[1])),
            opStartTime,
            opEndTime,
            videoTotalTime
        );
        final int MOVING_TIME = 10;
        for (String command : commands) {
            if("prev".equals(command)) {
                posTime = validationTime(posTime.minusSeconds(MOVING_TIME), opStartTime, opEndTime, videoTotalTime);
            } else {
                posTime = validationTime(posTime.plusSeconds(MOVING_TIME), opStartTime, opEndTime, videoTotalTime);
            }
        }
        return String.format("%02d:%02d", posTime.getSeconds() / 60, posTime.getSeconds() % 60);
    }



    private Duration validationTime(Duration nowTime, Duration opStartTime, Duration opEndTime, Duration videoTotalTime) {
        if(0 <= nowTime.compareTo(opStartTime) && nowTime.compareTo(opEndTime) <= 0) {
            return opEndTime;
        }
        if(nowTime.isNegative()) {
            if(opStartTime.isZero()) {
                return opEndTime;
            }
            return Duration.ofSeconds(0);
        }
        if(0 <= nowTime.compareTo(videoTotalTime)) {
            return videoTotalTime;
        }
        return nowTime;
    }


    public static void main(String[] args) {
        L1_동영상_재생기_PCCP program = new L1_동영상_재생기_PCCP();
//        System.out.println(program.solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        System.out.println(program.solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
    }
}
