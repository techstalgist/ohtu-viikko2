package ohtu.verkkokauppa;

public class Kauppa {

    private Tavarasailo tavarasailo;
    private Rahaliikenne rahaliikenne;
    private Ostoskori ostoskori;
    private Viite viitenumero;
    private String kaupanTili;

    public Kauppa(Rahaliikenne liikenne, Tavarasailo sailo, Viite viite) {
        tavarasailo = sailo;
        rahaliikenne = liikenne;
        viitenumero = viite;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = tavarasailo.haeTuote(id); 
        tavarasailo.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (tavarasailo.saldo(id)>0) {
            Tuote t = tavarasailo.haeTuote(id);             
            ostoskori.lisaa(t);
            tavarasailo.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitenumero.uusi();
        int summa = ostoskori.hinta();
        
        return rahaliikenne.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
