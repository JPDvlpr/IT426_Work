package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static javafx.geometry.Pos.BOTTOM_RIGHT;


public class MenuUI extends Application
{
    
    private static final int NUM_COLS = 10;
    private static final int INT1 = 15;
    private static final int INT2 = 15;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    
    private static final double BUTTON_WIDTH = 20;
    private static final int COL_WIDTH = 45;
    private static final int TOP_RIGHT_BOTTOM_LEFT = 50;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private Label label;
    private HBox area;
    
    @Override
    public void start(Stage primaryStage)
    {
//      primaryStage.setScene(getScene( ));
        primaryStage.setTitle("NotesApp");
        primaryStage.setScene(getScene());
        primaryStage.show( );
    }
    
    private Scene getScene()
    {
        HBox panel = new HBox( );
        //panel.getChildren( ).addAll(buttons( ));
        
        // add to the panel here
        panel.getChildren().addAll(getNotesButtons());
        
        Scene scene = new Scene(panel,WIDTH,HEIGHT);
        return scene;
    }

//    public MenuUI(Button button1,Button button2,Button button3,Button button4,Label label,HBox area)
//    {
//
//        this.button1 = button1;
//        this.button2 = button2;
//        this.button3 = button3;
//        this.button4 = button4;
//        this.label = label;
//        this.area = area;
//    }
    
    public Button[] getNotesButtons()
    {
        // changed it To INT from 15 to avoid magic number
        char integer = 0;
        Button[] notesButton = new Button[integer];
        Button[] buttons = {new Button("Quote"), new Button("todo"), new Button("CodeSnippets"), new Button("Hyperlink")};
        
        String[] buttonNames = {new String("quotenotes"), new String("codesnippetnotes"), new String("todonotes"), new String("hyperlinknotes")};
        for (int i = 0; i < integer; i++)
        {
            notesButton[i] = new Button(buttonNames[i]);
        }
        
        char integer1 = 0;
        for (int i = 0; i < integer1; i++)
        {
            String name = buttonNames[i];
            //notesButton[i].setOnAction(event -> controller.NoteAppController(name, label));
        }
        return buttons;
    }
    
    private GridPane buttons()
    {
        GridPane grid = new GridPane( );
        grid.setId("feature");
        
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(TOP_RIGHT_BOTTOM_LEFT));
        
        ObservableList <ColumnConstraints> cols = grid.getColumnConstraints( );
        for (int i = 0; i <= NUM_COLS; i++)
        {
            cols.add(new ColumnConstraints(COL_WIDTH));
        }
        label = new Label("0");
        area.setId("area");
        area.getChildren( ).add(label);
        area.setPrefHeight(BUTTON_WIDTH);
        grid.add(area,0,5,NUM_COLS,1);
        return grid;
    }
}