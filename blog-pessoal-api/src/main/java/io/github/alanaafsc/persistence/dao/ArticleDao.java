package io.github.alanaafsc.persistence.dao;

import io.github.alanaafsc.persistence.dto.ArticleDTO;
import io.github.alanaafsc.persistence.dto.LatestArticlesDTO;
import io.github.alanaafsc.persistence.models.Article;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;

@RequestScoped
public class ArticleDao {

    EntityManager em;

    public ArticleDao(EntityManager em){
        this.em = em;
    }

    public List<ArticleDTO> buscarListaArtigos(){
        TypedQuery<ArticleDTO> query = em.createNamedQuery("CONSULTAR_LISTA_ARTIGOS", ArticleDTO.class);
        return query.getResultList();
    }

    public List<ArticleDTO> buscarListaArtigosPorAutor(List<String> authors){
        TypedQuery<ArticleDTO> query = em
                .createNamedQuery("CONSULTAR_LISTA_ARTIGOS_POR_AUTOR", ArticleDTO.class);
        query.setParameter("authors", authors);
        return query.getResultList();
    }

    public List<ArticleDTO> buscarListaArtigosPorData(String order){
        TypedQuery<ArticleDTO> query = em
                .createNamedQuery("CONSULTAR_LISTA_ARTIGOS_POR_DATA", ArticleDTO.class);
        query.setParameter("order", order);
        return query.getResultList();
    }

    public List<LatestArticlesDTO> buscarListaArtigosRecentes(){
        TypedQuery<LatestArticlesDTO> query = em.createNamedQuery("CONSULTAR_LISTA_ARTIGOS_RECENTES", LatestArticlesDTO.class);
        return query.getResultList();
    }

    public List<Article> consultarArtigos() {
        TypedQuery<Article> query = em.createNamedQuery("CONSULTAR_ARTIGO", Article.class);
        return query.getResultList();
    }

    public Article consultarArtigoPorId(long idArtigo) {
        TypedQuery<Article> query = em.createNamedQuery("CONSULTAR_ARTIGO_POR_ID", Article.class);
        query.setParameter("idArtigo", idArtigo);
        return query.getSingleResult();
    }

    public int inserirArtigo(Article artigo) {
        String nameQuery = "INSERIR_ARTIGO";
        return insertOrUpdate(artigo, nameQuery);
    }

    public int atualizarArtigo(Article artigo) {
        String nameQuery = "ATUALIZAR_ARTIGO";
        return insertOrUpdate(artigo, nameQuery);
    }

    public int excluirArtigo(long idArtigo) {
        String nameQuery = "EXCLUIR_ARTIGO";

        Query query = em
                .createNamedQuery(nameQuery);

        query.setParameter("id", idArtigo);
        return query.executeUpdate();
    }

    @Transactional
    private int insertOrUpdate(Article article, String nameQuery) {
        Query query = em
                .createNamedQuery(nameQuery);

        query.setParameter("id", article.getId());
        query.setParameter("author", article.getAuthor());
        query.setParameter("content", article.getContent());
        query.setParameter("title", article.getTitle());
        query.setParameter("publicationDate", article.getPublicationDate());

        try {
            return query.executeUpdate();
        } catch (NoResultException e) {
            return 0;
        } catch (PersistenceException e) {
            throw new Error();
        }
    }
}
