
package sistemadeestoque;
import DAO.EstoqueDao;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Estoque;

/**
 * FXML Controller class
 *
 * @author AlunoFGG
 */
public class LoginController extends Application implements Initializable {
    
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        LoginController.stage = stage;
    }
    
    
//    @FXML
//    private AnchorPane anchopane;
//
//    @FXML
//    private Button btnenviar;
//
//    @FXML
//    private ImageView img;
//
//    @FXML
//    private Pane pane;
//
//    @FXML
//    private Pane pane1;
//
//    @FXML
//    private Pane pane2;
//
//    @FXML
//    private Text text1;
//
//    @FXML
//    private Text text2;
//
//    @FXML
//    private TextField tf_celular;
//
//    @FXML
//    private TextField tf_cpf;
//
//    @FXML
//    private TextField tf_email;
//
//    @FXML
//    private TextField tf_nome;
//
//    @FXML
//    private TextField tf_senha;
//
//    @FXML
//    private ImageView vhsys;
//
//    @FXML
//    void enviar(ActionEvent event) {
//        Estoque f=new Estoque();
//        f.setNome(tf_nome.getText());
//        f.setQuan(tf_email.getText());
//        f.setCpf(tf_cpf.getText());
//        f.setCelular(tf_celular.getText());
//        f.setSenha(tf_senha.getText());
//        ClienteDao fd=new ClienteDao();
//        fd.inserir(f);
//        
//        LoginController login = new LoginController();
//        Stage stage = new Stage();
//        login.start(stage);
//    }
    
    @FXML
    private AnchorPane anchopane;

    @FXML
    private Button btnenviar;

    @FXML
    private ImageView img;

    @FXML
    private Pane pane;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Text text1;

    @FXML
    private Text text2;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_quantidade;

    @FXML
    private TextField tf_categoria;
    
    @FXML
    private TextField tf_cpf;


    @FXML
    private ImageView vhsys;

    @FXML
    void confirmar(ActionEvent event) throws Exception {
        
        Estoque E=new Estoque();
        E.setNome(tf_nome.getText());
        E.setQuantidade(tf_quantidade.getText());
        E.setCategoria(tf_categoria.getText());
        E.setCpf(tf_cpf.getText());
        EstoqueDao Ed=new EstoqueDao();
        Ed.inserir(E);
        
        ProdutoController produto = new ProdutoController();
        Stage stage = new Stage();
        produto.start(stage);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

     public void start(Stage stage) throws Exception { //o login do inicia se tiver isso daqui
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
     
}

