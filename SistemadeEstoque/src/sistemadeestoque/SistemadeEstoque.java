package sistemadeestoque;

import javafx.stage.Stage;



public class SistemadeEstoque {
    
    
    public static void main(String[] args) throws Exception {   //classe principal
       FXMLDocumentController login=new FXMLDocumentController();   //o PALCO
       Stage stage=new Stage();
       login.start(stage);      //o metodo start abre a janela e recebe o parametro do Stage;
       
       LoginController login2=new LoginController();   //o PALCO
       Stage stage2=new Stage();
       login2.start(stage2); 
       
       ProdutoController login3=new ProdutoController();
       Stage stage3=new Stage();
       login3.start(stage3);
       
       ExcluirController login4=new ExcluirController();
       Stage stage4=new Stage();
       login4.start(stage3);
    }
    
}
