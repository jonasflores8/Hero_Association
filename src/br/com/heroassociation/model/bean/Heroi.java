package br.com.heroassociation.model.bean;

public class Heroi {

    private int id;
    private String nome;
    private String identidade;

    public Heroi(int id) {
        this.id = id;
    }

    public Heroi(String nome) {
        this.nome = nome;
    }

    public Heroi(int id, String nome, String identidade) {
        this.id = id;
        this.nome = nome;
        this.identidade = identidade;
    }

    public Heroi(String nome, String identidade) {
        this.nome = nome;
        this.identidade = identidade;
    }

    public Heroi(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public Heroi() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade() {
        this.identidade = identidade;
    }

    @Override
    public String toString() {
        return "Heroi{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", identidade='" + identidade + '\'' +
                '}';
    }

}