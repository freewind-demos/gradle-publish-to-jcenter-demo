package demos.gradle_publish_to_local_maven_demo;

import demos.gradle_publish_to_jcenter_demo.Hello;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class HelloSpec {

    @Test
    public void shouldSayHello() {
        String greeting = new Hello().hello("gradle");
        assertThat(greeting).isEqualTo("Hello, gradle");
    }

}
