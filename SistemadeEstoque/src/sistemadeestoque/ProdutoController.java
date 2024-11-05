/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistemadeestoque;

import DAO.ProdutoDao;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Produto;

/**
 * FXML Controller class
 *
 * @author AlunoFGG
 */
public class ProdutoController implements Initializable {
    
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ProdutoController.stage = stage;
    }
        
    @FXML
    private AnchorPane anchopane;

    @FXML
    private Button btnenviar;

    @FXML
    private Button btnenviar1;

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
    private TextField tf_fabricacao;

    @FXML
    private TextField tf_marca;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_valor;

    @FXML
    private ImageView vhsys;
  @FXML
        private TableView<Produto> tb_produtos;
    @FXML
    private TableColumn<Produto, String> cl_fab;

    @FXML
    private TableColumn<Produto, String> cl_idproduto;

    @FXML
    private TableColumn<Produto, String> cl_marca;

    @FXML
    private TableColumn<Produto, String> cl_nome;

    @FXML
    private TableColumn<Produto, String> cl_valor;

    
    public void incializandocol(){
            cl_fab.setCellValueFactory(new PropertyValueFactory<>("fabricacao"));
            cl_idproduto.setCellValueFactory(new PropertyValueFactory<>("id_produto"));
            cl_marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
            cl_valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
            cl_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
    }
    List<Produto> listar_produtos;
 public void preencherTab() throws SQLException {
  ProdutoDao dao = new ProdutoDao();
        listar_produtos = dao.listar_produtos();
    tb_produtos.setItems(FXCollections.observableArrayList(listar_produtos));
    }
    
        
    
    @FXML
    void confirmar(ActionEvent event) throws Exception {
        Produto P=new Produto();
        P.setNome(tf_nome.getText());
        P.setMarca(tf_marca.getText());
        P.setFabricacao(tf_fabricacao.getText());
        P.setValor(tf_valor.getText());
        ProdutoDao Pd=new ProdutoDao();
        Pd.inserir(P);
        preencherTab();
        
        tf_nome.setText("");
        tf_marca.setText("");
        tf_fabricacao.setText("");
        tf_valor.setText("");

//        ProdutoController produto = new ProdutoController();    //abre a outra páginazinha bonitinha com amor
//        Stage stage = new Stage();
//        produto.start (stage);
        
//            inicializar_tab();
//            preencherTab();
    }
    
    @FXML
    void excluir(ActionEvent event) throws Exception{
        Produto fa=new Produto();
        fa.setFabricacao(tf_fabricacao.getText());
        
        ProdutoDao pd=new ProdutoDao();
        pd.excluir(tf_fabricacao.getText());
        
        tf_nome.setText("");
        tf_marca.setText("");
        tf_fabricacao.setText("");
        tf_valor.setText("");
        preencherTab();
    }
    
     public void start(Stage stage) throws Exception { //o produto só inicia se tiver isso daqui
         
        Parent root = FXMLLoader.load(getClass().getResource("Produto.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        incializandocol();
        
        try{
        preencherTab();
        }catch(SQLException ex){
        
        }
        
       
        
    }    
    
//    public void inicializar_tab() {    //coluna do produto
//    //colunas do medico
//    id_produto.setCellValueFactory(new PropertyValueFactory<>("id_produto"));     //acho que especifica como preencher as células da tabela
//    nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
//    marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
//    fabricacao.setCellValueFactory(new PropertyValueFactory<>("fabricacao"));
//    valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
//    }
//    
//    
//
// 
//    
}
