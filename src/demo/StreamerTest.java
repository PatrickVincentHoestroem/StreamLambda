package demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

class StreamerTest {

    private Streamer streamer;
    private String uri;

    @BeforeEach
    void setup() {
        streamer = new Streamer();
        uri = "C:/Users/patri/Downloads/Grupper_Dat20V2_2021_03_10.txt";
    }

    @Test
    void printGroupTest() throws IOException {
        streamer.printGroup('A', uri);
    }

    @Test
    void printSortedTest() throws FileNotFoundException {
        streamer.printSorted(uri);
    }

}