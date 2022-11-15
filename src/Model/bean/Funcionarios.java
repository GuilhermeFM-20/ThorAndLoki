/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.bean;

import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class Funcionarios extends Pessoas{
    private float salario;
    private String funcao;
    
    public Funcionarios(String funcao, float salario, String nome, String cpf, String endereco, String telefone, int idade){
        super(nome, cpf, endereco, telefone,idade);
        
        this.setSalario(salario);
        this.setFuncao(funcao);
    }
    public float getSalario(){
        return salario;
<<<<<<< HEAD
}
=======
    }


>>>>>>> b50fd9de76516147113a5ad31cf9074c57202285
    public void setSalario(float salario) {
        if (salario > 0){
            this.salario = salario;
        }else{
            JOptionPane.showMessageDialog(null, "Salário inválido");
        }
    }
<<<<<<< HEAD
    public String getFuncao{}{
        return funcao;
}  
    public void setFuncao{float Funcao}{
=======
    
    public String getFuncao(){
        return funcao;
}
    
    public void setFuncao(String Funcao){
>>>>>>> b50fd9de76516147113a5ad31cf9074c57202285
        this.funcao = funcao;
}  
}