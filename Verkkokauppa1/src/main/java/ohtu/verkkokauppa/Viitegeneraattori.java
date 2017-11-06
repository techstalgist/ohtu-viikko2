package ohtu.verkkokauppa;

public class Viitegeneraattori implements Viite {
  
    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
