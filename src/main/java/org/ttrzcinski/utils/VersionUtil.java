package org.ttrzcinski.utils;

/**
 * Generates version tag based on passed parameters.
 */
public class VersionUtil {

    /**
     * Converts given major, minor and build numbers into version tag.
     *
     * @param major passed major version
     * @param minor passed minor version
     * @param build passed build number
     * @return created version tag
     */
    public static String asVersion(Integer major, Integer minor, Integer build) {
        int valMajor = major != null ? Math.abs(major) : 0;
        int valMinor = minor != null ? Math.abs(minor) : 0;
        int valBuild = build != null ? Math.abs(build) : 0;
        return String.format("%s.%d.%d", valMajor, valMinor, valBuild);
    }

    /**
     * Checks, if any of passed value is set.
     *
     * @param major passed major
     * @param minor passed minor
     * @param build passed build
     * @return true means at least one is set, false otherwise
     */
    public static boolean isAnySet(Integer major, Integer minor, Integer build) {
        return major != null || minor != null || build != null;
    }
}
