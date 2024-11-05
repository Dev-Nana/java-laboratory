/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projeto_agenconsul;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static javax.xml.bind.DatatypeConverter.parseString;

/**
 *
 * @author aaron
 */
public class FXMLDocumentController extends Application implements Initializable {

    static Stage stage = new Stage();

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        FXMLDocumentController.stage = stage;
    }

    @FXML
    private Button button;

    @FXML
    private TextField login;

    @FXML
    private TextField senha;

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {

        String vlogin =parseString( login.getText());
        String vsenha = parseString(senha.getText());

       if (vlogin.equals("adm") || vsenha.equals("adm")) {
            JOptionPane.showMessageDialog(null, "Login efetuado com sucesso \n bem vindo adm!!");
            HomeController h1 = new HomeController();
            Stage stage1 = new Stage();
            h1.start(stage1);
            stage.close();
        } else if (vlogin != "adm" && vsenha != "adm") {
            JOptionPane.showMessageDialog(null, "Credenciais Incorreta\n" );
        }
        System.out.println("You click me !!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        setStage(stage);
        stage.setScene(scene);
        stage.show();
    }

    private boolean equals() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
