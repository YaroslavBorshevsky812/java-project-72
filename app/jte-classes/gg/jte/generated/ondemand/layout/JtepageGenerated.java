package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,29,29,29,29,31,31,31,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content) {
		jteOutput.writeContent("\n<html lang=\"en\">\n  <head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"\n            rel=\"stylesheet\"\n            integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"\n            crossorigin=\"anonymous\">\n    <title>Hello Hexlet!</title>\n    </head>\n    <body class=\"d-flex flex-column min-vh-100\">\n    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n                <div class=\"container-fluid\">\n                    <a class=\"navbar-brand\" href=\"/\">Анализатор страниц</a>\n                    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\"\n                            aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n                        <span class=\"navbar-toggler-icon\"></span>\n                    </button>\n                    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n                        <div class=\"navbar-nav\">\n                            <a class=\"nav-link\" href=\"/\">Главная</a>\n                            <a class=\"nav-link\" href=\"/urls\">Сайты</a>\n                        </div>\n                    </div>\n                </div>\n            </nav>\n        ");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n    </body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, content);
	}
}
