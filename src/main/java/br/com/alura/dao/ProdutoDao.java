package br.com.alura.dao;

// Mesmo exemplo de como o JDBC trabalha, porém ao invés de trabalhar
// com conexões, aqui vamos trabalhar com o entityManager

import br.com.alura.model.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public Produto buscarPorId(Long id) {
        return this.em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return this.em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String name) {
//        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
//        return this.em.createQuery(jpql, Produto.class).setParameter("nome", name).getResultList();
        String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
        return this.em.createQuery(jpql, Produto.class).setParameter(1, name).getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        return this.em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
    }

    public BigDecimal buscarPrecoDoProdutoPorNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto as p WHERE p.nome = :nome";
        return this.em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getResultList().stream().findFirst().orElse(null);
    }
}
