@import hexlet.code.utils.NamedRoutes
@import hexlet.code.dto.urls.UrlPage
@param UrlPage page

@template.layout.page(
    content = @`
                <main class="flex-grow-1">

        @if(page != null && page.getFlash() != null)
            <div class="rounded-0 m-0 alert alert-dismissible fade show alert-${page.getFlashType()}" role="alert">
                <p class="m-0">${page.getFlash()}</p>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        @endif

                    <section>

                <div class="container-lg mt-5">
                    <h1>Сайт: ${page.getUrl().getName()}</h1>

                    <table class="table table-bordered table-hover mt-3">
                        <tbody>
                        <tr>
                            <td>ID</td>
                            <td>${page.getUrl().getId()}</td>
                        </tr>
                        <tr>
                            <td>Имя</td>
                            <td>${page.getUrl().getName()}</td>
                        </tr>
                        <tr>
                            <td>Дата создания</td>
                            <td>${page.getUrl().getFormattedCreatedAt()}</td>
                        </tr>
                        </tbody>
                    </table>

                    <h2 class="mt-5">Проверки</h2>
                    <form method="post" action="/urls/${page.getUrl().getId()}/checks">
                        <button type="submit" class="btn btn-primary">Запустить проверку</button>
                    </form>

                    <table class="table table-bordered table-hover mt-3">
                        <thead>
                            <th class="col-1">ID</th>
                            <th class="col-1">Код ответа</th>
                            <th>title</th>
                            <th>h1</th>
                            <th>description</th>
                            <th class="col-2">Дата проверки</th>
                        </thead>

                        @if (page.getUrlChecks() != null && !page.getUrlChecks().isEmpty())
                            <tbody>
                                @for (var item : page.getUrlChecks())
                                <tr>
                                    <td>
                                        ${item.getId()}
                                    </td>
                                    <td>
                                        ${item.getStatusCode()}
                                    </td>
                                    <td>
                                        ${item.getTitle()}
                                    </td>
                                    <td>
                                        ${item.getH1()}
                                    </td>
                                    <td>
                                        ${item.getDescription()}
                                    </td>
                                    <td>
                                        ${item.getFormattedCreatedAt()}
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


