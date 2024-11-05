/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Medico;
import Model.Paciente;
import Model.Consulta;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author aaron
 */
public class ConsultaDao {

    private Connection con;
    private Statement stm;

    public ConsultaDao() {
        try {
            con = Conexao.getConnection();
            stm = con.createStatement();

        } catch (ClassNotFoundException | SQLException e) {

        }
    }

    public boolean agendar(Consulta c) {
        try {
            System.out.println(c.getId_medico());
            stm.executeUpdate("insert into consultas(data_c,hora_c,id_paciente,id_medico)values('" + c.getData() + "', '" + c.getHora() + "', '" + c.getId_medico() + "', '" + c.getId_paciente() + "')");
        } catch (SQLException e) {

        }
        return false;
    }

    public List<Medico> list_medicocons() throws SQLException {
        ResultSet res = (ResultSet) stm.executeQuery("select id_medico, nome from Medico");
        List<Medico> listaM = new ArrayList<Medico>();
        while (res.next()) {
            Medico mc = new Medico();
            mc.setIdmedic(res.getInt("id_medico"));
            mc.setNome_m(res.getString("nome"));
            listaM.add(mc);
        }
        return listaM;
    }

    public List<Paciente> list_pacientecons() throws SQLException {
        ResultSet re = (ResultSet) stm.executeQuery("select id_paciente,nome from paciente1");
        List<Paciente> listaPc = new ArrayList<Paciente>();
        while (re.next()) {
            Paciente pc = new Paciente();
            pc.setId_paci(re.getInt("id_paciente"));
            pc.setNome(re.getString("nome"));
            listaPc.add(pc);
        }
        return listaPc;
    }

    public List<Consulta> listar_consultas() throws SQLException {
        ResultSet rs = (ResultSet) stm.executeQuery("select * from consultas");
        List<Consulta> lista = new ArrayList<Consulta>();
        while (rs.next()) {
            Consulta c = new Consulta();

            c.setData(rs.getString("data_c"));
            c.setHora(rs.getString("hora_c"));
           c.setId_medico(rs.getInt("id_medico"));
           c.setId_consulta(rs.getInt("id_consulta"));
           c.setId_paciente(rs.getInt("id_paciente"));
            lista.add(c);
        }
        return lista;
    }

}
