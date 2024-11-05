/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author evyla
 */
public class ProdutoDao {
     private Connection com;
    private Statement stm; 

 public ProdutoDao(){ //construtor
	try{		//RECEBE A CONEXAO 
 	com=conexao.getConnection();		 
	stm=com.createStatement(); //objeeto q executa qualquer comando na bdd
        } catch(ClassNotFoundException | SQLException e){
}

} 
 
 public boolean inserir(Produto P){  //insere no bdd
     	try{		//RECEBE A CONEXAO 
            stm.executeUpdate("insert into produto(nome,marca,fabricacao,valor)values('"+P.getNome()+"','"+P.getMarca()+"','"+P.getFabricacao()+"','"+P.getValor()+"')");
           return true;
        } catch (SQLException ex){
            return false;
        }
    }
 
// public Produto consultar(String noem) throws SQLException{
//      ResultSet rs =stm.executeQuery("select * from cliente where cpf = '"+cpf + "'");
//     Cliente c =new Cliente();
//      while (rs.next()){
//          c.setEmail(rs.getString("email"));
//          c.setNome(rs.getString("nome"));
//          c.setCelular(rs.getString("celular"));
//          c.setCpf(rs.getString("cpf"));
//          c.setSenha(rs.getString("senha"));
//      }
//      return c;
// }
//
// public boolean excluir (String cpf ) throws SQLException{
//     try{
//         stm.executeUpdate("delete from where cpf="+cpf);
//            return true;
//     }catch(SQLException ex){
//            return false;
//     }
// }
 
 public boolean excluir(String fabricacao) throws SQLException{
     try{
         ResultSet rs =stm.executeQuery("select * from produto where fabricacao = '"+fabricacao + "'");
         if(rs.next()){
            stm.executeUpdate("delete from produto where fabricacao='"+fabricacao+"'");
         }
     } catch (SQLException ex) {
         
     }
     return true;
 }
 
public List<Produto> listar_produtos() throws SQLException {
ResultSet rs = (ResultSet) stm.executeQuery("select * from produto");
List<Produto> lista = new ArrayList<Produto>();
while (rs.next()) {
    Produto p = new Produto();

    p.setId_produto(rs.getInt("id_produto"));
    p.setNome(rs.getString("nome"));
    p.setMarca(rs.getString("marca"));
    p.setFabricacao(rs.getString("fabricacao"));
    p.setValor(rs.getString("valor"));
    lista.add(p);
}
return lista;
}

}
