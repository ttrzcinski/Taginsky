package org.ttrzcinski.utils;

import java.awt.*;
import java.nio.file.Paths;

/**
 * Passed information about OS.
 *
 * Created 31.08.2019 12:06 as a part of project DukesHiddenStash
 *
 * @author <a href="mailto:trzcinski.tomasz.1988@gmail.com">Tomasz T.</a>
 * @version %I% from %G%
 * @since 1.12
 */
public final class OSInfo {

    /**
     * Hidden constructor - there is not point to initialize an instance.
     */
    private OSInfo() {
    }

    /**
     * Checks directory by checking current relative path. "\" - Windows-based "/" - *nux based
     *
     * @return "win', if windows, "nix" otherwise
     */
    public static String checkDirectoryBySystem() {
        return Paths.get("").toAbsolutePath().toString()
                .contains("\\") ? "win" : "nix";
    }

    /**
     * Checks, if current OS is Windows-based.
     *
     * @return true means it's Windows
     */
    public static boolean isWindows() {
        return System.getProperty("os.name").contains("Windows");
    }

    /**
     * Checks, if current OS is *nix-based.
     *
     * @return true means
     */
    public static boolean isNix() {
        return !isWindows();
    }

    /**
     * Reads current screen resolution.
     *
     * @return screen size as dimension
     */
    public static Dimension readResolution() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    /**
     * Fixed direction of slashes in given path to current OS.
     *
     * @param path given path
     * @return fixed path
     */
    public static String fixPath(final String path) {
        // Check given parameter
        if (!ParamCheck.isSet(path)) {
            return path;
        }
        // Process given parameter
        return isWindows()
                ? path.replaceAll("/", "\\\\")
                : path.replaceAll("\\\\", "/");
    }
}
