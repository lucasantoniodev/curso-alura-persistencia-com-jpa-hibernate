package br.com.alura.testes;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.model.Categoria;
import br.com.alura.model.Produto;
import br.com.alura.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManger();
        em.getTransaction().begin(); // Preparar/Iniciar a transação
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto(
                "Xiami Redmi",
                "Muito legal",
                new BigDecimal("800"),
                celulares
        );

        // https://prnt.sc/6cz7vCwKNRLL
        //  new class  -> persist() -> commit ou flush()
        // -> Transient -> Managed -> BD
        //                  |    close ou clear()
        //                  |-> Detached

        em.persist(celulares); // Coloca uma entidade no estado Managed
        celulares.setNome("XPTO"); // Atualizando a entidade

        em.flush(); // Enviando para o banco de dados
        em.clear(); // Movendo o estado da entidade para Detached

        celulares = em.merge(celulares); // Este método cria uma nova referência da entidade que estava em Detached, ele não altera o estado delas
        celulares.setNome("123");
        em.flush();
        categoriaDao.remover(celulares);
        em.flush();
//        categoriaDao.cadastrar(celulares); // salva a operação
//        produtoDao.cadastrar(celular); // Salva a operação
//        em.getTransaction().commit(); // Comita e executa as operações

        em.close(); // Finaliza a instancia do EM
    }
}
