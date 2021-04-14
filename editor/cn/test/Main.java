package test;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        System.out.println(i++);
        System.out.println(++i);
        Stream.of(1).reduce(Integer::sum);
    }

}

