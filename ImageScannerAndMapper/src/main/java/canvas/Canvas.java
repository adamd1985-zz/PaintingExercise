package canvas;

/**
 * Created by darmanina on 10/02/2016.
 */
public class Canvas {
    public final char[][] buffer;
    public final int rows;
    public final int columns;

    public Canvas(int rows, int columns) {
        this.buffer = new char[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }
}
