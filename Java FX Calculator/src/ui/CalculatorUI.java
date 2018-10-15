package ui;

import calculator.CalculatorController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Added an example of using the GridPane layout.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class CalculatorUI extends Application {
    public static final int NUM_COLS = 4;
    public static final int COL_WIDTH = 40;
    public static final int WIN_WIDTH = COL_WIDTH * 7;
    public static final int WIN_HEIGHT = COL_WIDTH * 7;
    private static final double BUTTON_WIDTH = 32;
    CalculatorController controller = new CalculatorController();

    @Override
    public void start(Stage stage) {

        Scene scene = getScene();
        scene.getStylesheets().add("styles/styles.css");

        stage.setTitle("Working in a grid");
        stage.setScene(scene);
        stage.show();
    }

    private Scene getScene() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setId("grid");

        //set some spacing
        grid.setHgap(10);
        grid.setVgap(10);

        //grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(10));

        //we can define the size of columns or rows
        ObservableList<ColumnConstraints> cols = grid.getColumnConstraints();

        for (int i = 1; i <= NUM_COLS; i++) {
            cols.add(new ColumnConstraints(COL_WIDTH));
        }

        TextArea total = new TextArea();
        total.setMaxHeight(BUTTON_WIDTH);

        Button[] buttons = {new Button("7"), new Button("8"), new Button("9"),
                new Button("+"), new Button("4"), new Button("5"), new Button("6"),
                new Button("-"), new Button("1"), new Button("2"), new Button("3"),
                new Button("*"), new Button("0"), new Button("Enter"), new Button("/"), new Button("C")};

        int counter = 0;

        for (int i = 0; i < buttons.length; i++) {

            int columns = i % NUM_COLS;
            int rows = i / NUM_COLS;

            String text = buttons[i].getText();
            buttons[i].setOnAction(event -> {
                controller.calcInput(text);
                total.setText(controller.showResult());
            });

            if (buttons[i].getText().equals("Enter")) {
                grid.add(buttons[i], columns, rows, 2, 1);
                buttons[i].setPrefWidth(COL_WIDTH * 2);
                counter++;
            } else {
                grid.add(buttons[i], columns + counter, rows);
                buttons[i].setPrefWidth(BUTTON_WIDTH);
            }
        }

        grid.add(total, 0, 5, NUM_COLS, 1);

        return new Scene(grid, WIN_WIDTH, WIN_HEIGHT);
    }
}