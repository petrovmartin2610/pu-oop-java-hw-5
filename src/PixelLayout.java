import javax.swing.*;
import java.awt.*;

public class PixelLayout {
    private int row;
    private int col;
    Color color;
    public static int pixelType;
    public static int pixelSize = 9;

    public PixelLayout(int row, int col, int pixelType, Color color){
        this.row=row;
        this.col=col;
        this.pixelType=pixelType;
        this.color=color;
    }

    public void render(Graphics g) {
        int tileX = this.col * pixelSize;
        int tileY = this.row * pixelSize;
        g.setColor(this.color);
        g.fillRect(tileX, tileY, pixelSize, pixelSize);
    }



}
