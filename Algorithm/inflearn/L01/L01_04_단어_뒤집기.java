package inflearn.L01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Yohan lee Created on 2022/07/28.
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 **/
public class L01_04_단어_뒤집기 {

    public ArrayList<String> solutionForStream(int n, String[] strs) {
        return Arrays.stream(strs)
                     .map(str -> new StringBuilder(str).reverse().toString())
                     .collect(Collectors.toCollection(() -> new ArrayList<>(n)));
    }

    public ArrayList<String> solutionForCharArray(int n, String[] strs) {
        ArrayList<String> results = new ArrayList<>(n);
        for (String result : strs) {
            char[] chars = result.toCharArray();
            int lt = 0;
            int rt = chars.length -1;
            while (lt < rt) {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(chars);
            results.add(tmp);
        }
        return results;
    }


    public static void main(String[] args) {
        L01_04_단어_뒤집기 program = new L01_04_단어_뒤집기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = kb.next();
        }

        for (String s : program.solutionForCharArray(n, str)) {
            System.out.println(s);
        }
    }
}
