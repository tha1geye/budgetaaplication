package com.lacray.view;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class HeaderBox extends HBox {

    public HeaderBox(){
        super();
        Text headerText = new Text("Budgets");
        super.getChildren().add(headerText);
    }
}
