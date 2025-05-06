@import hexlet.code.utils.NamedRoutes
@import hexlet.code.dto.urls.UrlsPage
@param UrlsPage page

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
                                            @if (item.getLastCheck() != null && item.getLastCheck().getCreatedAt() != null)
                                                ${item.getLastCheck().getFormattedCreatedAt()}
                                            @endif
                                        </td>
                                        <td>
                                            @if (item.getLastCheck() != null)
                                                ${item.getLastCheck().getStatusCode()}
                                            @endif
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