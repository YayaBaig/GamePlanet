package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Easy {
    public ImageView sf;
    public ImageView p;
    public Label moneyLabel;
    public AnchorPane ap;
    public Label startL;
    public Label scoreBoard;

    private int time;
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private Random rn;
    private static int start;
    private int pause;
    private Timer timer;
    private Money mn;
    private int sunNum;
    private int peaNum;
    private int score;
    public Easy() {
        score=0;
        time = 0;
        rn = new Random();
        start = 0;
        pause = 1;
        timer = new Timer();
        timer.schedule(task, 100l, 100l);
        mn = new Money(25);
        sunNum = 0;
        peaNum = 0;
    }

    public void startOrPause(MouseEvent mouseEvent) throws Exception {
        if (pause == 1) {
            startL.setText("Pause");
            start = 1;
            pause = 0;
        } else {
            startL.setText("Start");
            start = 0;
            pause = 1;
        }
    }

    TimerTask task = new TimerTask() {
        public void run() {
            Platform.runLater(() -> {
                time += 1;
                try {
                    gamePlay();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });
        }
    };

    public void gamePlay() throws Exception {
        if (start == 1) {
            if (time % 40 == 0)
                mn.increaseMoney(25, sf, p, moneyLabel);
            if (time % 30 == 0) {
                int k = rn.nextInt(4) * 10 + 20;
                if (time % k == 0 && time > 35) {
                    addZombie();
                    //System.out.println(time);
                }
            }
            moveZombies();
            moveBullets();
            checkHits();
        }
    }

    public void checkHits() {
        for (Bullet b : bullets)
            for (Zombie z : zombies) {
                double diffX=z.getX() - b.getX();
                double diffY=Math.abs(b.getY() - z.getY()-35);
                //System.out.println(z.getY());
                if ((diffX<=-7)  &&  (diffY <=2)) {
                    b.remove();
                    bullets.remove(b);
                    z.decLife();
                    break;
                }
            }
    }

    void addZombie() {
        int a = rn.nextInt(2);
        //System.out.println(a);
        Zombie z = new Zombie(ap,this,590, a * 70 + 25);
        zombies.add(z);
    }

    void moveZombies() {
        for (Zombie a : zombies) {
            a.move();
        }
    }

    public static void setStart(int a) {
        start = a;
    }

    public void addSF(MouseEvent mouseEvent) throws Exception {
        if (mn.getMn() >= 50) {
            mn.decreaseMoney(50, sf, p, moneyLabel);
            Sunflower sf = new Sunflower(ap, this, ((sunNum + peaNum) / 2) * 50 + 20, ((sunNum + peaNum) % 2) * 60 + 50);
            sunNum++;
        }
    }

    public void addPea(MouseEvent mouseEvent) throws Exception {
        if (mn.getMn() >= 100) {
            mn.decreaseMoney(100, sf, p, moneyLabel);
            Pea sf = new Pea(ap, this, ((sunNum + peaNum) / 2) * 50 + 20, ((sunNum + peaNum) % 2) * 70 + 50);
            peaNum++;
        }
    }

    public void incM(int amt) throws Exception {
        mn.increaseMoney(amt, sf, p, moneyLabel);
    }

    public void addBullet(Bullet b) {
        bullets.add(b);

    }

   public void moveBullets() {
        for (Bullet a : bullets) {
            a.move();
        }
    }
    public void remZ(Zombie z){
        for(Zombie z1:zombies){
            if(z.equals(z1))
                zombies.remove(z1);
        }
    }
    public void remB(Bullet b){
        for(Bullet b1:bullets){
            if(b.equals(b1)) {
                bullets.remove(b1);
                //System.out.println("bullet removed");
            }
        }
    }
    public void incScore(){
        score+=10;
        System.out.println(score);
        scoreBoard.setText(""+score);
    }
}
