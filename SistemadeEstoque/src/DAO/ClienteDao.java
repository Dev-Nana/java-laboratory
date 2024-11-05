/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.TextField;
import model.Cliente;


/**
 *
 * @author AlunoFGG
 */
public class ClienteDao {   //até aqui dando tudo certo, amo minha vida
    private Connection com;
    private Statement stm; 

 public ClienteDao(){ //construtor
	try{		//RECEBE A CONEXAO 
 	com=conexao.getConnection();		 
	stm=com.createStatement(); //objeeto q executa qualquer comando na bdd
        } catch(ClassNotFoundException | SQLException e){
}

} 
 
 public boolean inserir(Cliente f){  //insere no bdd
     	try{		//RECEBE A CONEXAO 
            stm.executeUpdate("insert into cliente1(email,nome,celular,cpf,senha)values('"+f.getEmail()+"','"+f.getNome()+"','"+f.getCelular()+"','"+f.getCpf()+"','"+f.getSenha()+"')");
           return true;
        } catch (SQLException ex){  
            return false;
        }
    }
// 
public Cliente atualizar(Cliente f) throws SQLException{
    
    try {       //FINALMENTE EU ENTENDI JAVA <3<3<3
        stm.executeUpdate("update cliente1 set email='" + f.getEmail() + "',nome='" + f.getNome() + "', celular='" + f.getCelular() + "', senha='" + f.getSenha() + "' where cpf='"+f.getCpf()+"'");
        } catch (SQLException ex) {

}
        return null;
}

//MANCHO TA TUDO DANDO ERRADO DNV
////      ResultSet rs =stm.executeQuery("select * from cliente where cpf = '"+cpf + "'");
////     Cliente c =new Cliente();
////      while (rs.next()){
////          c.setEmail(rs.getString("email"));
////          c.setNome(rs.getString("nome"));
////          c.setCelular(rs.getString("celular"));
////          c.setCpf(rs.getString("cpf"));
////          c.setSenha(rs.getString("senha"));
////      }
////      return c;
////         ResultSet rs = stm.executeQuery("select * from client1 where cpf='"+cpf+"'");
////         Cliente f = new Cliente();
////         while (rs.next()) {
////         f.setNome(tf_nome.getText());
////         f.setEmail(tf_email.getText());
////         f.setCpf(tf_cpf.getText());
////         f.setCelular(tf_celular.getText());
////         f.setSenha(tf_senha.getText());
////         }
////         return c;
////    }
//}
//public Cliente consultar(Cliente f) throws SQLException{
//         ResultSet rs = stm.executeQuery("select * from cliente1 where cpf='"+cpf+"'");
//         Cliente f = new Cliente();
//         while (rs.next()) {
//         f.setEmail(rs.getString("email"));
//         f.setNome(rs.getString("nome"));
//         f.setCelular(rs.getString("celular"));
//         f.setCpf(rs.getString("cpf"));
//         }
//         return f;
//}
 public boolean excluir(String cpf) throws SQLException{    //CONSEGUUIII
     try{
         ResultSet rs = stm.executeQuery("select * from cliente1 where cpf = '"+cpf + "'");
         if(rs.next()){     //se rs tiver armazenando alguma coisa 
            stm.executeUpdate("delete from cliente1 where cpf='"+cpf+"'");
         }
     } catch (Exception ex) {
         
     }
     return true;
 }
 
}

