package org.ttrzcinski.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Generates UUID.
 */
public class UUIDUtil {

    /**
     * Kept set of used UUIDs.
     */
    private static Set<String> usedOnes = new HashSet<>();

    /**
     * Passes uuid to kept set.
     *
     * @param uuid passed uuid
     */
    public static void passUsedOne(String uuid) {
        // Check, if uuid was set
        if (!ParamCheck.isSet(uuid)) {
            return;
        }
        // Trim uuid and add it
        String trimmedUUID = uuid.trim();
        if (!usedOnes.contains(trimmedUUID)) {
            usedOnes.add(trimmedUUID);
        }
    }

    /**
     * Passes uuid to kept set.
     *
     * @param uuid passed uuid
     */
    public static void passUsedOne(UUID uuid) {
        // Check, if passed uuid is null
        if (!ParamCheck.isSet(uuid)) {
            return;
        }
        // Pass as String
        passUsedOne(uuid.toString());
    }

    /**
     * Creates new UUID.
     *
     * @return unique id
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        // Check, if uuid was actually used
        if (usedOnes.isEmpty()) {
            usedOnes.add(uuid);
            return uuid;
        }
        // Check, if uuid is known
        while (usedOnes.contains(uuid)) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }
}
