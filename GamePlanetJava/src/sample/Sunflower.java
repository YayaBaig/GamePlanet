package sample;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Sunflower {
    private int lx;
    private int ly;
    private ImageView z;
    private Timer timer;
    private AnchorPane a;
    private Easy e;
    TimerTask task = new TimerTask() {
        public void run() {
            Platform.runLater(() -> {
                addSun();
            });
        }
    };
    public Sunflower(AnchorPane ap, Easy e1, int x, int y) {
        e=e1;
        a=ap;
        lx=x;
        ly=y;
        timer=new Timer();
        timer.schedule(task, 5000l, 5000l);
        String imgAddress;
        File file;
        Image img;
        imgAddress = "C:\\Users\\20-pc\\IdeaProjects\\Game\\src\\sample\\asset\\SunFlower.gif";
        file = new File(imgAddress);
        try {
            img = new Image(file.toURI().toURL().toExternalForm());
            z=new ImageView(img);
            z.setX(lx);
            z.setY(ly);
            z.setScaleX(0.7);
            z.setScaleY(0.7);
            ap.getChildren().add(z);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void addSun(){
        new Sun(a,e,lx,ly);
    }
}
