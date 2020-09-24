/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrega1;

import accesoaBD.AccesoaBD;
import java.awt.Font;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Proyeccion;

/**
 *
 * @author Héctor
 */
public class FXMLDocumentController implements Initializable {
    
@FXML
private ListView<Proyeccion> Lista;
@FXML
private ImageView ImagenesPeliculas;
private accesoaBD.AccesoaBD db;
private ArrayList<Proyeccion> listproy;
private ObservableList<Proyeccion> oblistproy;
@FXML
private DatePicker Fecha;



   @Override
    public void initialize(URL url, ResourceBundle rb) {
        listproy=new ArrayList();
        db=new AccesoaBD();
        Lista.getSelectionModel().selectedIndexProperty().addListener((o) -> {
            ImagenesPeliculas.setImage(Lista.getSelectionModel().getSelectedItem().getPelicula().getImagen());
        });
        Lista.setCellFactory((ListView<Proyeccion> param) -> new ListCell<Proyeccion> (){
        @Override    
        
        protected void updateItem(Proyeccion item,boolean empty){
            super.updateItem(item, empty);
                if(item == null || empty){setText(null);}
                else{ 
                    setText(" "+item.getPelicula().getTitulo()+" "+item.getSala().getNombresala());
                }
            
        }
    });
}
  
    @FXML
    private void CARTELERA(ActionEvent event) {
      listproy=(ArrayList) db.getProyeccionesDia(Fecha.getValue());  
      oblistproy = FXCollections.observableArrayList(listproy);
      Lista.setItems(oblistproy);
      
       
    } 

    
     public void Cambioventana1() throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Sala.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("Venta de entradas");
    stage.setScene(new Scene(root1));  
    stage.show();  
    
   }
     
    public void Cambioventana2() throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Estadisticas.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("Estadísticas");
    stage.setScene(new Scene(root1));  
    stage.show();  
    
   }

    

    @FXML
    private void comre(ActionEvent event) throws IOException {
        Cambioventana1();
    }

    @FXML
    private void Estats(ActionEvent event) throws IOException {
        Cambioventana2();
    }
    
    
  }
