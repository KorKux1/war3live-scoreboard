module com.war3live.scoreboard {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.war3live.scoreboard.views to javafx.fxml;
    opens com.war3live.scoreboard.controllers to javafx.fxml;
    opens com.war3live.scoreboard.model to javafx.fxml;

    opens com.war3live.scoreboard.main to javafx.graphics;
    exports com.war3live.scoreboard.controllers;

}