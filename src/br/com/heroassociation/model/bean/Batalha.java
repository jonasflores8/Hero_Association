package br.com.heroassociation.model.bean;

public class Batalha {

    private int id;
    private String nome;
    private String descricao;
    private float duracao;

    public Batalha() {

    }

    public Batalha(int id) {
        this.id = id;
    }

    public Batalha(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Batalha(String nome, String descricao, float duracao) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
    }

    public Batalha(int id, String nome, String descricao, float duracao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Batalha{" +
                "id: " + id +
                ", Nome: " + nome +
                ", Descricao: " + descricao +
                ", Duracao: " + duracao +
                '}';
    }

}