package br.com.alura.testes;

import br.com.alura.dao.ProdutoDao;
import br.com.alura.model.Produto;
import br.com.alura.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiami Redmi");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal("800"));

        EntityManager em = JPAUtil.getEntityManger();
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin(); // Preparar/Iniciar a transação
        dao.cadastrar(celular); // Salva a operação
        em.getTransaction().commit(); // Comita a transação

        em.close();
    }
}
