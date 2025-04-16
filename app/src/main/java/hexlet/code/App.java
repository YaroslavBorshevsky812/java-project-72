package hexlet.code;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import hexlet.code.repository.BaseRepository;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.flywaydb.core.Flyway;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class App {
    private static final String DEFAULT_JDBC_URL = "jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;";
    private static final String DEFAULT_PORT = "7070";

    public static Javalin getApp() throws IOException, SQLException {
        // Получаем URL БД из переменной окружения или используем H2 по умолчанию
        String jdbcUrl = getJdbcUrl();
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcUrl);

        // Настройка для PostgreSQL
        if (isPostgres(jdbcUrl)) {
            hikariConfig.setMaximumPoolSize(10);
        }

        var dataSource = new HikariDataSource(hikariConfig);
        initializeDatabase(dataSource, jdbcUrl);
        BaseRepository.dataSource = dataSource;

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.result("Hello World"));

        return app;
    }

    private static int getPort() {
        return Integer.parseInt(System.getenv().getOrDefault("PORT", DEFAULT_PORT));
    }

    private static String getJdbcUrl() {
        return System.getenv().getOrDefault("JDBC_DATABASE_URL", DEFAULT_JDBC_URL);
    }

    private static void initializeDatabase(HikariDataSource dataSource, String jdbcUrl) throws SQLException, IOException {
        if (isPostgres(jdbcUrl)) {
            // Для PostgreSQL используем Flyway для миграций
            Flyway flyway = Flyway.configure()
                                  .dataSource(dataSource)
                                  .load();
            flyway.migrate();
        } else {
            // Для H2 выполняем SQL из файла
            var sql = readResourceFile("schema.sql");
            try (var connection = dataSource.getConnection();
                 var statement = connection.createStatement()) {
                statement.execute(sql);
            }
        }
    }

    private static boolean isPostgres(String jdbcUrl) {
        return jdbcUrl.startsWith("jdbc:postgresql:");
    }

    private static String readResourceFile(String fileName) throws IOException {
        var inputStream = App.class.getClassLoader().getResourceAsStream(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }

    public static void main(String[] args) throws IOException, SQLException {

        Javalin app = getApp();
        app.start(7070);
    }
}