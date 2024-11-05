/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author AlunoFGG
 */
public class Cliente {
    private String email;
    private String nome;
    private String celular;
    private String cpf;
    private String senha;
    private int id_cliente1;

    public int getId_cliente1() {
        return id_cliente1;
    }

    public void setId_cliente1(int id_cliente1) {
        this.id_cliente1 = id_cliente1;
    }
    

    
    
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
    this.email = email;
    }
    
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
    this.nome = nome;
    }
   
    
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
    this.celular = celular;
    }
    
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
    this.cpf = cpf;
    }
    
    
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
