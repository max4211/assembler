package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utility.converter.Converter;

public class ConvertButton extends Button {

    public ConvertButton(Stage stage,
                           TextField digitsField,
                           TextField inputField, ComboBox inputBaseBox,
                           TextField outputField, ComboBox outputBaseBox) {
        super("Convert");
        this.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        String inputValue = inputField.getText();
                        String inputBase = (String) inputBaseBox.getValue();
                        String outputBase = (String) outputBaseBox.getValue();
                        String digits = digitsField.getText();
                        Converter c = new Converter(inputValue, inputBase, outputBase);
                        if (!digits.equals(""))
                            c = new Converter(inputValue, inputBase, outputBase, digits);
                        String outputValue = c.execute();
                        outputField.setText(outputValue);
                    }
                }
        );
    }
}
