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
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto(
                "Xiami Redmi",
                "Muito legal",
                new BigDecimal("800"),
                celulares
        );

        //  new class  -> persist() -> commit ou flush()
        // -> Transient -> Managed -> BD
        //                  |    close ou clear()
        //                  |-> Detached

        em.getTransaction().begin(); // Preparar/Iniciar a transação
        categoriaDao.cadastrar(celulares); // salva a operação
        produtoDao.cadastrar(celular); // Salva a operação
        em.getTransaction().commit(); // Comita e executa as operações

        em.close(); // Finaliza a instancia do EM
    }
}
