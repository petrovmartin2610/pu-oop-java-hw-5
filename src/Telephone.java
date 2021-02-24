import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Telephone extends JFrame implements MouseListener {
    private Object[][] screenPixels;
    Random identifier = new Random();

    public void telephoneScreen() {
        this.screenPixels = new Object[64][64];

        int randomPixel=identifier.nextInt(3);
        int pixelType=identifier.nextInt(3);
        Color color = null;
        for(int row=0; row<64; row++){
            for(int col=0; col<64; col++){
                switch(randomPixel){
                    case 0:
                        this.screenPixels[row][col] = new PixelLayout(row,col,pixelType,color.BLUE);
                    break;

                    case 1:
                        this.screenPixels[row][col] = new PixelLayout(row,col,pixelType,color.GREEN);
                    break;

                    case 2:
                        this.screenPixels[row][col] = new PixelLayout(row,col,pixelType,color.RED);
                    break;
                }
                randomPixel=identifier.nextInt(3);
                pixelType=identifier.nextInt(3);

            }
        }

        this.setSize(640, 640);
        this.setVisible(true);
        this.setTitle("Pixels");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int row = 0; row < 64; row++) {
            for (int col = 0; col < 64; col++) {
                PixelLayout pl1 = (PixelLayout) this.getBoardPixel(row, col);
                pl1.render(g);

            }
        }
    }
    private Object getBoardPixel(int row, int col) {
        return this.screenPixels[row][col];
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
