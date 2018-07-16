package testing;

import gradle_publish_to_jcenter_demo.Hello;

public class HelloTesting {
    public static void main(String[] args) {
        System.out.println(new Hello().hello("JCenter"));
    }
}
