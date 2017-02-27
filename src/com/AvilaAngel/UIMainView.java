package com.AvilaAngel;

/**
 * Created by Angel on 2/26/17.
 */

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UIMainView {

    public static void display(Stage primaryStage) {
        Stage window;

        window = primaryStage;
        window.setTitle("AFD");

        Label alfabetoLbl = new Label("  Alfabeto (Σ):            ");
        Label estadosLbl  = new Label("  Estados (Q):            ");
        Label finalesLbl  = new Label("  Estados finales (F): ");

        TextField alfabetoTF = new TextField("a,b,c,d,e");
        TextField estadosTF = new TextField("0,1,2,3,4,5,6,7,8,9,10,11,12,13");
        TextField finalesTF = new TextField("0,1");

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

            List<String> alfabeto = Arrays.asList(alfabetoTF.getText().split(","));
            List<String> estados  = Arrays.asList(estadosTF.getText().split(","));
            List<String> finales  = Arrays.asList(finalesTF.getText().split(","));

            UIDynamicTableView.display(alfabeto, estados, finales);

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
