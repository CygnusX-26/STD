module school.tower.defense {
    requires javafx.controls;
    requires javafx.fxml;

    opens school.tower.defense to javafx.fxml;
    exports school.tower.defense;
}
