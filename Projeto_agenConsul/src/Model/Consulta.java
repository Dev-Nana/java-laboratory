/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author aaron
 */
public class Consulta {
    private int Id_consulta;
    private String Data;
    private String Hora;
    private int Id_paciente;
    private int Id_medico; 

    public int getId_consulta() {
        return Id_consulta;
    }

    public void setId_consulta(int Id_consulta) {
        this.Id_consulta = Id_consulta;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public int getId_paciente() {
        return Id_paciente;
    }

    public void setId_paciente(int Id_paciente) {
        this.Id_paciente = Id_paciente;
    }

    public int getId_medico() {
        return Id_medico;
    }

    public void setId_medico(int Id_medico) {
        this.Id_medico = Id_medico;
    }

   
} 

