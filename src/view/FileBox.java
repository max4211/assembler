package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class FileBox extends ComboBox {

    public FileBox() {
        super();
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Logism",
                        "Mif",
                        "Text"
                );
        this.setValue("File Type");
        this.setItems(options);
    }
}
