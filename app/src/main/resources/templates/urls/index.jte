@import hexlet.code.utils.NamedRoutes
@import hexlet.code.dto.UrlsPage
@param UrlsPage page

@template.layout.page(
    content = @`
        <main class="flex-grow-1">
            <section>
                <div class="container-lg mt-5">
                    <h1>Сайты</h1>

                    <table class="table table-bordered table-hover mt-3">
                        <thead>
                            <tr>
                                <th class="col-1">ID</th>
                                <th>Имя</th>
                                <th class="col-2">Последняя проверка</th>
                                <th class="col-1">Код ответа</th>
                            </tr>
                        </thead>
                        
                        @if (page.getUrls() != null && !page.getUrls().isEmpty())
                            <tbody>
                                @for (var item : page.getUrls())
                                    <tr>
                                        <td>${item.getId()}</td>
                                        <td>
                                            <a href="${NamedRoutes.urlPath(item.getId())}">${item.getName()}</a>
                                        </td>
                                        <td>
                                            <%-- ${item.getCreatedAt() != null ? item.getCreatedAt() : ""} --%>
                                        </td>
                                        <td>
                                            <%-- ${item.getStatusCode() != null ? item.getStatusCode() : ""} --%>
                                        </td>
                                    </tr>
                                @endfor
                            </tbody>
                        @endif
                    </table>
                </div>
            </section>
        </main>
    `
)