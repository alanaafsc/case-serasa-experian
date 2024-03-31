package io.github.alanaafsc.services;

import io.github.alanaafsc.persistence.dao.ArticleDao;
import io.github.alanaafsc.persistence.models.Article;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class ArticleService {

    @Inject
    ArticleDao dao;

    @Transactional(rollbackOn = Exception.class)
    public int inserirArtigo(Article article) {
        return dao.inserirArtigo(article);
    }

    @Transactional(rollbackOn = Exception.class)
    public int atualizarArtigo(long id, Article article) {
        article.setId(id);
        return dao.atualizarArtigo(article);
    }

    @Transactional(rollbackOn = Exception.class)
    public int excluirArtigo(Long id)  {
        return dao.excluirArtigo(id);
    }

}
