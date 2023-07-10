package sample;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;

public class Sun {
    private int lx;
    private int ly;
    private ImageView z;
    private Easy e;


    public Sun(AnchorPane ap, Easy e1, int x, int y) {
        e = e1;
        lx = x;
        ly = y;
        String imgAddress;
        File file;
        Image img;
        imgAddress = "C:\\Users\\20-pc\\IdeaProjects\\Game\\src\\sample\\asset\\sun.png";
        file = new File(imgAddress);
        try {
            img = new Image(file.toURI().toURL().toExternalForm());
            z = new ImageView(img);
            z.setX(lx);
            z.setY(ly);
            z.setScaleX(0.7);
            z.setScaleY(0.7);
            z.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    ap.getChildren().remove(z);
                    try {
                        e.incM(50);
                        //System.out.println("Sun Pressed");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    event.consume();
                }
            });
            ap.getChildren().add(z);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
