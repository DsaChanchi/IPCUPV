/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrega1;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


/**
 * FXML Controller class
 *
 * @author Héctor
 */
public class SalaController implements Initializable {

    @FXML
    private GridPane panel;
    public int fila = 18;
    public int col = 12;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Botonsala(ActionEvent event) {
      Button b = (Button) event.getSource();
      b.setStyle("-fx-background-color: #B22222; ");
      b.setVisible(false);
      
    }

    @FXML
    private void rectificar(ActionEvent event) {
       for(int i=1;i<fila;i++){
          for(int j=1;i<col;j++){
             if (panel.getChildren().get(i*12+j) instanceof Label || panel.getChildren().get(i*12+j) instanceof Group){
             j++;
             }
             else{
             Button b = (Button)panel.getChildren().get(i*12+j);
             if (b.isVisible() == false) b.setVisible(true);}
          }
       }
    }

   
    
}
