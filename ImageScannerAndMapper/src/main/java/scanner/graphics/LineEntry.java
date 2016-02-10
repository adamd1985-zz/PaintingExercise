package scanner.graphics;

/**
* Created by darmanina on 10/02/2016.
*/
public class LineEntry extends GraphicEntry {
    public final int rowStart;
    public final int rowEnd;
    public final int colStart;
    public final int colEnd;

    public LineEntry(int rowStart, int colStart, int rowEnd, int colEnd) {
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.colStart = colStart;
        this.colEnd = colEnd;
    }
}
