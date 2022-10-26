package inflearn.L05;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Yohan lee Created on 2022/10/24.
 * 문제설명이 길어, 링크로 대체.
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 **/
public class L05_03_크레인_인형뽑기 {


    public int solution(int n, int[][] board, int m, int[] moves) {
        int result = 0;
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            for (int i = 0; i < n; i++) {
                int pi = board[i][move -1];
                if(pi != 0) {
                    basket.push(pi);
                    board[i][move -1] = 0;
                    break;
                }
            }
            while (1 < basket.size() && (basket.peek().equals( basket.get(basket.size()-2)))) {
                basket.pop();
                basket.pop();
                result += 2;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        L05_03_크레인_인형뽑기 program = new L05_03_크레인_인형뽑기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }

        System.out.println(program.solution(n, board, m, moves));
    }
}
