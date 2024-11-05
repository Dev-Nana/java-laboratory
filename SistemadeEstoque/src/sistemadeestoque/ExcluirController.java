/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistemadeestoque;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author evyla
 */
public class ExcluirController  extends Application implements Initializable {
    
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ExcluirController.stage = stage;
    }
    
    @FXML
    private TextField cpf;

    @FXML
    private Button excluir;

    @FXML
    void excluir(ActionEvent event) {
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {  //o inicio só inicia se tiver isso no controlador dele
       Parent root = FXMLLoader.load(getClass().getResource("excluiCliente.fxml"));

       Scene scene = new Scene(root);

       stage.setScene(scene);
       stage.show();
    }
     
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
