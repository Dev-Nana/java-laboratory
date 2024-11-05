/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Paciente;
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
public class PacienteDao {

    private Connection con;
    private Statement stm;

    public PacienteDao() {

        try {
            con = Conexao.getConnection();
            stm = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {

        }

    }

    public boolean inserir(Paciente p) {
        try {
          //  System.out.println(p.getNome());
            stm.executeUpdate("insert into paciente1(nome,cpf,telefone)values('" + p.getNome() + "','" + p.getCpf() + "', '" + p.getTell() + "' )");
        } catch (SQLException ex) {

        }
        return false;
    }

    public Paciente consultar(int id_paci) throws SQLException {
        ResultSet rs = stm.executeQuery("select * from paciente1 where id_paciente = '" +id_paci+ "'");
        Paciente p = new Paciente();
        while (rs.next()) {
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("cpf"));
            p.setTell(rs.getString("telefone"));
        }
        return p;
    }

    public boolean exlcuir(int  id_paci) throws SQLException {
        try {
            stm.executeUpdate("delete from paciente1 where id_paciente = '" +id_paci + "'");
            return true;
        } catch (Exception ex) {

            return false;
        }

    }

    public boolean atualizar(Paciente paci) throws SQLException {
        try {
            stm.executeUpdate("update paciente1 set nome='" + paci.getNome() + " ', cpf='" + paci.getCpf() +
                                            "', telefone='" + paci.getTell() + "' where id_paciente = '"+ paci.getId_paci()+"' ");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public List<Paciente> lista_paciente() throws SQLException {
        ResultSet rs = (ResultSet) stm.executeQuery("select id_paciente, nome, cpf, telefone from paciente1 order by id_paciente asc");
        List<Paciente> lista = new ArrayList<Paciente>();
        while (rs.next()) {
            Paciente pa = new Paciente();
            pa.setId_paci(rs.getInt("id_paciente"));
            pa.setNome(rs.getString("nome"));
            pa.setCpf(rs.getString("cpf"));
            pa.setTell(rs.getString("telefone"));
            lista.add(pa);
        }
        return lista;
    }

}
