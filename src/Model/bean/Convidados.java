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
public class Convidados extends Pessoas{ 
    
    private float valor;
    
    public Convidados(float valor,String nome, String cpf ){
        super(nome, cpf,"", "",0);
        
        this.setValor(valor);
        
    }
    public float getValor(){
    return valor;
    
    }
    
    public void setValor(float valor){
    
            this.valor = valor;
        
    }
    
    
}
