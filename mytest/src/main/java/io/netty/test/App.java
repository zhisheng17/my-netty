package io.netty.test;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List list = Arrays.asList("1", "2");
        list.stream().forEach(System.out::println);
    }
}
