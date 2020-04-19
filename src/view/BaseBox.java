package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class BaseBox extends ComboBox {

    public BaseBox() {
        super();
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "HEX",
                        "BIN",
                        "DEC"
                );
        this.setValue("Base");
        this.setItems(options);
    }
}
