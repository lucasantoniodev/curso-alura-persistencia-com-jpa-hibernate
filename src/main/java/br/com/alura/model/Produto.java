package br.com.alura.model;

/*
    A API de Persistência do Java (JPA - Java Persistence API) é uma especificação de como
    o Mapeamento Objeto-Relacional (ORM - Object-Relational Mapping) deve ser implementado na
    plataforma JavaEE.

*   ORM é um conceito geral
*   JPA define um padrão de ORM, ou seja, como isso deve funcionar em Java na prática
*   Hibernate, EclipseLink, Toplink, OpenJPA são implementações do padrão JPA

ref: https://pt.stackoverflow.com/questions/101200/qual-a-rela%C3%A7%C3%A3o-entre-jpa-e-orm#:~:text=Resumo%3A%20JPA%20%C3%A9%20uma%20especifica%C3%A7%C3%A3o,o%20Hibernate%20ou%20o%20EclipseLink.
* */

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


// Mapeamento de entidade para uma tabela no banco de dados

@Entity
@Table(name = "produtos")
public class Produto {

    @Id // Precisamos expecificar qual vai ser a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Precisamos informar que a propriedade ID vai ser gerada pelo próprio banco de dados
    private Long id;
    private String nome;

    @Column(name = "descricao") // Quando a coluna tiver um nome diferente da propriedade usa
    private String descricao;
    private BigDecimal preco;
    private LocalDate data = LocalDate.now();
    @Enumerated(EnumType.STRING) // Quando trabalhamos com ENUM precisamos informar que queremos a string e não o index do enum
    private Categoria categoria;

    public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
