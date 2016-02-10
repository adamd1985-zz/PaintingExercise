package command;

import canvas.Canvas;

/**
 * Created by darmanina on 09/02/2016.
 */
public abstract class Command {
    public abstract void execute(Canvas canvas);

    public abstract String getCommand();
}
