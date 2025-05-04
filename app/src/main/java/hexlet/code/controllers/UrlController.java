package hexlet.code.controllers;

import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.repository.UrlRepository;
import hexlet.code.utils.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;

import java.net.URI;
import java.net.URL;
import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlController {

    public static void showUrlListPage(Context ctx) throws SQLException  {
        var urlList = UrlRepository.findAll();
        var page = new UrlsPage(urlList);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flash-type"));
        ctx.render("urls/index.jte", model("page", page));
    }

    public static void create(Context ctx) throws SQLException {
        try {
            var inputUrl = ctx.formParamAsClass("url", String.class).get();
            String normalizedUrl;

            try {
                URI uri = new URI(inputUrl);
                URL url = uri.toURL();
                int port = url.getPort();
                normalizedUrl = url.getProtocol() + "://" + url.getHost() +
                    (port != -1 ? ":" + port : "");

                if (url.getHost() == null || url.getHost().isEmpty()) {
                    ctx.sessionAttribute("flash", "Некорректный URL");
                    ctx.sessionAttribute("flash-type", "success");
                    ctx.redirect(NamedRoutes.rootPath());
                    return;
                }
            } catch (Exception e) {
                ctx.sessionAttribute("flash", "Некорректный URL");
                ctx.redirect(NamedRoutes.rootPath());
                return;
            }

            try {
                UrlRepository.create(normalizedUrl);
                ctx.sessionAttribute("flash", "Страница успешно добавлена");
                ctx.sessionAttribute("flash-type", "success");
            } catch (IllegalArgumentException e) {
                ctx.sessionAttribute("flash", "Страница уже существует");
                ctx.sessionAttribute("flash-type", "danger");
            }

            ctx.redirect(NamedRoutes.urlsPath());

        } catch (ValidationException e) {
            ctx.sessionAttribute("flash", "Некорректный URL");
            ctx.sessionAttribute("flash-type", "danger");
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
