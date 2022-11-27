/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package View;

import Connection.Conexao;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;
import Jm.JMascara;

/**
 *
 * @author Guilherme Freire
 */
public class ThorAndLoki{

    public static void main(String[] args) throws SQLException {
    
        Home home = new Home();
        
        home.setVisible(true);
        
        Conexao conn = new Conexao();  

    }
    
    
    public void addIcon(JFrame frm){
        
        try{
            
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Image/tl.png"));
        
        }catch(Exception e){
            
            System.out.println("Imagem não encontrada: " + e);
            
        }
        
    }
    
     public String maskCpf(String cpf2){
        
        
         return JMascara.GetJmascaraCpfCnpj(cpf2);
        
        
    }
    
    public String maskFone(String fone){
        
        
        return JMascara.GetJmascaraFone(fone);
        
        
    }
    
    public String maskHoras(String hora){
        
        
        try {
            MaskFormatter mask = new MaskFormatter("##:##");
            mask.setValueContainsLiteralCharacters(false);
            
             return mask.valueToString(hora);
            
        } catch (ParseException ex) {
            System.out.println("erro :" + ex);
        }
        return null;
        
    }
    
    public String maskValor(float valor){
        
        System.out.println(valor);
        
        Locale localBrasil = new Locale("pt", "BR");
        String moeda = NumberFormat.getCurrencyInstance(localBrasil).format(valor);
        
        return moeda.substring(2,moeda.length());
        
    }
    
}
