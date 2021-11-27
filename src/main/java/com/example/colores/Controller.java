package com.example.colores;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Controller {
    private IntegerProperty redValue, greenValue, blueValue;
    private Label mezclado, redNumber, greenNumber, blueNumber;
    private Slider redSlider, greenSlider, blueSlider;

    public Controller(
            Label mezclado,
            Slider redSlider, Label redNumber,
            Slider greenSlider, Label greenNumber,
            Slider blueSlider, Label blueNumber) {
        this.mezclado=mezclado;

        this.redSlider=redSlider;
        this.redNumber=redNumber;

        this.greenSlider=greenSlider;
        this.greenNumber=greenNumber;

        this.blueSlider=blueSlider;
        this.blueNumber=blueNumber;

        redValue=new SimpleIntegerProperty();
        greenValue=new SimpleIntegerProperty();
        blueValue=new SimpleIntegerProperty();

        redNumber.textProperty().bind(redValue.asString());
        greenNumber.textProperty().bind(greenValue.asString());
        blueNumber.textProperty().bind(blueValue.asString());

        redValue.bind(redSlider.valueProperty());
        greenValue.bind(greenSlider.valueProperty());
        blueValue.bind(blueSlider.valueProperty());

        redValue.addListener((v, ov, nv)->cambioColor());
        greenValue.addListener((v, ov, nv)->cambioColor());
        blueValue.addListener((v, ov, nv)->cambioColor());
    }

    public void cambioColor() {
        mezclado.setBackground(new Background(new BackgroundFill
                (Color.rgb(redValue.get(), greenValue.get(), blueValue.get()), null, null)));
    }

}
