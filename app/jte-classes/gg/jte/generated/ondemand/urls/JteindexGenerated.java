package gg.jte.generated.ondemand.urls;
import hexlet.code.utils.NamedRoutes;
import hexlet.code.dto.urls.UrlsPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,9,9,10,10,10,10,11,11,11,14,14,30,30,32,32,34,34,34,36,36,36,36,36,36,36,36,36,36,36,36,39,39,40,40,40,41,41,44,44,45,45,45,46,46,49,49,51,51,56,56,56,56,56,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <main class=\"flex-grow-1\">\n\n            ");
				if (page != null && page.getFlash() != null) {
					jteOutput.writeContent("\n                <div class=\"rounded-0 m-0 alert alert-dismissible fade show alert-");
					jteOutput.setContext("div", "class");
					jteOutput.writeUserContent(page.getFlashType());
					jteOutput.setContext("div", null);
					jteOutput.writeContent("\" role=\"alert\">\n                    <p class=\"m-0\">");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(page.getFlash());
					jteOutput.writeContent("</p>\n                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n                </div>\n            ");
				}
				jteOutput.writeContent("\n\n            <section>\n                <div class=\"container-lg mt-5\">\n                    <h1>Сайты</h1>\n\n                    <table class=\"table table-bordered table-hover mt-3\">\n                        <thead>\n                            <tr>\n                                <th class=\"col-1\">ID</th>\n                                <th>Имя</th>\n                                <th class=\"col-2\">Последняя проверка</th>\n                                <th class=\"col-1\">Код ответа</th>\n                            </tr>\n                        </thead>\n                        \n                        ");
				if (page.getUrls() != null && !page.getUrls().isEmpty()) {
					jteOutput.writeContent("\n                            <tbody>\n                                ");
					for (var item : page.getUrls()) {
						jteOutput.writeContent("\n                                    <tr>\n                                        <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(item.getId());
						jteOutput.writeContent("</td>\n                                        <td>\n                                            <a");
						var __jte_html_attribute_0 = NamedRoutes.urlPath(item.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_0);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(item.getName());
						jteOutput.writeContent("</a>\n                                        </td>\n                                        <td>\n                                            ");
						if (item.getLastCheck() != null && item.getLastCheck().getCreatedAt() != null) {
							jteOutput.writeContent("\n                                                ");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(item.getLastCheck().getFormattedCreatedAt());
							jteOutput.writeContent("\n                                            ");
						}
						jteOutput.writeContent("\n                                        </td>\n                                        <td>\n                                            ");
						if (item.getLastCheck() != null) {
							jteOutput.writeContent("\n                                                ");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(item.getLastCheck().getStatusCode());
							jteOutput.writeContent("\n                                            ");
						}
						jteOutput.writeContent("\n                                        </td>\n                                    </tr>\n                                ");
					}
					jteOutput.writeContent("\n                            </tbody>\n                        ");
				}
				jteOutput.writeContent("\n                    </table>\n                </div>\n            </section>\n        </main>\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
