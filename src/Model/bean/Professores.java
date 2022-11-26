package Model.bean;

import javax.swing.JOptionPane;

public class Professores extends Pessoas{

    protected float salario;
    protected String horastrab;
    
    public Professores(String nome, String cpf, String endereco, String telefone, float salario, String horas_trab){
        super(nome, cpf, endereco, telefone, 0);
        
        this.setSalario(salario);
        this.setHoras_trab(horas_trab);
        
    }
    
    public float getSalario() {
        return salario;
    }
    
    public void setSalario(float salario) {
       
        this.salario = salario;
      
    }
    
    public String getHoras_trab() {
        return horastrab;
    }
    
    public void setHoras_trab(String horastrab) {
        this.horastrab = horastrab;
    }

        
}
