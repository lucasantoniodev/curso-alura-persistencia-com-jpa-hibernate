package br.com.alura.dao;

// Mesmo exemplo de como o JDBC trabalha, porém ao invés de trabalhar
// com conexões, aqui vamos trabalhar com o entityManager

import br.com.alura.model.Categoria;
import br.com.alura.model.Produto;

import javax.persistence.EntityManager;

public class CategoriaDao {
    private final EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria){
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.em.merge(categoria);
    }

    public  void remover(Categoria categoria) {
        categoria = em.merge(categoria);
        this.em.remove(categoria);
    }
}
