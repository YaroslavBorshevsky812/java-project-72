package gg.jte.generated.ondemand.urls;
import hexlet.code.utils.NamedRoutes;
import hexlet.code.dto.UrlsPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,22,22,24,24,26,26,26,28,28,28,28,28,28,28,28,28,28,28,28,31,34,37,37,39,39,44,44,44,44,44,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <main class=\"flex-grow-1\">\n            <section>\n                <div class=\"container-lg mt-5\">\n                    <h1>Сайты</h1>\n\n                    <table class=\"table table-bordered table-hover mt-3\">\n                        <thead>\n                            <tr>\n                                <th class=\"col-1\">ID</th>\n                                <th>Имя</th>\n                                <th class=\"col-2\">Последняя проверка</th>\n                                <th class=\"col-1\">Код ответа</th>\n                            </tr>\n                        </thead>\n                        \n                        ");
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
						jteOutput.writeContent("\n                                        </td>\n                                        <td>\n                                            ");
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
