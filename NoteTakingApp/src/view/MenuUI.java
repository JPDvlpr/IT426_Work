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
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    
    private static final double BUTTON_WIDTH = 20;
    public static final int COL_WIDTH = 45;
    public static final int INT = 15;
    public static final int INT1 = 15;
    public static final int INT2 = 15;
    public static final int TOP_RIGHT_BOTTOM_LEFT = 50;
    public static final int INT3 = 15;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    private Label label;
    private BorderPane area;
    
    @Override
    public void start(Stage primaryStage)
    {
        button1 = new Button();
        button1.setText("Quota");
//        button2.setText("Hyperlink");
//        button3.setText("CodeSnippets");
//        button4.setText("TodoList");
//        primaryStage.setScene(getScene( ));
        primaryStage.setTitle("NotesApp");
        primaryStage.show( );
    
    }
    
    private Scene getScene()
    {
        BorderPane panel = new BorderPane( );
        panel.getChildren( ).addAll(buttons( ));
        
        Scene scene = new Scene(panel,WIDTH,HEIGHT);
//        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        return scene;
    }
    
    private BorderPane buttons()
    {
        BorderPane bpane = new BorderPane( );
        bpane.setId("feature");
    
        bpane.setBottom(button1);
        bpane.setBottom(button2);
        bpane.setBottom(button3);
        bpane.setBottom(button4);

        bpane.setPadding(new Insets(TOP_RIGHT_BOTTOM_LEFT));
    
        label = new Label("0");
        area = new BorderPane();
        area.setId("area");
        area.getChildren().add(label);
  
        area.setPrefHeight(BUTTON_WIDTH);
        
        return bpane;
    }
    
}