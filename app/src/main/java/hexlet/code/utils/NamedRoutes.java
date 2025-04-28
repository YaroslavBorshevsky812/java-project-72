package hexlet.code.utils;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String urlsPath() {
        return "/urls";
    }

    public static String urlPath(Long id) {
        return urlsPath(String.valueOf(id));
    }

    public static String urlPath(String id) {
        return "/urls/" + id;
    }


    public static String urlsPath(String id) {
        return "/urls/" + id;
    }
    // END
}
