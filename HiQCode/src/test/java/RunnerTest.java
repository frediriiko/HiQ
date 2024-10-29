import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
public class RunnerTest {

    @Test
    public void run() {
        Path testFile;
        try {
            testFile = Files.createTempFile("commandsTest", ".txt");
            try (FileWriter writer = new FileWriter(testFile.toFile())) {
                writer.write("PLACE,0,0,NORTH\n");
                writer.write("MOVE\n");
                writer.write("REPORT\n");
            }

            final Runner runner = new Runner();
            assertDoesNotThrow(() -> runner.run(testFile.toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runWithFirstCommandNotPlace() {
        Path testFile;
        try {
            testFile = Files.createTempFile("commandsTest", ".txt");
            try (FileWriter writer = new FileWriter(testFile.toFile())) {
                writer.write("MOVE\n");
                writer.write("PLACE,0,0,NORTH\n");
                writer.write("MOVE\n");
                writer.write("REPORT\n");
            }

            final Runner runner = new Runner();
            assertDoesNotThrow(() -> runner.run(testFile.toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runWithNoPlaceCommand() {
        Path testFile;
        try {
            testFile = Files.createTempFile("commandsTest", ".txt");
            try (FileWriter writer = new FileWriter(testFile.toFile())) {
                writer.write("MOVE\n");
                writer.write("REPORT\n");
            }

            final Runner runner = new Runner();
            assertDoesNotThrow(() -> runner.run(testFile.toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runFails() {
        Path testFile;
        try {
            testFile = Files.createTempFile("commandsTest", ".txt");
            try (FileWriter writer = new FileWriter(testFile.toFile())) {
                writer.write("PLACE,A,B,NORTH\n");
            }

            final Runner runner = new Runner();
            assertThrows(Exception.class, () -> runner.run(testFile.toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}