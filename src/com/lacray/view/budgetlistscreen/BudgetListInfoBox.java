package com.lacray.view.budgetlistscreen;

import com.lacray.model.Budget;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class BudgetListInfoBox extends HBox {
    //  strings
    private final String TITLE_TEXT = "Title";
    private final String MONTH_TEXT = "Month";
    private final String YEAR_TEXT = "Year";

    //  components

    //  UI
    private HBox infoRow;
    private InfoField titleField;
    private InfoField monthField;
    private InfoField yearField;

    public BudgetListInfoBox(){
        super();
        configureSuper();
        createComponents();
        createChildren();
        setLayout();
    }

    private void configureSuper(){
        super.setSpacing(100.0);
        super.setPadding(new Insets(20.0));
    }

    private void createComponents(){

    }

    private void createChildren(){
        createInfoRow();
    }

    private void createInfoRow(){
        infoRow = new HBox();
        titleField = new InfoField(TITLE_TEXT);
        monthField = new InfoField(MONTH_TEXT);
        yearField = new InfoField(YEAR_TEXT);

        addInfoRowChildren();
    }

    private void addInfoRowChildren(){
        infoRow.getChildren().addAll(titleField, monthField, yearField);
    }

    private void setLayout(){
        super.getChildren().addAll(infoRow);
    }

    private void updateSelectedBudget(Budget budget){
        titleField.setFieldValue(budget.getTitle());
        monthField.setFieldValue(Integer.toString(budget.getMonth()));
        yearField.setFieldValue(Integer.toString(budget.getYear()));
    }

    protected void update(Budget budget){
        updateSelectedBudget(budget);
    }
}
