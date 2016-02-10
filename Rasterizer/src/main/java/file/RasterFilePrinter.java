package file;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by darmanina on 09/02/2016.
 */
public class RasterFilePrinter {
    public void print(char[][] buffer, String filenameAndPath) {
        Path path = Paths.get(filenameAndPath);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.CREATE)) {
            for (char[] array : buffer) {
                writer.write(array);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
