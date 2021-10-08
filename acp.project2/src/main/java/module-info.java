module cel19.acp.project2 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens cel19.acp.project2 to javafx.fxml;
    exports cel19.acp.project2;
}
