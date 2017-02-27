package com.AvilaAngel;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Angel on 2/26/17.
 */
public class UIWordView {

    public static void display(String estadoInicial, List<String> finales, HashMap<String, String> transiciones) {

        // MARK: - UI

        Stage window = new Stage();
        window.setTitle("Título útil");

        VBox vb = new VBox(10);
        vb.setAlignment(Pos.CENTER);

        Label wordLbl = new Label("Cadena (w): ");

        TextField wordTF = new TextField();

        HBox wordHB = new HBox(8);
        wordHB.setAlignment(Pos.CENTER);
        wordHB.getChildren().addAll(wordLbl, wordTF);

        Label resultadoLbl = new Label("Aquí irá el resultado!");

        Button resolverBtn = new Button("Resolver");

        vb.getChildren().addAll(wordHB, resultadoLbl, resolverBtn);

        Scene scene = new Scene(vb, 300, 120);

        // MARK: - Button action and problem resolution

        resolverBtn.setOnAction(e -> {

            String word = wordTF.getText();
            String currentState = estadoInicial;

            // Resolver

            for (int i = 0; i < word.length(); i++)
                currentState = transiciones.get(word.substring(i, i + 1) + "&" + currentState);

            if(!finales.contains(currentState))
                resultadoLbl.setText("Rechazada");
            else
                resultadoLbl.setText("Aceptada");
        });

        // MARK: - Window

        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

}