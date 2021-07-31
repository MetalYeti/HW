package JAVA2.HW4.app;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextArea textField;
    @FXML
    private TextField inputText;

    @FXML
    protected void onButtonClick() {
        textField.appendText(inputText.getText() + "\n");
        inputText.clear();
        inputText.requestFocus();
    }
}