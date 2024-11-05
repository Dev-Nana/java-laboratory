/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static java.awt.PageAttributes.MediaType.C1;
import static java.lang.Math.E;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Cliente;
import model.Estoque;

/**
 *
 * @author evyla
 */
public class EstoqueDao {
    private Connection com;
    private Statement stm; 

 public EstoqueDao(){ //construtor
	try{		//RECEBE A CONEXAO 
 	com=conexao.getConnection();		 
	stm=com.createStatement(); //objeeto q executa qualquer comando na bdd
        } catch(ClassNotFoundException | SQLException e){
}

} 
 
 public boolean inserir(Estoque E){  //insere no bdd
     	try{		//RECEBE A CONEXAO 
           stm.executeUpdate("insert into estoque(nome,quantidade,categoria,cpf)values('"+E.getNome()+"','"+E.getQuantidade()+"','"+E.getCategoria()+"','"+E.getCpf()+"')");
           return true;
        } catch (SQLException ex){
            return false;
        }
    }
 
//public boolean inserir(Estoque E, Estoque Cpf){  //insere no bdd
//      try{		//RECEBE A CONEXAO 
//         ResultSet rs = stm.executeQuery("select id_cliente1 from cliente1 where cpf = '"+Cpf + "'");
//         if(rs.next()){
//         stm.executeUpdate("insert into estoque(nome,quantidade,categoria,cpf)values('"+E.getNome()+"','"+E.getQuantidade()+"','"+E.getCategoria()+"','"+E.getCpf()+"')");
//         return true;
//         }
//      } catch (SQLException ex){
//      }
//        return false;
//  }
 
 
 
//try{
//         ResultSet rs =stm.executeQuery("select * from cliente1 where cpf = '"+cpf + "'");
//         if(rs.next()){     //se rs tiver armazenando alguma coisa 
//            stm.executeUpdate("delete from cliente1 where cpf='"+cpf+"'");
//         }
//     } catch (Exception ex) {
//         
//}
//public boolean inserir(Estoque Cpf, Estoque E){  //insere no bdd //esse cpf aí tem o cpf do formulário de estoque
//
//    try{
//    ResultSet rs = stm.executeQuery("select id_cliente1 from cliente1 where cpf = '"+Cpf + "'");
//    if(rs.next()){     //se rs tiver armazenando alguma coisa 
//    Cliente C1 = new Cliente();
//    C1.setId_cliente1(rs.getInt("id_cliente1"));
//       stm.executeUpdate("insert into estoque(nome,quantidade,categoria,cpf)values('"+E.getNome()+"','"+E.getQuantidade()+"','"+E.getCategoria()+"','"+E.getCpf()+"','')");
//    }
//    } catch (Exception ex) {
//         
//    }
//      return true;
// }
//    
//try{		//RECEBE A CONEXAO 
//   ResultSet rs =stm.executeQuery("select id_cliente1 from cliente1 where cpf = '"+Cpf +"'");//o cpf do cliente igual ao do cpf do estoque
//
//   Cliente C1 = new Cliente();
//   C1.setId_cliente1(rs.getInt("id_cliente1"));
//   System.out.println(C1.getId_cliente1()); 
//   stm.executeUpdate("insert into estoque(nome,quantidade,categoria,cpf, id_cliente1)values('"+E.getNome()+"','"+E.getQuantidade()+"','"+E.getCategoria()+"','"+Cpf+"','"+C1.getId_cliente1()+"')");
//   return true;
//
//} catch (SQLException ex){
//    return false;
//}

 
 public Estoque consultar(String cpf) throws SQLException{
     ResultSet rs =stm.executeQuery("select * from estoque where cpf = '"+cpf + "'");
     Estoque c =new Estoque();
      while (rs.next()){
          c.setNome(rs.getString("nome"));
          c.setQuantidade(rs.getString("quantidade"));
          c.setCategoria(rs.getString("categoria"));
          c.setCpf(rs.getString("cpf"));
      }
      return c;
 }

 public boolean excluir (String cpf ) throws SQLException{
     try{
         stm.executeUpdate("delete from where cpf="+cpf);
            return true;
     }catch(SQLException ex){
            return false;
     }
 }
 
 
}
