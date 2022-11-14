/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.bean;

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
    public float getSalario{}{
        return salario;
}


    public void setSalario(float salario) {
        if (salario > 0){
            this.salario = salario;
        }
        else{
            JOptionPane.showMessageDialog(null, "Salário inválido");
        }
    }
    
    public String getFuncao{}{
        return funcao;
}
    
    public void setFuncao{float Funcao}{
        this.funcao = funcao;
}
    
}
