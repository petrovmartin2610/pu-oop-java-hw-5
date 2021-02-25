import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Telephone extends JFrame implements MouseListener{
    private Object[][] screenPixels;
    Random identifier = new Random();
    boolean phoneIsBroken=false;
    int countdownUntilBroken=0;
    String[] functionalPhones = new String[1];
    String[] brokenPhones = new String[1];

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
        this.setTitle(telephoneName);
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

    private int tileCoordinates(int pixelCoordinates) {
        return pixelCoordinates / PixelLayout.pixelSize;
    }






    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(this.tileCoordinates(e.getX()));
        System.out.println(this.tileCoordinates(e.getY()));

        int row = this.tileCoordinates(e.getY());
        int col = this.tileCoordinates(e.getX());
        Color color = null;


        if(e.getClickCount() == 3) {
            Random definer = new Random();
            int defineIfPixelGetsBlack = definer.nextInt(20);
            if(defineIfPixelGetsBlack%2==0) {
                this.screenPixels[row][col] = new PixelLayout(row, col, PixelLayout.pixelType, Color.BLACK);
                this.repaint();
                countdownUntilBroken++;
            }
        }
        if(countdownUntilBroken>=2048){
            phoneIsBroken=true;
        }
    }


    public void appendPhoneToCategory(){
        if(phoneIsBroken){
            brokenPhones[0]=telephoneName;
            System.out.println("The phone " + telephoneName + " is broken.");
        } else {
            functionalPhones[0]=telephoneName;
            System.out.println("The phone " + telephoneName + " is functional.");
        }
    }




        Random modelNumbers = new Random();
        int modelNumber1 = modelNumbers.nextInt(5);
        int modelNumber2 = modelNumbers.nextInt(5);
        int modelNumber3 = modelNumbers.nextInt(5);
        String telephoneName = "PhoneModel" + modelNumber1 + modelNumber2 + modelNumber3;





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
