module school.tower.defense {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens school.tower.defense to javafx.fxml;
    exports school.tower.defense;
}
