import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * @author Martin Petrov
 * Клас Telephone, генерериращ телефонните екрани чрез метода telephoneScreen(), изрисуващ отделните пиксели чрез
 * paint(Graphics g) метода, връщащ отделни пиксели чрез обекта GetBoardPixel, определящ координатите на пикселите
 * чрез метода tileCoordinates(), извършващ преоцветяване на пикселите чрез MouseListener метода и определяне на съответната
 * категория на телефона (функциониращ или не) чрез appendPhoneToCategory()
 */
public class Telephone extends JFrame implements MouseListener{
    private Object[][] screenPixels;                //обект масив,съхраняващ всички пиксели
    Random identifier = new Random();               //променлива генерираща random стойности
    boolean phoneIsBroken=false;                    //променлива определяща дали телефона е счупен или не
    int countdownUntilBroken=0;                     //променлива, служеща за отброяване на пикселите до брой, който прави телефона дефектен
    String[] functionalPhones = new String[1];      //масив от стрингове, съдържащ имената на здравите телефони
    String[] brokenPhones = new String[1];          //масив от стрингове, съдържащ имената на счупените телефони

    //метод, изобразяващ екрана и пикселите
    public void telephoneScreen() {
        this.screenPixels = new Object[64][64];         //определяне размерността на обект масива
        int randomPixel=identifier.nextInt(3);   //генериране на произволна стойност от 1 до 3
        int pixelType=identifier.nextInt(3);     //генериране на произволна стойност от 1 до 3, определяща типа пиксел (цвят)
        Color color = null;

        for(int row=0; row<64; row++){
            for(int col=0; col<64; col++){
                switch(randomPixel){                //switch, който водейки се по стойностите на randomPixel, определя какъв цвят да е съответния пиксел
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
        this.setTitle(telephoneName);                   //заглавието на JFrame прозореца съвпада с генерираното име за този телефон
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }


    //метод, изобразяващ самите пиксели
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

    //обект взимащ всеки отделен пиксел
    private Object getBoardPixel(int row, int col) {
        return this.screenPixels[row][col];
    }

    //метод взимащ координатите на отделните пиксели
    private int tileCoordinates(int pixelCoordinates) {
        return pixelCoordinates / PixelLayout.pixelSize;
    }


    //метод, който при кликане определя дали пиксела е изгорял или не
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


    //метод, определящ съответния телефон към коя категория спада
    public void appendPhoneToCategory(){
        if(phoneIsBroken){
            brokenPhones[0]=telephoneName;
            System.out.println("The phone " + telephoneName + " is broken.");
        } else {
            functionalPhones[0]=telephoneName;
            System.out.println("The phone " + telephoneName + " is functional.");
        }
    }



    //генериране на име за отделните телефони
    Random modelNumbers = new Random();
    int modelNumber1 = modelNumbers.nextInt(5);
    int modelNumber2 = modelNumbers.nextInt(5);
    int modelNumber3 = modelNumbers.nextInt(5);
    String telephoneName = "PhoneModel" + modelNumber1 + modelNumber2 + modelNumber3;




    //излишни методи
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
