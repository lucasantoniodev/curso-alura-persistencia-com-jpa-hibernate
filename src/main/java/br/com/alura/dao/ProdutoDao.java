package br.com.alura.dao;

// Mesmo exemplo de como o JDBC trabalha, porém ao invés de trabalhar
// com conexões, aqui vamos trabalhar com o entityManager

import br.com.alura.model.Produto;

import javax.persistence.EntityManager;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto){
        this.em.persist(produto);
    }
}
