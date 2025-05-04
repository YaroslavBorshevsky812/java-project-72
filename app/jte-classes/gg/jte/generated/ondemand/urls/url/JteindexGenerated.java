package gg.jte.generated.ondemand.urls.url;
import hexlet.code.utils.NamedRoutes;
import hexlet.code.dto.urls.UrlPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/url/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,9,9,10,10,10,10,11,11,11,14,14,19,19,19,25,25,25,29,29,29,33,33,33,39,39,39,39,53,53,55,55,58,58,58,61,61,61,64,64,64,67,67,67,70,70,70,73,73,73,76,76,78,78,85,85,85,88,88,88,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n                <main class=\"flex-grow-1\">\n\n        ");
				if (page != null && page.getFlash() != null) {
					jteOutput.writeContent("\n            <div class=\"rounded-0 m-0 alert alert-dismissible fade show alert-");
					jteOutput.setContext("div", "class");
					jteOutput.writeUserContent(page.getFlashType());
					jteOutput.setContext("div", null);
					jteOutput.writeContent("\" role=\"alert\">\n                <p class=\"m-0\">");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(page.getFlash());
					jteOutput.writeContent("</p>\n                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n            </div>\n        ");
				}
				jteOutput.writeContent("\n\n                    <section>\n\n                <div class=\"container-lg mt-5\">\n                    <h1>Сайт: ");
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
