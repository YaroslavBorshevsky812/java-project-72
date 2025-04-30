package hexlet.code.repository;

import hexlet.code.model.UrlCheck;
import hexlet.code.utils.SiteChecker;
import io.javalin.http.NotFoundResponse;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class UrlCheckRepository extends BaseRepository {

    public static UrlCheck create(Long urlId) throws SQLException {
        var sql = "INSERT INTO url_checks (status_code, title, h1, description, url_id)\n"
            + "VALUES (?, ?, ?, ?, ?);";

        var url = UrlRepository.find(urlId)
                               .orElseThrow(() -> new NotFoundResponse("Url not found"));

        var check = SiteChecker.checkUrl(url);

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, check.getStatusCode());
            stmt.setString(2, check.getTitle());
            stmt.setString(3, check.getH1());
            stmt.setString(4, check.getDescription());
            stmt.setLong(5, url.getId());
            stmt.executeUpdate();

            try (var generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    return find(id).orElseThrow();
                }
                throw new SQLException("DB have not returned an id after saving the entity");
            }
        }
    }

    public static Optional<UrlCheck> find(long id) throws SQLException {
        var sql = "SELECT * FROM url_checks WHERE id = ?";

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new UrlCheck(
                        rs.getLong("id"),
                        rs.getInt("status_code"),
                        rs.getString("title"),
                        rs.getString("h1"),
                        rs.getString("description"),
                        rs.getLong("url_id"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                    ));
                }
                return Optional.empty();
            }
        }
    }
}
