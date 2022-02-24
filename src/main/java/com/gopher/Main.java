package com.gopher;

import java.util.Arrays;

/**
 * @Title Main
 * @Author fyw
 * @Date 2022-02-24 20:27
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        String s=
                "42/47/51/53/61/68/72/97/197/114/134/135/166/188/214/218/221/233/234/237/238/240/241/257/258/260/264/268/273/279/287/292/307/309/310/315/329/337/357/365/378/390/391/395/399/400";
        String[] split = s.split("/");
        System.out.println(split.length);
        System.out.println(Arrays.toString(split));
    }
}
