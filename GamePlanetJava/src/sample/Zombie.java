package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Zombie {
    private AnchorPane a;
    private ImageView z;
    private int life;
    private Easy e;
    public Zombie(AnchorPane ap,Easy e1, int x, int y)  {
        e=e1;
        life=4;
        a=ap;
        String imgAddress;
        File file;
        Image img;
        imgAddress = "C:\\Users\\20-pc\\IdeaProjects\\Game\\src\\sample\\asset\\z1.gif";
        file = new File(imgAddress);
        try {
            img = new Image(file.toURI().toURL().toExternalForm());
            z=new ImageView(img);
            z.setX(x);
            z.setY(y);
            z.setScaleX(0.5);
            z.setScaleY(0.5);
            ap.getChildren().add(z);
        } catch (Exception e){
           System.out.println(e.getMessage());
        }
    }
    public void move()  {
        z.setX(z.getX()-1);
        if (z.getX()==0){
            z.getScene().getWindow().hide();
            Easy.setStart(0);
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Game Over");
                stage.setScene(new Scene(root, 541, 388));
                stage.show();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public double getX() {
        return z.getX();
    }
    public double getY() {
        return z.getY();
    }
    public void decLife() {
        life--;
        //System.out.println(life);
        if (life == 0) {
            a.getChildren().remove(z);
            e.incScore();

            e.remZ(this);
        }
    }
}
