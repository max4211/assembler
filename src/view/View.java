package view;

import ISA.ISA;
import data.xmlreader.XMLReader;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.assembler.Assembler;
import utility.converter.Converter;
import utility.io.Input;
import utility.io.Output;

import java.io.*;

public class View extends Application {

    private static final int SCREEN_WIDTH = 400;
    private static final int SCREEN_HEIGHT = 600;
    private static final String TITLE = "ECE 350 Assembler";
    private static final String STYLESHEETS = "stylesheet.css";

    @Override
    public void start(Stage stage) throws Exception {
        Scene myScene = setupGame(stage);
        myScene.getStylesheets().add(STYLESHEETS);
        stage.setScene(myScene);
        stage.setTitle(TITLE);
        stage.show();
    }

    private Scene setupGame(Stage stage) {
        BorderPane root = new BorderPane();
        initializeRoot(root, stage);
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        return scene;
    }

    private void initializeRoot(BorderPane root, Stage stage) {
        VBox box = new VBox();
        box.getChildren().add(createAssemblerForm(stage));
        box.getChildren().add(createConverterForm(stage));
        root.setCenter(box);
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        return gridPane;
    }

    private Node createConverterForm(Stage stage) {
        GridPane gridPane = createGridPane();

        Text title = new Text("Converter");
        title.setFont(Font.font("Opera", FontWeight.NORMAL, 20));
        gridPane.add(title, 0, 0, 2, 1);

        Label inputValueLabel = new Label("Input Value");
        gridPane.add(inputValueLabel, 0, 1);

        TextField inputField = new TextField();
        gridPane.add(inputField, 0, 2);

        Label inputBaseLabel = new Label("Input Base");
        gridPane.add(inputBaseLabel, 1, 1);

        ComboBox inputBaseBox = createBaseBox();
        gridPane.add(inputBaseBox, 1, 2);

        Label outputValueLabel = new Label("Output Value");
        gridPane.add(outputValueLabel, 0, 3);

        TextField outputField = new TextField();
        gridPane.add(outputField, 0, 4);

        Label outputBaseLabel = new Label("Output Base");
        gridPane.add(outputBaseLabel, 1, 3);

        ComboBox outputBaseBox = createBaseBox();
        gridPane.add(outputBaseBox, 1, 4);

        Button convertButton = createConvertButton(stage, inputField, inputBaseBox, outputField, outputBaseBox);
        gridPane.add(convertButton, 0, 7);

        return gridPane;
    }

    private Button createConvertButton(Stage stage,
                                       TextField inputField, ComboBox inputBaseBox,
                                       TextField outputField, ComboBox outputBaseBox) {
        Button btn = new Button("Convert");
        btn.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        String inputValue = inputField.getText();
                        String inputBase = (String) inputBaseBox.getValue();
                        String outputBase = (String) outputBaseBox.getValue();
                        Converter c = new Converter(inputValue, inputBase, outputBase);
                        String outputValue = c.execute();
                        outputField.setText(outputValue);
                    }
                }
        );
        return btn;
    }

    private GridPane createAssemblerForm(Stage stage) {
        GridPane gridPane = createGridPane();

        Text title = new Text("Assembler");
        title.setFont(Font.font("Opera", FontWeight.NORMAL, 20));
        gridPane.add(title, 0, 0, 2, 1);

        Label selectLabel = new Label("Select a file:");
        gridPane.add(selectLabel, 0, 1);

        Label outputOptions = new Label("Select output options:");
        gridPane.add(outputOptions, 0, 2);

        TextField digitsField = new TextField("Digits");
        gridPane.add(digitsField, 0, 2);

        ComboBox outputTypeBox = createFiletypeBox();
        gridPane.add(outputTypeBox, 1, 2);

        ComboBox outputBaseBox = createBaseBox();
        gridPane.add(outputBaseBox, 2, 2);

        Button fileChooser = createAssembleButton(stage, outputTypeBox, digitsField, outputBaseBox);
        gridPane.add(fileChooser, 0, 3);

        return gridPane;
    }

    private Button createAssembleButton(Stage stage,
                                        ComboBox outputType,
                                        TextField digits, ComboBox outputBase) {
        Button btn = new Button("Assemble");
        FileChooser fc = new FileChooser();
        fc.setTitle("Select file to assemble");
        fc.setInitialDirectory(new File(System.getProperty("user.dir") + "/data/test/"));
        btn.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e)  {
                        try {
                            String ISAfile = "src/data/MIPS/ece350ISA.xml";
                            String outputPath = "data/test/viewtest";
                            File inputFile = fc.showOpenDialog(stage);

                            // MODEL CODE TO GET TO OUTPUT
                            XMLReader reader = new XMLReader(ISAfile);
                            ISA myISA = reader.getISA();
                            Assembler myAssembler = new Assembler(myISA);
                            Input input = new Input(inputFile);

                            // FINAL OUTPUT CONSTRUCTION AND WRITE
                            Output output = myAssembler.assemble(input);
                            output.write((String) outputType.getValue(), (String) outputBase.getValue(), digits.getText(), outputPath);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                }
        );
        return btn;
    }

    private ComboBox createBaseBox() {
        ComboBox box = new ComboBox();
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "HEX",
                        "BIN",
                        "DEC"
                );
        box.setValue("Base");
        box.setItems(options);
        return box;
    }

    private ComboBox createFiletypeBox() {
        ComboBox box = new ComboBox();
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Logism",
                        "Mif",
                        "Text"
                );
        box.setValue("File Type");
        box.setItems(options);
        return box;
    }

}
