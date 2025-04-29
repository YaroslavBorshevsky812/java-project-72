package gg.jte.generated.ondemand.urls.url;
import hexlet.code.utils.NamedRoutes;
import hexlet.code.dto.UrlPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/url/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,17,17,17,23,23,23,27,27,27,31,31,31,37,37,37,37,51,51,53,53,56,56,56,59,59,59,62,62,62,65,65,65,68,68,68,71,71,71,74,74,76,76,83,83,83,86,86,86,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n                <main class=\"flex-grow-1\">\n\n                        <div class=\"rounded-0 m-0 alert alert-dismissible fade show alert-success\" role=\"alert\">\n                            <p class=\"m-0\">Страница успешно проверена</p>\n                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n                        </div>\n\n                    <section>\n\n                <div class=\"container-lg mt-5\">\n                    <h1>Сайт: ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</h1>\n\n                    <table class=\"table table-bordered table-hover mt-3\">\n                        <tbody>\n                        <tr>\n                            <td>ID</td>\n                            <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("</td>\n                        </tr>\n                        <tr>\n                            <td>Имя</td>\n                            <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</td>\n                        </tr>\n                        <tr>\n                            <td>Дата создания</td>\n                            <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getFormattedCreatedAt());
				jteOutput.writeContent("</td>\n                        </tr>\n                        </tbody>\n                    </table>\n\n                    <h2 class=\"mt-5\">Проверки</h2>\n                    <form method=\"post\" action=\"/urls/");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.setContext("form", null);
				jteOutput.writeContent("/checks\">\n                        <button type=\"submit\" class=\"btn btn-primary\">Запустить проверку</button>\n                    </form>\n\n                    <table class=\"table table-bordered table-hover mt-3\">\n                        <thead>\n                            <th class=\"col-1\">ID</th>\n                            <th class=\"col-1\">Код ответа</th>\n                            <th>title</th>\n                            <th>h1</th>\n                            <th>description</th>\n                            <th class=\"col-2\">Дата проверки</th>\n                        </thead>\n\n                        ");
				if (page.getUrlChecks() != null && !page.getUrlChecks().isEmpty()) {
					jteOutput.writeContent("\n                            <tbody>\n                                ");
					for (var item : page.getUrlChecks()) {
						jteOutput.writeContent("\n                                <tr>\n                                    <td>\n                                        ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(item.getId());
						jteOutput.writeContent("\n                                    </td>\n                                    <td>\n                                        ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(item.getStatusCode());
						jteOutput.writeContent("\n                                    </td>\n                                    <td>\n                                        ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(item.getTitle());
						jteOutput.writeContent("\n                                    </td>\n                                    <td>\n                                        ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(item.getH1());
						jteOutput.writeContent("\n                                    </td>\n                                    <td>\n                                        ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(item.getDescription());
						jteOutput.writeContent("\n                                    </td>\n                                    <td>\n                                        ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(item.getFormattedCreatedAt());
						jteOutput.writeContent("\n                                    </td>\n                                </tr>\n                                ");
					}
					jteOutput.writeContent("\n                            </tbody>\n                        ");
				}
				jteOutput.writeContent("\n\n                    </table>\n                </div>\n\n                    </section>\n                </main>\n    ");
			}
		});
		jteOutput.writeContent("\n\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
