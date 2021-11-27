package com.example.colores;

import javafx.beans.value.ObservableNumberValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Vista extends VBox {

    private Label mezclado, redText, greenText, blueText, redNumber, greenNumber, blueNumber;
    private HBox redBox, greenBox, blueBox;
    private Slider redSlider, greenSlider, blueSlider;
    private Controller controlador;

    public Vista() {
        initVista();
    }

    public void initVista() {
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(180, 100);
        this.setMinSize(180, 100);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        mezclado = new Label("");

        redText = new Label("R");
        redText.setMinWidth(10);

        greenText = new Label("G");
        greenText.setMinWidth(10);

        blueText = new Label("B");
        blueText.setMinWidth(10);

        redNumber = new Label("");
        redNumber.setMinWidth(20);

        greenNumber = new Label("");
        greenNumber.setMinWidth(20);

        blueNumber = new Label("");
        blueNumber.setMinWidth(20);

        redSlider = new Slider(0, 255, 128);
        greenSlider = new Slider(0, 255, 128);
        blueSlider = new Slider(0, 255, 128);

        redBox = new HBox(redText, redSlider, redNumber);
        redBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        greenBox = new HBox(greenText, greenSlider, greenNumber);
        greenBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        blueBox = new HBox(blueText, blueSlider, blueNumber);
        blueBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        mezclado.prefWidthProperty().bind(this.widthProperty());
        mezclado.prefHeightProperty().bind(this.heightProperty().subtract(redBox.getHeight()).multiply(3));
        redSlider.prefWidthProperty().bind(
                this.widthProperty().subtract(redNumber.getWidth()).subtract(redText.getWidth()));
        greenSlider.prefWidthProperty().bind(
                this.widthProperty().subtract(greenNumber.getWidth()).subtract(greenText.getWidth()));
        blueSlider.prefWidthProperty().bind(
                this.widthProperty().subtract(blueNumber.getWidth()).subtract(blueText.getWidth()));

        this.getChildren().add(mezclado);
        this.getChildren().add(redBox);
        this.getChildren().add(greenBox);
        this.getChildren().add(blueBox);

        controlador = new Controller(
                mezclado,
                redSlider, redNumber,
                greenSlider, greenNumber,
                blueSlider, blueNumber);
    }
}