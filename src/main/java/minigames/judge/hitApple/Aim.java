package minigames.judge.hitApple;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Aim extends Pane implements Runnable {
    private static final int SPEED = 3;
    private static final double BASE_LAYOUTx = 450;
    private static final double BASE_LAYOUTy = 340;
    private static final double MAX_LAYOUTx = 700;
    private static final double MAX_LAYOUTy = 140;

    private boolean goHorizontal;
    private boolean goVertical;

    public Aim(){
        init();
    }

    private void init(){
        Rectangle rectangle = new Rectangle(25, 25);
        rectangle.setFill(new ImagePattern(new Image("/HitApple/Aim.png")));
        getChildren().add(rectangle);
        setLayoutX(BASE_LAYOUTx);
        setLayoutY(BASE_LAYOUTy);
        goHorizontal = true;
    }

    private void goHorizontal() throws InterruptedException {
        while(goHorizontal){
            while (getLayoutX() <= MAX_LAYOUTx && goHorizontal){
                setLayoutX(getLayoutX() + SPEED);
                Thread.sleep(10);
            }
            while (getLayoutX() >= BASE_LAYOUTx && goHorizontal){
                setLayoutX(getLayoutX() - SPEED);
                Thread.sleep(10);
            }
        }
    }



    private void goVertical() throws InterruptedException{
        while(goVertical){
            while (getLayoutY() >= MAX_LAYOUTy && goVertical){
                setLayoutY(getLayoutY() - SPEED);
                Thread.sleep(10);
            }
            while (getLayoutY() <= BASE_LAYOUTy && goVertical){
                setLayoutY(getLayoutY() + SPEED);
                Thread.sleep(10);
            }
        }
    }


    @Override
    public void run() {
            try {
                goHorizontal();
                goVertical = true;
                goVertical();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public boolean isGoHorizontal() {
        return goHorizontal;
    }

    public void setGoHorizontal(boolean goHorizontal) {
        this.goHorizontal = goHorizontal;
    }

    public void setGoVertical(boolean goVertical) {
        this.goVertical = goVertical;
    }

}
