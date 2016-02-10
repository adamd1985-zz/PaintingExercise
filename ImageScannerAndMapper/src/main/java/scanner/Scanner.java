package scanner;

import canvas.Canvas;
import scanner.graphics.GraphicEntry;

import java.util.List;

/**
 * Created by darmanina on 10/02/2016.
 */
public interface Scanner<T extends GraphicEntry> {
    public List<T> scan(Canvas canvas);
}
