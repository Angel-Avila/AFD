package com.AvilaAngel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by Angel on 2/26/17.
 */
public class UIDynamicTableView {

    private static final double HEIGHT = 600;
    private static final double WIDTH = 450;

    public static void display(List<String> alfabeto,
                               List<String> estados, List<String> finales) {

        // MARK: - Calc

        int alfabetoCount = alfabeto.size();
        int estadosCount = estados.size() + 1;

        TextField[][] transicionesTF = new TextField[estadosCount][alfabetoCount];
        HBox[] transicionesRows = new HBox[estadosCount];

        transicionesRows[0] = new HBox(41);
        transicionesRows[0].getChildren().add(new Label("  "));

        // add words on top

        for (String word: alfabeto) {
            transicionesRows[0].getChildren().add(new Label(" " + word));
        }

        // add all state lbls and all tfs

        for (int i = 1; i < estadosCount; i++) {

            Label label = new Label(estados.get(i - 1));
            transicionesRows[i] = new HBox(8);
            HBox hbox = transicionesRows[i];
            hbox.getChildren().add(label);

            for (int j = 0; j < alfabetoCount; j++) {

                transicionesTF[i - 1][j] = new TextField();

                TextField tf = transicionesTF[i - 1][j];

                tf.setPrefWidth(45);

                hbox.getChildren().add(tf);

            }
        }

        // MARK: - UI

        Stage window = new Stage();

        window.setTitle("Tabla de Transiciones");

        // Init, config

        VBox vb = new VBox(10);

        VBox box = new VBox(10);

        Scene scene = new Scene(box, WIDTH, HEIGHT);

        ScrollPane sp = new ScrollPane();

        box.getChildren().addAll(sp);
        box.setVgrow(sp, Priority.ALWAYS);

        sp.setContent(vb);

        // add stuff

        for (int i = 0; i < estadosCount; i++) {
            vb.getChildren().add(transicionesRows[i]);
        }

        // button

        Button nextBtn = new Button("Siguiente");

        nextBtn.setOnAction(e -> {

            String[][] transiciones = new String[estadosCount][alfabetoCount];

            for (int i = 0; i < estadosCount - 1; i++)
                for (int j = 0; j < alfabetoCount; j++)
                    transiciones[i][j] = transicionesTF[i][j].getText();

            UIWordView.display(alfabeto, estados, finales, transiciones);

        });

        HBox btnLayout = new HBox(22);

        btnLayout.getChildren().addAll(new Label(""), nextBtn);

        vb.getChildren().add(btnLayout);

        // window last config

        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

}
