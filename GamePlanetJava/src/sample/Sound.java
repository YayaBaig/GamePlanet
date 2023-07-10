package sample;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.nio.file.Paths;

public class Sound {
    public Sound (int a)  {
        Media m=new Media(Paths.get("asset/1.wav").toUri().toString());
        MediaPlayer soundMyNoise = new MediaPlayer(m);
        soundMyNoise.play();
    }
}
