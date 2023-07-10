package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

import java.io.File;

public class Money{
    private int mn;

    public Money(int a) {
        mn = a;
    }
    public int getMn(){
        return mn;
    }
    void increaseMoney(int amt, ImageView sf, ImageView p, Label label) throws Exception {
        //System.out.println(time);
        String imgAddress;
        File file;
        mn += amt;
        label.setText(Integer.toString(mn));
        if (mn >= 50) {
            imgAddress = "C:\\Users\\20-pc\\IdeaProjects\\Game\\src\\sample\\asset\\sfB.png";
            file = new File(imgAddress);
            Image img = new Image(file.toURI().toURL().toExternalForm());
            sf.setImage(img);
        }
        if (mn >= 100) {
            imgAddress = "C:\\Users\\20-pc\\IdeaProjects\\Game\\src\\sample\\asset\\peaB.png";
            file = new File(imgAddress);
            Image img = new Image(file.toURI().toURL().toExternalForm());
            p.setImage(img);
        }

    }
    void decreaseMoney(int amt, ImageView sf, ImageView p, Label label) throws Exception {
        String imgAddress;
        File file;
        mn -= amt;
        label.setText(Integer.toString(mn));
        if (mn < 50) {
            imgAddress = "C:\\Users\\20-pc\\IdeaProjects\\Game\\src\\sample\\asset\\sfBd.png";
            file = new File(imgAddress);
            Image img = new Image(file.toURI().toURL().toExternalForm());
            sf.setImage(img);
        }
        if (mn < 100) {
            imgAddress = "C:\\Users\\20-pc\\IdeaProjects\\Game\\src\\sample\\asset\\peaBd.png";
            file = new File(imgAddress);
            Image img = new Image(file.toURI().toURL().toExternalForm());
            p.setImage(img);
        }

    }


}
