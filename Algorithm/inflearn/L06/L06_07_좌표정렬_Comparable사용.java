package inflearn.L06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yohan lee
 * Created on 2023/01/04.
 **/
public class L06_07_좌표정렬_Comparable사용 {

    static class Point implements Comparable<Point> {
        public int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x == this.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        L06_07_좌표정렬_Comparable사용 program = new L06_07_좌표정렬_Comparable사용();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            points.add(new Point(x, y));
        }

        Collections.sort(points);
        for (Point point : points) {
            System.out.println(point.x+ " "+ point.y);
        }

    }
}
