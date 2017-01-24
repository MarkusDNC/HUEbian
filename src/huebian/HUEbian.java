/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huebian;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Markus
 */
public class HUEbian extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("JavaFX Welcome");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(80, 25, 25, 25));
        
        Button btn = createControlButton("Vardagsrum");
        btn.setId("buttonOn");
        grid.add(btn, 0, 0);
        for(int i=1; i<5; i++){
            btn = createControlButton("Hall" + i);
            if(i<5){
                grid.add(btn, i, 0);
            }
            else {
                grid.add(btn, i-5, 1);
            }
        }
        
        Scene scene = new Scene(grid, 800, 480);
        primaryStage.setScene(scene);
        scene.getStylesheets().add
            (HUEbian.class.getResource("Huebian.css").toExternalForm());
                
        primaryStage.show();
    }
    
    private Button createControlButton(String name){
        Button btn = new Button(name);
        btn.setMaxHeight(125);
        btn.setMaxWidth(125);
        btn.setMinHeight(125);
        btn.setMinWidth(125);
        btn.setId("buttonOff");
        return btn;
    }
    /*
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Vardagsrum");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Running HUEbian");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 800, 480);
        
        primaryStage.setTitle("HUEbian");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
