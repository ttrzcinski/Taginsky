package org.ttrzcinski.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VersionUtil_asVersionTest {

    @Test
    void asVersion_nulls() {
        // Arrange
        Integer test_major = null;
        Integer test_minor = null;
        Integer test_build = null;
        String expected = "0.0.0";

        // Act
        String actual = VersionUtil.asVersion(test_major, test_minor, test_build);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void asVersion_negatives() {
        // Arrange
        Integer test_major = -1;
        Integer test_minor = -2;
        Integer test_build = -3;
        String expected = "1.2.3";

        // Act
        String actual = VersionUtil.asVersion(test_major, test_minor, test_build);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void asVersion_positives() {
        // Arrange
        Integer test_major = 1;
        Integer test_minor = 2;
        Integer test_build = 3;
        String expected = "1.2.3";

        // Act
        String actual = VersionUtil.asVersion(test_major, test_minor, test_build);

        // Assert
        assertEquals(expected, actual);
    }
}
