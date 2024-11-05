/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Medico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aaron
 */
public class MedicoDao {

    private Connection con;
    private Statement stm;

    public MedicoDao() {

        try {
            con = Conexao.getConnection();
            stm = con.createStatement();

        } catch (ClassNotFoundException | SQLException e) {

        }
    }

    public boolean inserirm(Medico m) {
        try {
            System.out.println(m.getNome_m());
             stm.executeUpdate("insert into medico(nome,cpf,especializacao)values('"+m.getNome_m()+"','"+m.getCpf_m()+"', '"+m.getEspe_m()+"' )");

        } catch (SQLException ex) {

        }
        return false;
    }
     public Medico consultar(int id_medi) throws SQLException {
        ResultSet rs = stm.executeQuery("select * from medico where id_medico = '" +id_medi+ "'");
        Medico m = new Medico();
        while (rs.next()) {
            m.setNome_m(rs.getString("nome"));
            m.setCpf_m(rs.getString("cpf"));
            m.setEspe_m(rs.getString("especializacao"));
        }
        return m;
    }
     
     public boolean atualizar(Medico med) throws SQLException {
         System.out.println(med.getNome_m());
        try {
            
        stm.executeUpdate("update medico set nome ='"+med.getNome_m()+"',cpf='"+med.getCpf_m()+"', especializacao='"+med.getEspe_m()+"' where id_medico = '"+med.getIdmedic()+"' ");
            return true;
        } catch (Exception ex) { 
            return false;
        }
        
    }
    public boolean excluir(int Idmedic){
    try{
          stm.executeUpdate("delete from medico where id_medico= '"+Idmedic+"'");
           return true;
       }catch(Exception ex){
       
       return false;
    
    }
    }
    


    public List<Medico> lista_medico() throws SQLException {
        ResultSet rs = (ResultSet) stm.executeQuery("select id_medico,nome,cpf,especializacao from medico order by id_medico asc");
        List<Medico> lista = new ArrayList<Medico>();
        while (rs.next()) {
            Medico ma = new Medico();
            ma.setIdmedic(rs.getInt("id_medico"));
            ma.setNome_m(rs.getString("nome"));
            ma.setCpf_m(rs.getString("cpf"));
            ma.setEspe_m(rs.getString("especializacao"));
            lista.add(ma);
        }
        return lista;
    }
    public void exlcuir(int idmedic) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
