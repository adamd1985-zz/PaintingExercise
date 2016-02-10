package file;

import canvas.Canvas;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by darmanina on 09/02/2016.
 */
public class RasterFileReader {
    public Canvas loadImage(String filenameAndPath) {
        boolean measurementsLoaded = false;

        Canvas canvas = null;
        Path path = Paths.get(filenameAndPath);
        int currentRow = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filenameAndPath))) {
            while (reader.ready()) {
                if (!measurementsLoaded) {
                    measurementsLoaded = true;
                    String mearsurementsStr = reader.readLine();
                    String[] measurements = mearsurementsStr.trim().split(" ");
                    int rows = Integer.parseInt(measurements[0]);
                    int columns = Integer.parseInt(measurements[1]);

                    canvas = new Canvas(rows, columns);
                } else {
                    String rasterLine = reader.readLine();
                    int currentColumn = 0;

                    for (char c : rasterLine.toCharArray()) {
                        canvas.buffer[currentRow][currentColumn++] = c;
                    }
                    currentRow++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return canvas;
    }
}
