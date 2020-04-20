package view;

import javafx.scene.control.Alert;

import java.io.File;

public class SaveDialog extends Alert {

    private static final String ALERT_TITLE = "Save Confirmation";

    public SaveDialog(File file) {
        super(AlertType.INFORMATION);
        this.setTitle(ALERT_TITLE);
        this.setContentText(createContentText(file.getAbsolutePath()));
        this.showAndWait();
    }

    private String createContentText(String path) {
        return String.format("Successfully wrote file to path:\n%s", path);
    }
}
