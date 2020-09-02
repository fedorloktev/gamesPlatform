package sample;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.text.AttributedCharacterIterator;


import com.sun.javafx.geom.Area;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;

public class Flyer {
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView back;

    double cloud1UpX = 0;
    double cloud1UpY = 0;
    double cloud1DownX = 0;
    double cloud1DownY = 0;

    double cloud2UpX = 0;
    double cloud2UpY = 0;
    double cloud2DownX = 0;
    double cloud2DownY = 0;

    double planerUpX = 0;
    double planerDownX = 0;
    double planerUpY = 0;
    double planerDownY = 0;
    boolean isWork = true;
    @FXML
    void initialize() {
                new Cloud();
                new Planer();


        try {
            root.setCursor(Cursor.NONE);
            back.setImage(new Image("images/Flyer" + new Menu().graph + "/back.gif"));
            back.setFitWidth(1500);

//            // -------------- выбор способа управления
//            root.setOnMouseMoved(event -> { // управление планером движением курсора
//                if (MouseInfo.getPointerInfo().getLocation().x >= 0 && MouseInfo.getPointerInfo().getLocation().x <= 1080 &&
//                        MouseInfo.getPointerInfo().getLocation().y >= 0 && MouseInfo.getPointerInfo().getLocation().y <= 650) {
//                    planer.setX(MouseInfo.getPointerInfo().getLocation().x);
//                } else {
//                }
//            });

//            root.setOnMouseClicked(event -> { // управление планером нажатием ЛКМ ПКМ (не зависает в отличие от курсора)
//                if (event.getButton() == MouseButton.PRIMARY) {
//                    planerX = planer.getX();
//                    if (planerX == 0) {
//                    } else {
//                        planer.setX(planerX - 50);
//                    }
//                } else if (event.getButton() == MouseButton.SECONDARY) {
//                    planerX = planer.getX();
//                    if (planerX >= 1053) {
//                    } else {
//                        planer.setX(planerX + 50);
//                    }
//                }
//            });
        }catch (NullPointerException e) {
            System.out.println("Ошибка в шапке");
        }
        // -------------- выбор способа управления (END)
       }

    class Cloud extends Thread {
            Cloud() {
            start();
        }
            public void run () {

            for (; ; ) {
                ImageView img = new ImageView("images/Flyer" + new Menu().graph + "/cloud.png");
                ImageView img2 = new ImageView("images/Flyer" + new Menu().graph + "/cloud.png");

                int maxX = 1050;
                double rand = (Math.random() * ++maxX) + 1; // ограничение на появление тучи за пределами фона
                int random = (int) rand;

                double rand2 = (Math.random() * ++maxX) + 1; // ограничение на появление тучи за пределами фона
                int random2 = (int) rand2;
                img2.setX(random2);

                img.setX(random);
                cloud1UpX = random;
                cloud1DownX = random+200;

                cloud2UpX = random2;
                cloud2DownX = random2+200;


                int max = 30;
                double randY = (Math.random() * ++max) + 10; // ограничение случайной скорости тучи
                int randomY = (int) randY;

                int maxS = 20;
                double randY2 = (Math.random() * ++maxS) + 3; // ограничение случайной скорости тучи
                int randomY2 = (int) randY2;
                img.setY(-20);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        root.getChildren().addAll(img, img2);
                    }
                });
                for (; ; ) {

        img.setY(img.getY() + 10);
        img2.setY(img2.getY() + randomY2);
        cloud1UpY=img.getY();
        cloud1DownY=img.getY()+150;

                    cloud2UpY=img2.getY();
                    cloud2DownY=img2.getY()+150;
        try {
            Thread.sleep(randomY);
        } catch (InterruptedException e) {
            System.out.println("Ошибка в паузе");
        }
        if (img.getY() >= 700 && img2.getY()>=700 ) {
//            img.setY(-20);

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    root.getChildren().removeAll(img, img2);
                }
            });
            break;
        }
    }


            if (isWork==false) { break; }
            }
        }
            }

class Planer extends Thread {
    Planer() {start();}
        public void run() {
            ImageView planer = new ImageView("images/Flyer"+new Menu().graph+"/planer.png");
            planer.setX(550);
            planer.setY(400);


            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    root.getChildren().add(planer);
                }
            });

            // -------------- выбор способа управления
            root.setOnMouseMoved(event -> { // управление планером движением курсора
                if (MouseInfo.getPointerInfo().getLocation().x >= 0 && MouseInfo.getPointerInfo().getLocation().x <= 1080) {
//                        &&MouseInfo.getPointerInfo().getLocation().y >= 0 && MouseInfo.getPointerInfo().getLocation().y <= 650) {
                    planer.setX(MouseInfo.getPointerInfo().getLocation().x);
                    planerUpX = planer.getX();
                    planerDownX = planer.getX()+300;
                    planerUpY = 400;
                    planerDownY = 400+265;

//                    Rectangle prCloud = new Rectangle();
//                    prCloud.x=(int)cloud1UpX;
//                    prCloud.y=(int)cloud1UpY;
//                    prCloud.height=150;
//                    prCloud.width=200;

                    javafx.scene.shape.Rectangle prCloud = new javafx.scene.shape.Rectangle();
                    prCloud.setX(cloud1UpX);
                    prCloud.setY(cloud1UpY);
                    prCloud.setWidth(200-30);
                    prCloud.setHeight(150-30);

                    javafx.scene.shape.Rectangle prCloud2 = new javafx.scene.shape.Rectangle();
                    prCloud2.setX(cloud2UpX);
                    prCloud2.setY(cloud2UpY);
                    prCloud2.setWidth(200-30);
                    prCloud2.setHeight(150-30);

                    javafx.scene.shape.Rectangle prPlan = new javafx.scene.shape.Rectangle();
                    prPlan.setX(planer.getX());
                    prPlan.setY(400);
                    prPlan.setWidth(300);
                    prPlan.setHeight(265);

                    javafx.scene.shape.Shape shape = javafx.scene.shape.Shape.intersect(prCloud,prPlan);
                    javafx.scene.shape.Shape shape2 = javafx.scene.shape.Shape.intersect(prCloud2,prPlan);

                    String shapeTrue = "MoveTo";
                    String shapeString = shape.toString();
                    String shape2String = shape2.toString();

                    if(shapeString.contains(shapeTrue) || shape2String.contains(shapeTrue) ) {
                        JOptionPane.showMessageDialog(null,"Вы столкнулись со встречным облаком!");
                        Stage stage = new Stage();
                        Parent root2 = null;
                        try {
                            root2 = FXMLLoader.load(getClass().getResource("fxml/Menu.fxml"));
                        } catch (IOException e) { }
                        stage.setTitle("Menu");
                        stage.setScene(new Scene(root2, 590, 385));
                        stage.setResizable(false);
                        stage.show();
                        root.getScene().getWindow().hide();
                        isWork = false;
                    } else {

                    }
                } else { }
        });


}

}

}
