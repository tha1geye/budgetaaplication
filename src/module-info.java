module BudgetApplication {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lacray to javafx.fxml;
    exports com.lacray;
}