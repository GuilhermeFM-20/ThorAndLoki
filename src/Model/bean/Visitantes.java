/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.bean;

import javax.swing.JOptionPane;

/**
 *
 * @author kleyb
 */
public class Visitantes extends Pessoas{ 
    
    private float valor;
    
    public Visitantes(float valor,String nome, String cpf, String endereco, String telefone, int idade){
        super(nome, cpf, endereco, telefone,idade);
        
        this.setValor(valor);
        
    }
    public float getValor(){
    return valor;
    
    }
    
    public void setValor(float valor){
    if (valor > 0){
            this.valor = valor;
        }
        else{
            JOptionPane.showMessageDialog(null, "Valor inválido.");
        }
    
    }
    
    
}
