package com.aritra.contests.atcoder.problems;

import java.util.*;

public class ShoutEveryday {
    public static void main(String[] args) {
        Scanner fs = new Scanner(System.in);
        long femaleTime = fs.nextLong();
        long bedNight = fs.nextLong();
        long bedMorning = fs.nextLong();

        if (bedMorning <= femaleTime && bedNight < bedMorning) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

