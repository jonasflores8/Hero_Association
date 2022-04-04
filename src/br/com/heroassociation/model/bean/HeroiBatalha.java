package br.com.heroassociation.model.bean;

public class HeroiBatalha {

    private int id;
    private int heroiId;
    private int batalhaId;
    private Heroi heroi;
    private Batalha batalha;

    public HeroiBatalha(int heroiId, int batalhaId) {
        this.heroiId = heroiId;
        this.batalhaId = batalhaId;
    }

    public HeroiBatalha(int id, Heroi heroi, Batalha batalha) {
        this.id = id;
        this.heroi = heroi;
        this.batalha = batalha;
    }

    public HeroiBatalha(int id) {
        this.id = id;
    }

    public HeroiBatalha(int id, int heroiId, int batalhaId) {
        this.id = id;
        this.heroiId = heroiId;
        this.batalhaId = batalhaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeroiId() {
        return heroiId;
    }

    public void setHeroiId(int heroiId) {
        this.heroiId = heroiId;
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    public int getBatalhaId() {
        return batalhaId;
    }

    public void setBatalhaId(int batalhaId) {
        this.batalhaId = batalhaId;
    }

    public Batalha getBatalha() {
        return batalha;
    }

    public void setBatalha(Batalha batalha) {
        this.batalha = batalha;
    }

    @Override
    public String toString() {
        String retorno = "";
        String heroiHb = "null";
        String hbNull = "null";
        if(this.heroi == null & this.batalha == null){
            hbNull = "HeroiBatalha{" +
                    "id=" + id +
                    ", heroiId=" + heroiId +
                    ", batalhaId=" + batalhaId +
                    ", heroi=" + heroi +
                    ", batalha=" + batalha +
                    '}';
            retorno = hbNull;
        }
        if (this.heroi != null & this.batalha != null){
            heroiHb = "HeroiBatalha{" +
                    "id=" + id +
                    ", heroi=" + heroi.getNome() +
                    ", batalha=" + batalha.getNome() + ", descrição =" + batalha.getDescricao() +
                    '}';
            retorno = heroiHb;
        }
        return retorno;
    }

}
