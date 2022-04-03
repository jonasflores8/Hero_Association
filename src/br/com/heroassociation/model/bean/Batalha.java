package br.com.heroassociation.model.bean;

import java.util.List;

public class Batalha {

    private int id;
    private String nome;
    private String descricao;
    private float duracao;
    private List<HeroiBatalha> batalhaHerois;

    public Batalha(int id, String nome, String descricao, float duracao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
    }

    public Batalha(int id) {
        this.id = id;
    }

    public Batalha(String nome, String descricao, float duracao) {
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

    public List<HeroiBatalha> getBatalhaHerois() {
        return batalhaHerois;
    }

    public void setBatalhaHerois(List<HeroiBatalha> batalhaHerois) {
        this.batalhaHerois = batalhaHerois;
    }

    @Override
    public String toString() {
        return "Batalha{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", duracao=" + duracao +
                ", batalhaHerois=" + batalhaHerois +
                '}';
    }
}