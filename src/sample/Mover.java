package sample;


import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyListener;
import java.lang.management.PlatformLoggingMXBean;
import java.net.URL;
import java.util.ConcurrentModificationException;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import javax.swing.*;

public class Mover  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane root;

    @FXML
    ImageView point;
    @FXML
    ImageView back;

    @FXML
    void initialize()  {
            back();
            new Man();

        root.setOnMouseClicked(event -> {
            System.out.println(MouseInfo.getPointerInfo().getLocation().getX() + " y: "+MouseInfo.getPointerInfo().getLocation().getY());
        });
    }

    void back() {
        back.setImage(new Image("images/Mover" + new Menu().graph + "/back.png"));
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setX(-304);
        rectangle1.setY(-256);
        rectangle1.setHeight(39);
        rectangle1.setWidth(33);
        rectangle1.setFill(Color.RED);


        Line line1 = new Line();
        line1.setStartX(50);
        line1.setStartY(50);
        line1.setEndX(300);
        line1.setEndY(200);
        line1.setLayoutY(10);
        root.getChildren().add(line1);

        Rectangle man = new Rectangle();
        man.setX(point.getX());
        man.setY(point.getY());
        man.setWidth(17);
        man.setHeight(18);

        Shape shape = Shape.intersect(man, rectangle1);
        String shapeTrue = "MoveTo";
        String shapeString = shape.toString();
        if(shapeString.contains(shapeTrue)) {
            JOptionPane.showMessageDialog(null, "Вы столкнулись со встречным облаком!");
        }
    }

//    class Back implements Runnable {
//        public void run() {
//
//
//        }
//    }
    class Man extends Thread{ // поток тела
        Man() {start();}
        public void run() {
            point.setOnKeyPressed(event -> { // движение тела
                switch (event.getCode()) {
                    case RIGHT: {
                        point.setX(point.getX() + 8);
                        break;
                    }
                    case LEFT: {
                        point.setX(point.getX() - 8);
                        break;
                    }
                    case UP: {
                                point.setY(point.getY() - 8);
                                break;
                    }

                    case DOWN: {
                        point.setY(point.getY() + 8);
                        break;
                    }

                    case SPACE:{
                        System.out.println(point.getX()+ "y: "+point.getY());
                        break;
                    }
                }

            });


        }
    }

}



