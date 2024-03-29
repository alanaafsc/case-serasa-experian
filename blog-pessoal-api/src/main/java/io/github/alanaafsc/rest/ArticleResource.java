package io.github.alanaafsc.rest;

import io.github.alanaafsc.persistence.dao.ArticleDao;
import io.github.alanaafsc.persistence.dto.ArticleDTO;
import io.github.alanaafsc.persistence.dto.AutoresRequestDTO;
import io.github.alanaafsc.persistence.models.Article;
import io.github.alanaafsc.services.ArticleService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.security.InvalidParameterException;
import java.util.List;

@RequestScoped
@Path("/v1/artigos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArticleResource {

    @Inject
    ArticleService service;

    @Inject
    ArticleDao dao;

    @GET
    @Operation(summary = "Listar artigos ",
            description = "Retorna uma lista de artigos")
    @APIResponse(
            responseCode = "200",
            description = "Artigo",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Article.class, type = SchemaType.ARRAY))})
    public Response obtemArtigos() throws Exception  {
        return Response.status(Response.Status.OK).entity(dao.buscarListaArtigos()).build();
    }

    @GET
    @Path("/recentes")
    @Operation(summary = "Listar artigos recentes",
            description = "Retorna uma lista de artigos recentes")
    @APIResponse(
            responseCode = "200",
            description = "Artigo",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Article.class, type = SchemaType.ARRAY))})
    public Response obtemArtigosRecentes() throws Exception  {
        return Response.status(Response.Status.OK).entity(dao.buscarListaArtigosRecentes()).build();
    }

    @GET
    @Path("/autores")
    @Operation(summary = "Listar artigos por autores",
            description = "Retorna uma lista de artigos por autores")
    @APIResponse(
            responseCode = "200",
            description = "Artigo",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Article.class, type = SchemaType.ARRAY))})
    public Response obtemArtigosPorAutores(@QueryParam("autores") List<String> authorNames) {
        List<ArticleDTO> articles = dao.buscarArtigosPorAutores(authorNames);
        return Response.ok(articles).build();
    }

    @GET
    @Path("/order/{order}")
    @Operation(summary = "Listar artigos por data",
            description = "Retorna uma lista de artigos por data")
    @APIResponse(
            responseCode = "200",
            description = "Artigo",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Article.class, type = SchemaType.ARRAY))})
    public Response obtemArtigosPorData(final @PathParam("order") String order) throws Exception  {
        try {
            return Response.status(Response.Status.OK).entity(dao.buscarListaArtigosPorData(order)).build();
        } catch (InvalidParameterException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Parâmetro de ordem inválido: " + order).build();
        }
    }

    @POST
    @Path("/add")
    @Operation(summary = "Incluir um artigo.",
            description = "Incluir um artigo")
    @APIResponse(
            responseCode = "201",
            description = "Artigo",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Article.class))})
    public Response inserirArtigo(ArticleDTO article) {
        Article newArticle = new Article();
        newArticle.setAuthor(article.getAuthor());
        newArticle.setContent(article.getContent());
        newArticle.setTitle(article.getTitle());
        newArticle.setPublicationDate(article.getPublicationDate());

        return  Response.status(Response.Status.CREATED).entity(service.inserirArtigo(newArticle)).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Remove um artigo",
            description = "Remove um artigo pelo ID informado")
    @APIResponse(
            responseCode = "200",
            description = "Artigo",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Article.class))})
    public Response excluirArtigo(final @PathParam("id") long id) {
        return  Response.status(Response.Status.OK).entity(service.excluirArtigo(id)).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualizar um artigo",
            description = "Atualização de um artigo")
    @APIResponse(
            responseCode = "200",
            description = "Artigo",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Article.class))})
    public Response atualizar(final @PathParam("id") long id, ArticleDTO article) {
        Article newArticle = new Article();
        newArticle.setAuthor(article.getAuthor());
        newArticle.setContent(article.getContent());
        newArticle.setTitle(article.getTitle());
        newArticle.setPublicationDate(article.getPublicationDate());
        return  Response.status(Response.Status.OK).entity(service.atualizarArtigo(id, newArticle)).build();
    }
}
