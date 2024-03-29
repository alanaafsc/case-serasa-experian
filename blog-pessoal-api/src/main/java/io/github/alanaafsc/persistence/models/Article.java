package io.github.alanaafsc.persistence.models;

import io.github.alanaafsc.persistence.dto.ArticleDTO;
import io.github.alanaafsc.persistence.dto.LatestArticlesDTO;
import jakarta.persistence.*;

import java.util.Date;


@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "ArticleMapping",
                classes = @ConstructorResult(
                        targetClass = ArticleDTO.class,
                        columns = {
                                @ColumnResult(name = "title", type = String.class),
                                @ColumnResult(name = "content", type = String.class),
                                @ColumnResult(name = "author", type = String.class),
                                @ColumnResult(name = "publicationDate", type = Date.class)
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "LatestArticlesMapping",
                classes = @ConstructorResult(
                        targetClass = LatestArticlesDTO.class,
                        columns = {
                                @ColumnResult(name = "title", type = String.class),
                                @ColumnResult(name = "publicationDate", type = Date.class)
                        }
                )
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name="CONSULTAR_LISTA_ARTIGOS",
                query = "SELECT title, content, author, publicationDate FROM articles.Article;",
                resultSetMapping = "ArticleMapping"
        ),
        @NamedNativeQuery(
                name="CONSULTAR_LISTA_ARTIGOS_POR_AUTOR",
                query = "SELECT title, content, author, publicationDate FROM articles.Article WHERE author IN :authors",
                resultSetMapping = "ArticleMapping"
        ),
        @NamedNativeQuery(
                name="CONSULTAR_LISTA_ARTIGOS_POR_DATA",
                query = "SELECT title, content, author, publicationDate " +
                        "FROM articles.Article " +
                        "ORDER BY publicationDate :order",
                resultSetMapping = "ArticleMapping"
        ),
        @NamedNativeQuery(
                name="CONSULTAR_LISTA_ARTIGOS_RECENTES",
                query = "SELECT title, publicationDate " +
                        "FROM articles.Article " +
                        "ORDER BY publicationDate DESC;",
                resultSetMapping = "LatestArticlesMapping"
        ),
        @NamedNativeQuery(
                name="CONSULTAR_ARTIGO",
                query = "SELECT id, title, content, author, publicationDate FROM articles.Article",
                resultSetMapping = "ArticleMapping"
        ),
        @NamedNativeQuery(
                name="CONSULTAR_ARTIGO_POR_ID",
                query = "SELECT id, title, content, author, publicationDate FROM articles.Article WHERE id = :idArtigo",
                resultSetMapping = "ArticleMapping"
        ),
        @NamedNativeQuery(
                name="INSERIR_ARTIGO",
                query = "INSERT INTO articles.Article (id, title, content, author, publicationDate) VALUES (:id, :title, :content, :author, :publicationDate)"
        ),
        @NamedNativeQuery(
                name="ATUALIZAR_ARTIGO",
                query = "UPDATE articles.Article SET title = :title, content = :content, author = :author, publicationDate = :publicationDate WHERE id = :id"
        ),
        @NamedNativeQuery(
                name="EXCLUIR_ARTIGO",
                query = "DELETE FROM articles.Article WHERE id = :id"
        )
})
@Entity
@Table(name="Article", schema="articles")
public class Article {

    public Article(long id, String title, String content, String author, Date publicationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public Article() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String content;

    private String author;

    private java.util.Date publicationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
