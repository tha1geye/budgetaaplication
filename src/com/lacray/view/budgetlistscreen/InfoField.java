package com.lacray.view.budgetlistscreen;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InfoField extends VBox {
    //  strings
    //  components
    //  UI
    private Label fieldLabel;
    private Text fieldValue;

    public InfoField(String label){
        super();
        configureSuper();
        fieldLabel = new Label(label);
        fieldValue = new Text();

        super.getChildren().addAll(fieldLabel, fieldValue);
    }

    private void configureSuper(){
        super.setPadding(new Insets(0, 20, 0, 20));
    }

    public void setFieldValue(String value){
        fieldValue.setText(value);
    }

    public void clearFieldValue(){
        fieldValue.setText("");
    }
}
