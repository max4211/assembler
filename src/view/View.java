package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View extends Application {

    private static final int SCREEN_WIDTH = 400;
    private static final int SCREEN_HEIGHT = 600;
    private static final String TITLE = "ECE 350 Assembler";
    private static final String STYLESHEETS = "stylesheet.css";

    @Override
    public void start(Stage stage) {
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
        root.setTop(createHeader());
    }

    private ImageView createHeader() {
        Image image = new Image("duke_ece.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(SCREEN_WIDTH);
        imageView.setPreserveRatio(true);
        return imageView;

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

        TextField inputField = new NumericField();
        gridPane.add(inputField, 0, 2);

        Label inputBaseLabel = new Label("Input Base");
        gridPane.add(inputBaseLabel, 1, 1);

        Label digitsLabel = new Label("Output digits");
        gridPane.add(digitsLabel, 0, 3);

        TextField digitsField = new NumericField();
        gridPane.add(digitsField, 0, 4);

        ComboBox inputBaseBox = new BaseBox();
        gridPane.add(inputBaseBox, 1, 2);

        Label outputValueLabel = new Label("Output Value");
        gridPane.add(outputValueLabel, 0, 5);

        TextField outputField = new TextField();
        gridPane.add(outputField, 0, 6);

        Label outputBaseLabel = new Label("Output Base");
        gridPane.add(outputBaseLabel, 1, 3);

        ComboBox outputBaseBox = new BaseBox();
        gridPane.add(outputBaseBox, 1, 4);

        Button convertButton = new ConvertButton(stage, digitsField, inputField, inputBaseBox, outputField, outputBaseBox);
        gridPane.add(convertButton, 0, 7);

        return gridPane;
    }

    private GridPane createAssemblerForm(Stage stage) {
        GridPane gridPane = createGridPane();

        Text title = new Text("Assembler");
        title.setFont(Font.font("Opera", FontWeight.NORMAL, 20));
        gridPane.add(title, 0, 0, 2, 1);

        Label outputOptions = new Label("Output options:");
        gridPane.add(outputOptions, 1, 1);

        Label digitsLabel = new Label("Enter desired digits:");
        gridPane.add(digitsLabel, 0, 1);

        TextField digitsField = new NumericField();
        gridPane.add(digitsField, 0, 2);

        ComboBox outputTypeBox = new FileBox();
        gridPane.add(outputTypeBox, 1, 2);

        ComboBox outputBaseBox = new BaseBox();
        gridPane.add(outputBaseBox, 2, 2);

        Label selectLabel = new Label("Select a to assemble file:");
        gridPane.add(selectLabel, 0, 3);

        Button fileChooser = new AssembleButton(stage, outputTypeBox, digitsField, outputBaseBox);
        gridPane.add(fileChooser, 1, 3);

        return gridPane;
    }

}
