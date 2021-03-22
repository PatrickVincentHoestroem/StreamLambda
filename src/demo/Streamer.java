package demo;

import java.io.*;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Streamer {

    public void iter() {
        Stream.iterate(1, element->element+1)
        .filter(element->element%5==0)
        .limit(5)
        .forEach(System.out::println);
    }

    public void printGroup(final char grp, String uri) throws IOException {
        Stream<String> stringStream = new BufferedReader(new FileReader(uri)).lines();
        /*
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }

        Stream<Character> characterStream = br.readLine().chars().mapToObj(c ->(char) c);
        characterStream.forEach(System.out::println);
        */

        stringStream.forEach((a)->{
            /*
            a.chars().mapToObj(c->(char)c).forEach(b->{
                System.out.print(b);
            });
            */
            if (Pattern.matches("^("+grp+";)(;.*;.*)$", a)) {
                System.out.println(a);
            }
        });
    }

    public void printSorted(String uri) throws FileNotFoundException {
        Stream<String> stringStream = new BufferedReader(new FileReader(uri)).lines().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (o1.split(";")[2].charAt(0)>o2.split(";")[2].charAt(0)) {
                    return 1;
                } else if (o1.split(";")[2].charAt(0)==o2.split(";")[2].charAt(0)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        stringStream.forEach(System.out::println);

    }
}
