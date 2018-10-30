package view;

import controller.NoteAppController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class ToDoNotes extends MenuUI {

    private Notes note = new Notes();
    public GridPane grid = new GridPane();
    private final int NUM_COLS = 4;
    private final int COL_WIDTH = 40;
    private final int ROW_INDEX = 0;
    private final int ROWSPAN = 1;
    private final int WIN_WIDTH = COL_WIDTH * 12;
    private final int WIN_HEIGHT = COL_WIDTH * 12;
    private final double BUTTON_WIDTH = 40;
    private final int BUTTON_PADDING = 10;
    private NoteAppController controller = new NoteAppController();

//    public void start(Stage stage) {
//        note.start(stage);
//        Scene scene = getScene();
//        scene.getStylesheets().add("styles/styles.css");
//        stage.setScene(scene);
//        stage.show();
//        stage.setTitle("To-Do List ");
//    }

    public void gridLayout() {
        note.gridLayout();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setGridLinesVisible(true);
        grid.setId("grid");
        grid.setHgap(BUTTON_PADDING);
        grid.setVgap(BUTTON_PADDING);
        grid.setPadding(new Insets(BUTTON_PADDING));
    }

    public Scene getScene(HBox defaultButtons) {

        VBox scene = new VBox(  );
        scene.getChildren().add( defaultButtons );

        gridLayout();

        TextField title = new TextField();
        title.setMaxHeight(BUTTON_WIDTH);
        title.setId("title");

        TextField todo = new TextField();
        todo.setMaxHeight(BUTTON_WIDTH);
        todo.setId("todo");

        Button post = new Button("Add");
        post.setMaxHeight(BUTTON_WIDTH);
        post.setId("post");

        final String[] names = new String[]{todo.getText()};
        final CheckBox[] cbs = new CheckBox[names.length];

        grid.add(title, 0, 0, NUM_COLS, ROWSPAN);

        grid.add(todo, 0, 1, NUM_COLS, ROWSPAN);

        grid.add(post, 0, 2, NUM_COLS, ROWSPAN);

        post.setOnAction(event -> {
            controller.handleNewNote("todo", title.getText(), todo.getText());

            for (int i = 0; i < names.length; i++) {
                int j = 3;
                final CheckBox cb = cbs[i] = new CheckBox(todo.getText());

                grid.add(cb, 0, j, NUM_COLS, ROWSPAN);
                j++;
            }
        });

        return new Scene(grid, WIN_WIDTH, WIN_HEIGHT);
    }
}