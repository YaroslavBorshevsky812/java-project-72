package hexlet.code.utils;

import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.time.LocalDateTime;

public class SiteChecker {

    public static UrlCheck checkUrl(Url url) throws RuntimeException {
        HttpResponse<String> response = Unirest.get(url.getName())
                                               .connectTimeout(10000)
                                               .asString();

        Document doc = Jsoup.parse(response.getBody());

        return new UrlCheck(
            null,
            response.getStatus(),
            extractTitle(doc),
            extractH1(doc),
            extractMetaDescription(doc),
            url.getId(),
            LocalDateTime.now()
        );
    }

    private static String extractTitle(Document doc) {
        Elements titles = doc.getElementsByTag("title");
        return titles.isEmpty() ? "" : titles.first().text();
    }

    private static String extractH1(Document doc) {
        Elements h1s = doc.getElementsByTag("h1");
        return h1s.isEmpty() ? "" : h1s.first().text();
    }

    private static String extractMetaDescription(Document doc) {
        Elements metas = doc.select("meta[name=description]");
        return metas.isEmpty() ? "" : metas.first().attr("content");
    }
}
