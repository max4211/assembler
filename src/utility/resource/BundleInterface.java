package utility.resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public interface BundleInterface {

    static ResourceBundle createResourceBundle(String filename) throws IOException {
        return new PropertyResourceBundle(new FileInputStream(filename));
    }
}
