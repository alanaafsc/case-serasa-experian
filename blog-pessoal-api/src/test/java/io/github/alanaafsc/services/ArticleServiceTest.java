package io.github.alanaafsc.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.github.alanaafsc.persistence.dao.ArticleDao;
import io.github.alanaafsc.persistence.models.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ArticleServiceTest {

    @InjectMocks
    ArticleService articleService;

    @Mock
    ArticleDao articleDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInserirArtigo() {
        Article article = new Article();
        when(articleDao.inserirArtigo(article)).thenReturn(1);

        int result = articleService.inserirArtigo(article);

        assertEquals(1, result);
        verify(articleDao, times(1)).inserirArtigo(article);
    }

    @Test
    public void testAtualizarArtigo() {
        long id = 1;
        Article article = new Article();
        article.setId(id);
        when(articleDao.atualizarArtigo(article)).thenReturn(1);

        int result = articleService.atualizarArtigo(id, article);

        assertEquals(1, result);
        verify(articleDao, times(1)).atualizarArtigo(article);
    }

    @Test
    public void testExcluirArtigo() {
        long id = 1;
        when(articleDao.excluirArtigo(id)).thenReturn(1);

        int result = articleService.excluirArtigo(id);

        assertEquals(1, result);
        verify(articleDao, times(1)).excluirArtigo(id);
    }
}

