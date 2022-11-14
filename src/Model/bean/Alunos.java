package Model.bean;
// @author jpss3
 
public class Alunos extends Pessoas{
    
    private float mensalidade;
    private float multaatraso;       
    
    public Alunos(String nome, String cpf, String endereco, String telefone, int idade,float mensalidade, float multaatraso){

        super(nome, cpf, endereco, telefone,idade);
        
    }
    
    public float getMensalidade() {
        return mensalidade; 
        
    }
    
    public void setMensalidade(String mensalidade) {
        
        switch(mensalidade){
            case"Básico":
                this.mensalidade = 70;
              break;
                
            case"Médio":
                this.mensalidade = 90;
              break;
                
            case"Completo":
                this.mensalidade = 120;
              break;
        }
  
    }
   
    public float getMultaAtraso(){
        return multaatraso;   
        
    }
    
    public void setMultaAtraso(float multaatraso) {
        this.multaatraso = multaatraso;
        
    }
    
}
