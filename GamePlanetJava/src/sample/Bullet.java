package sample;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.File;

public class Bullet {
    private int lx;
    private int ly;
    private ImageView z;
    private AnchorPane a;
    private Easy e;


    public Bullet(AnchorPane ap, Easy e1, int x, int y) {
        a=ap;
        e = e1;
        lx = x;
        ly = y;
        String imgAddress;
        File file;
        Image img;
        imgAddress = "C:\\Users\\20-pc\\IdeaProjects\\Game\\src\\sample\\asset\\bullet.png";
        file = new File(imgAddress);
        try {
            img = new Image(file.toURI().toURL().toExternalForm());
            z = new ImageView(img);
            z.setX(lx);
            z.setY(ly);
            z.setScaleX(0.7);
            z.setScaleY(0.7);
            ap.getChildren().add(z);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void move() {
        z.setX(z.getX() + 4);
        if (Math.abs(590-z.getX())<7) {
            a.getChildren().remove(z);
            e.remB(this);
        }
    }
    public double getX(){
        return  z.getX();
    }
    public double getY(){
        return  z.getY();
    }
    public void remove(){
        a.getChildren().remove(z);
    }
}

