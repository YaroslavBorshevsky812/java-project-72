package hexlet.code.controllers;


import hexlet.code.dto.UrlsPage;
import hexlet.code.repository.UrlRepository;
import hexlet.code.utils.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;

import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlController {

    public static void showUrlListPage(Context ctx) throws SQLException  {
        var urlList = UrlRepository.findAll();
        var page = new UrlsPage(urlList);

        ctx.render("urls/index.jte", model("page", page));
    }

    public static void create(Context ctx) throws SQLException {

        try {
            var name = ctx.formParamAsClass("url", String.class).get();

            UrlRepository.create(name);
            ctx.redirect(NamedRoutes.urlsPath());

        } catch (ValidationException e) {
            ctx.redirect(NamedRoutes.rootPath());
        }
    }

    public static void showUrlItemPage(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        // Тут запрашиваем через join, но вопрос можно ли из репа сразу в dto собирать.
        // Возможно реп должен всё таки модель возвращать.
        var page = UrlRepository.findWithChecks(id)
                                 .orElseThrow(() -> new NotFoundResponse("Url not found"));

        ctx.render("urls/url/index.jte", model("page", page));
    }


}
