/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.bean;

/**
 *
 * @author Guilherme Freire
 */
 public class Pessoas{
    
    protected String nome;
    protected String cpf;
    protected String endereco;
    protected String telefone;
    
    public Pessoas(String nome, String cpf, String endereco, String telefone){
        
        this.setNome(nome);
        this.setCpf(cpf);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        
    }

    /*public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade < 11){
            
           System.out.println("Idade inválida");
            
        }else{
            
            this.idade = idade;
            
        }
    }*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) { 
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        
        this.endereco = endereco;
        
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
