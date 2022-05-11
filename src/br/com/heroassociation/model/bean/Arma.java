package br.com.heroassociation.model.bean;

public class Arma {

    private int id;
    private String nome;
    private String tipo;
    private Heroi heroi;
    private int heroiId;

    public Arma() { }

    public Arma(int id) {
        this.id = id;
    }

    public Arma(String nome, String tipo, int heroiId) {
        this.nome = nome;
        this.tipo = tipo;
        this.heroiId = heroiId;
    }

    public Arma(int id, String nome, String tipo, Heroi heroi) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.heroi = heroi;
    }

    public Arma(int id, String nome, String tipo, int heroiId) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.heroiId = heroiId;
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getHeroiId() { return heroiId; }

    public void setHeroiId(int heroiId) {
        this.heroiId = heroiId;
    }

    @Override
    public String toString() {
        String retorno = "";
        String msgHeroi = "null" ;
        String heroiNull = "null";
        String msg;
        if(this.heroi != null) {
            msgHeroi = "Arma{" +
                    "id: " + id +
                    ", Nome: " + nome +
                    ", Tipo: " + tipo +
                    ", Heroi: " + heroi.getNome() +
                    '}';
            retorno = msgHeroi;
        }
        if(this.heroi == null){
            heroiNull = "Arma{" +
                    "id: " + id +
                    ", Nome: " + nome +
                    ", Tipo: " + tipo +
                    ", HeroiId: " + heroiId +
                    '}';
            retorno = heroiNull;
        }

        return retorno;
    }

}
