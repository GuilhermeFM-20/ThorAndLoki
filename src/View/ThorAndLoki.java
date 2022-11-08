/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package View;

import Connection.Conexao;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author Guilherme Freire
 */
public class ThorAndLoki{

    public static void main(String[] args) throws SQLException {
    
        Home home = new Home();
        
        home.setVisible(true);
        
        Conexao conn = new Conexao();
        
       conn.save(" INSERT INTO alunos(alun_nome,alun_cpf,alun_idade,alun_mensalidade,alun_multa,alun_endereco,alun_telefone) VALUES ('teste g2','1234567899',12,8.00,5.00,'vxcvvcxv','84 996741559')");
        
        ResultSet valor = conn.query("SELECT * FROM alunos");
        
        while(valor.next()){
            
              System.out.println(valor.getString("alun_nome"));
              System.out.println(valor.getString("alun_cpf"));
            
        }
        
        
        System.out.println(conn.numRows("SELECT * FROM alunos"));
        
        

    }
    
    
    public void addIcon(JFrame frm){
        
        try{
            
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Image/tl.png"));
        
        }catch(Exception e){
            
            System.out.println("Imagem não encontrada: " + e);
            
        }
        
    }
    
    
    
}
