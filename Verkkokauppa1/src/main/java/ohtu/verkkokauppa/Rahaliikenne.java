package ohtu.verkkokauppa;


public interface Rahaliikenne {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
