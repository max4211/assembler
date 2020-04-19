package view;

import ISA.ISA;
import data.xmlreader.XMLReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.assembler.Assembler;
import utility.io.Input;
import utility.io.Output;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class AssembleButton extends Button {

    public AssembleButton (Stage stage,
                                        ComboBox outputType,
                                        TextField digits, ComboBox outputBase) {
        super("Assemble");
        FileChooser fc = new FileChooser();
        fc.setTitle("Select file to assemble");
        fc.setInitialDirectory(new File(System.getProperty("user.dir") + "/data/test/"));
        this.setOnAction(
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
                            List<String> text = output.write((String) outputType.getValue(), (String) outputBase.getValue());
                            if (!digits.getText().equals(""))
                                text = output.write((String) outputType.getValue(), (String) outputBase.getValue(), digits.getText());
                            FileChooser fc = new FileChooser();
                            FileChooser.ExtensionFilter exFilter = createExtensionFilters((String) outputType.getValue());
                            fc.getExtensionFilters().add(exFilter);
                            File file = fc.showSaveDialog(stage);
                            if (file != null)
                                saveTextToFile(text, file);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    private void saveTextToFile(List<String> text, File file) {
                        try {
                            PrintWriter writer = new PrintWriter(file);
                            for (String s: text)
                                writer.println(s);
                            writer.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    private FileChooser.ExtensionFilter createExtensionFilters(String value) {
                        if (value.equals("Logism"))
                            return new FileChooser.ExtensionFilter("LOGISM files (*lgsim)", "*.lgsim");
                        else if (value.equals("Mif"))
                            return new FileChooser.ExtensionFilter("MIF files (*mif)", "*.mif");
                        else
                            return new FileChooser.ExtensionFilter("TXT files (*txt)", "*.txt");
                    }
                }
        );
    }
}
