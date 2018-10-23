package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NotesUI extends Application {

    private GridPane grid = new GridPane();
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int COLSPAN = 2;
    private static final int NUM_COLS = 4;
    private static final int COL_WIDTH = 40;
    private static final int ROW_INDEX = 0;
    private static final int ROWSPAN = 1;
    private static final int WIN_WIDTH = COL_WIDTH * 7;
    private static final int WIN_HEIGHT = COL_WIDTH * 7;
    private static final double BUTTON_WIDTH = 40;
    private static final int BUTTON_PADDING = 10;
    int columns = 1 % NUM_COLS;
    int rows = 1 / NUM_COLS;

    /**
     * starts the stage, sets title, adds stylesheet
     *
     * @param stage sets the title of the program and displays the scene
     */
    public void start(Stage stage) {
        Scene scene = getScene();
        scene.getStylesheets().add("styles/styles.css");
        stage.setTitle("Note App");
        stage.setScene(scene);
        stage.show();
    }

    private void gridLayout() {
        grid.setAlignment(Pos.CENTER);
        grid.setId("grid");
        grid.setHgap(BUTTON_PADDING);
        grid.setVgap(BUTTON_PADDING);
        grid.setPadding(new Insets(BUTTON_PADDING));
    }

    private Scene getScene() {
        gridLayout();
        ObservableList<ColumnConstraints> cols = grid.getColumnConstraints();
        for (int i = 1; i <= NUM_COLS; i++) {
            cols.add(new ColumnConstraints(COL_WIDTH));
        }
        TextArea quote = new TextArea();
        quote.setMaxHeight(BUTTON_WIDTH);

        Button post = new Button("Post");
        post.setMaxHeight(BUTTON_WIDTH);

        grid.add(post, 4, ROW_INDEX, NUM_COLS, ROWSPAN);

        grid.add(quote, 0, ROW_INDEX, NUM_COLS, ROWSPAN);
        return new Scene(grid, WIN_WIDTH, WIN_HEIGHT);

    }
}