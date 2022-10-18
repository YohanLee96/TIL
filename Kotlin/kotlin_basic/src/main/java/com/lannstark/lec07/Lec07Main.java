package com.lannstark.lec07;

import java.io.File;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public class Lec07Main {

    public static void main(String[] args) throws IOException {
        JavaFilePrinter printer = new JavaFilePrinter();
        printer.readFile();
        printer.readFile(new File(".").getAbsolutePath() + "/a.txt");
    }

    int parseIntToThrow(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다.", str));
        }
    }

    Integer parseIntToThrow2(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
