package calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.CalculatorModel;

import java.text.DecimalFormat;

public class CalculatorController {


    private CalculatorModel model = new CalculatorModel();

    public void calcInput(String input) {
        model.calcInput(input);
    }

    public String showResult() {
        return model.showResult();
    }
}