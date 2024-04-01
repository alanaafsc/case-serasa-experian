package io.github.alanaafsc.rest;

import io.github.alanaafsc.persistence.dao.ArticleDao;
import io.github.alanaafsc.persistence.dto.ArticleDTO;
import io.github.alanaafsc.persistence.models.Article;
import io.github.alanaafsc.services.ArticleService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@QuarkusTest
public class ArticleResourceTest {

    @Mock
    ArticleDao articleDao;

    @Mock
    ArticleService articleService;

    @InjectMocks
    ArticleResource articleResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testObtemArtigos() throws Exception {
        List<ArticleDTO> articles = new ArrayList<>();
        when(articleDao.buscarListaArtigos()).thenReturn(articles);

        Response response = articleResource.obtemArtigos();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    void testInserirArtigo() {
        ArticleDTO articleDTO = new ArticleDTO();
        Article article = new Article();
        when(articleService.inserirArtigo(article)).thenReturn(1);

        Response response = articleResource.inserirArtigo(articleDTO);

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    void testExcluirArtigo() {
        long id = 1L;
        when(articleService.excluirArtigo(id)).thenReturn(1);

        Response response = articleResource.excluirArtigo(id);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    void testAtualizar() {
        long id = 1L;
        ArticleDTO articleDTO = new ArticleDTO();
        Article article = new Article();
        when(articleService.atualizarArtigo(id, article)).thenReturn(1);

        Response response = articleResource.atualizar(id, articleDTO);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
}
