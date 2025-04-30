package hexlet.code.controllers;

import hexlet.code.repository.UrlCheckRepository;
import hexlet.code.utils.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

import java.sql.SQLException;

public class UrlCheckController {

    public static void create(Context ctx) throws SQLException {

        try {
            var id = ctx.pathParamAsClass("id", Long.class).get();

            UrlCheckRepository.create(id);
            ctx.redirect(NamedRoutes.urlPath(id));

        } catch (ValidationException e) {
            ctx.redirect(NamedRoutes.rootPath());
        }
    }
}
