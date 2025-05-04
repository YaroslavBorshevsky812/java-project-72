package hexlet.code.repository;

import hexlet.code.dto.urls.UrlPage;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UrlRepository extends BaseRepository {

    public static List<Url> findAll() throws SQLException {
        var sql = "SELECT * FROM urls";
        var urls = new ArrayList<Url>();

        try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(sql);
             var resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

                var url = new Url(id, name, createdAt);
                urls.add(url);
            }
        }
        return urls;
    }

    public static Optional<Url> find(Long id) throws SQLException {
        var sql = "SELECT * FROM urls WHERE id = ?";
        try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var name = resultSet.getString("name");
                var createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

                var url = new Url(id, name, createdAt);
                return Optional.of(url);
            }
            return Optional.empty();
        }
    }

    public static Url create(String name) throws SQLException {
        var sql = "INSERT INTO urls (name) VALUES (?)";

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
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

    public static boolean existsByName(String name) throws SQLException {
        var sql = "SELECT COUNT(*) FROM urls WHERE name = ?";
        try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            var rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    public static Optional<UrlPage> findWithChecks(Long id) throws SQLException {
        var sql = "SELECT u.*, uc.id as check_id, uc.status_code, uc.title, "
            + "uc.h1, uc.description, uc.created_at as check_created_at "
            + "FROM urls u "
            + "LEFT JOIN url_checks uc ON u.id = uc.url_id "
            + "WHERE u.id = ? "
            + "ORDER BY uc.created_at DESC";

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            var rs = stmt.executeQuery();

            if (!rs.next()) {
                return Optional.empty();
            }

            var url = new Url(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getTimestamp("created_at").toLocalDateTime()
            );

            var checks = new ArrayList<UrlCheck>();
            do {
                if (rs.getObject("check_id") != null) {
                    checks.add(new UrlCheck(
                        rs.getLong("check_id"),
                        rs.getInt("status_code"),
                        rs.getString("title"),
                        rs.getString("h1"),
                        rs.getString("description"),
                        rs.getLong("id"),
                        rs.getTimestamp("check_created_at").toLocalDateTime()
                    ));
                }
            } while (rs.next());

            return Optional.of(new UrlPage(url, checks));
        }
    }

    public static void removeAll() throws SQLException {
        var sql = "DELETE FROM urls";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        }
    }
}
