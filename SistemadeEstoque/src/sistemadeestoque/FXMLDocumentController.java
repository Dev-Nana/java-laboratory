package sistemadeestoque;

import DAO.ClienteDao;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;


public class FXMLDocumentController extends Application implements Initializable { 
    
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        FXMLDocumentController.stage = stage;
    }
    

    @FXML
    private Button btnatualizar;

    @FXML
    private Button btnconsulta;

    @FXML
    private Button btnexcluir;
    
    @FXML
    private Button btnenviar;

    @FXML
    private TextField tf_celular;

    @FXML
    private TextField tf_cpf;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_senha;
    

    @FXML
    void enviar(ActionEvent event) throws Exception{    //MDS TENHO Q LEMBRAR D PEDIR AJUDA PRA MARIA
        Cliente f=new Cliente();
        f.setNome(tf_nome.getText());
        f.setEmail(tf_email.getText());     
        f.setCpf(tf_cpf.getText());
        f.setCelular(tf_celular.getText());
        f.setSenha(tf_senha.getText());
        ClienteDao fd=new ClienteDao();
        fd.inserir(f);     //eh esse trocinho aqui que faz a diferença de inserir e d tirar la no Dao neh
        
        LoginController login = new LoginController();
        Stage stage = new Stage();
        login.start(stage);
    }
    
    @FXML
    void atualizar(ActionEvent event) throws SQLException {
          Cliente f=new Cliente();
          f.setNome(tf_nome.getText());
          f.setEmail(tf_email.getText());
          f.setCpf(tf_cpf.getText());
          f.setCelular(tf_celular.getText());
          f.setSenha(tf_senha.getText());
          
          ClienteDao dao=new ClienteDao();
          dao.atualizar(f);
          
        tf_nome.setText("");
        tf_email.setText("");
        tf_cpf.setText("");
        tf_celular.setText("");
        tf_senha.setText("");
        }
    @FXML
    void consultar(ActionEvent event) throws Exception{
//        String cpf=tf_buscar.getText();
//        ClienteDao dao=new ClienteDao();
//        Cliente dao2 = dao.consultar(cpf);
//        tf_nome.setText(dao2.getNome());
//        tf_cpf.setText(dao2.getCpf());
//        tf_email.setText(dao2.getEmail());
//        tf_celular.setText(dao2.getCelular());
//        tf_senha.setText(dao2.getSenha());
//     
    }

    @FXML
    void excluir(ActionEvent event) throws Exception {
        Cliente cpf=new Cliente();
        cpf.setCpf(tf_cpf.getText());
        
        ClienteDao ed=new ClienteDao();
        ed.excluir(tf_cpf.getText());
        
        tf_nome.setText("");
        tf_email.setText("");
        tf_cpf.setText("");
        tf_celular.setText("");
        tf_senha.setText("");
        
        
        
//        FXMLDocumentController login = new FXMLDocumentController();
//        Stage stage = new Stage();
//        login.start(stage);
        }
        
//        tf_nome.setText("");
//        tf_email.setText("");
//        tf_cpf.setText("");
//        tf_celular.setText("");
//        tf_senha.setText("");
//        
//        
//        ExcluirController login = new ExcluirController();
//        Stage stage = new Stage();
//        login.start(stage);

    

//
//        LoginController login = new LoginController();
//        Stage stage = new Stage();
//        login.start(stage);

    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @Override
     public void start(Stage stage) throws Exception {  //o inicio só inicia se tiver isso no controlador dele
        Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    } //MDS ESQUECI D PEDIR AJUDA PRA MARIA
        //LEMBRAR DE PEDIR AMANHÃ
    
}

