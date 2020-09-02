package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.text.IconView;

public class Menu {
    @FXML
    private ImageView game1;

    @FXML
    private AnchorPane root;
    @FXML
    private RadioButton easyRadio;

    @FXML
    private RadioButton realRadio;
    @FXML
    private ImageView game3;

    @FXML
    private ImageView game2;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    public static String graph;
    ToggleGroup tg = new ToggleGroup();

    @FXML
    void initialize()  {
        easyRadio.setToggleGroup(tg);
        realRadio.setToggleGroup(tg);
        game1.setImage(new Image("images/bek.png")); // или Shooter.png
        game2.setImage(new Image("images/bekF.png"));
        game3.setImage(new Image("images/no.png"));

        game1.setOpacity(0.7);
        game2.setOpacity(0.7);
        game3.setOpacity(0.7);

        game1.setOnMouseEntered(e -> {game1.setOpacity(1); game2.setOpacity(0.7); game3.setOpacity(0.7);});
        game2.setOnMouseEntered(e -> {game2.setOpacity(1); game1.setOpacity(0.7); game3.setOpacity(0.7);});
        game3.setOnMouseEntered(e -> {game3.setOpacity(1); game2.setOpacity(0.7); game1.setOpacity(0.7);});
        game1.setOnMouseClicked(event -> {
            if (tg.getSelectedToggle().equals(easyRadio)) graph = "";
            else graph="Real";

            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("fxml/Shoot.fxml"));
                stage.setTitle("Shooter");
                stage.setScene(new Scene(root, 300, 275));
                stage.setMaximized(true);
                stage.setResizable(false);
                stage.show();
            }catch (IOException e) {}
            root.getScene().getWindow().hide();
        });

        game2.setOnMouseClicked(event -> {
            if (tg.getSelectedToggle().equals(easyRadio)) graph = "";
            else graph="Real";

            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("fxml/Flyer.fxml"));
                stage.setTitle("Flyer");
                stage.setScene(new Scene(root, 300, 275));
                stage.setMaximized(true);
                stage.setResizable(false);
                stage.show();
            }catch (IOException e) {}
            root.getScene().getWindow().hide();
        });

        game3.setOnMouseClicked(event -> {
            if (tg.getSelectedToggle().equals(easyRadio)) graph = "";
            else graph="Real";

            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("fxml/Mover.fxml"));
                stage.setTitle("Mover");
                stage.setScene(new Scene(root, 300, 275));
                stage.setMaximized(true);
//                stage.setResizable(false);
                stage.show();
            }catch (IOException e) {}
            root.getScene().getWindow().hide();
        });
    }
}





///////////
//Parent root = FXMLLoader.load(getClass().getResource("fxml/Shooter.fxml"));
//        primaryStage.setTitle("Shooter");
//                primaryStage.setScene(new Scene(root, 300, 275));
//                primaryStage.setMaximized(true);
//                primaryStage.setResizable(false);
//                primaryStage.show();
//                }