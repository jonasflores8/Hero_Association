package br.com.heroassociation.model.bean;

import java.util.Calendar;
import java.util.List;

public class Batalha {

    private int id;
    private String nome;
    private String descricao;
    private Calendar dtInicio;
    private Calendar dtFim;
    private List<HeroiBatalha> batalhaHerois;

}