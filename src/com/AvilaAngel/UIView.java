package com.AvilaAngel;

/**
 * Created by Angel on 2/26/17.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UIView {


    public static void display(Stage primaryStage) {
        System.out.println("hola");

        Stage window;

        window = primaryStage;
        window.setTitle("AFD");

        Label alfabetoLbl = new Label("  Alfabeto (Σ):            ");
        Label estadosLbl  = new Label("  Estados (Q):            ");
        Label finalesLbl  = new Label("  Estados finales (F): ");

        TextField alfabetoTF = new TextField(",,");
        TextField estadosTF = new TextField(",,");
        TextField finalesTF = new TextField(",,");

        alfabetoTF.setPrefWidth(300);
        estadosTF.setPrefWidth(300);
        finalesTF.setPrefWidth(300);

        HBox alfabetoBox = new HBox(8);
        HBox estadosBox = new HBox(8);
        HBox finalesBox = new HBox(8);

        alfabetoBox.getChildren().addAll(alfabetoLbl, alfabetoTF);
        estadosBox.getChildren().addAll(estadosLbl, estadosTF);
        finalesBox.getChildren().addAll(finalesLbl, finalesTF);

        Button nextBtn = new Button("Siguiente");
        nextBtn.setOnAction(e -> {

        });

        VBox layout = new VBox(22);

        layout.getChildren().addAll(alfabetoBox, estadosBox, finalesBox, nextBtn);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 450, 220);
        //scene.getStylesheets().add("style.css");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

}
