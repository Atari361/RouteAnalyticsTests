package utils;

public class SysUtils {

    private static String getOperatingSystem() {
        return System.getProperty("os.name").toLowerCase();
    }

    public static boolean isMacOS() {
        return getOperatingSystem().contains("mac");
    }

    public static boolean isLinux() {
        return getOperatingSystem().contains("linux");
    }

    public static boolean isWindows() {
        return getOperatingSystem().contains("windows");
    }

    public static void main(String[] args) {
        // Needed to avoid TestNG classpath error
    }


}
