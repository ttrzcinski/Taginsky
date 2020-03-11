package org.ttrzcinski.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VersionUtil_isAnySetTest {

    @Test
    void isAnySet_withAllSet() {
        // Arrange
        Integer test_major = 1;
        Integer test_minor = 2;
        Integer test_build = 3;
        boolean expected = true;

        // Act
        boolean actual = VersionUtil.isAnySet(test_major, test_minor, test_build);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void isAnySet_withMixed() {
        // Arrange
        Integer test_major = null;
        Integer test_minor = 2;
        Integer test_build = null;
        boolean expected = true;

        // Act
        boolean actual = VersionUtil.isAnySet(test_major, test_minor, test_build);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void isAnySet_withAllUnset() {
        // Arrange
        Integer test_major = null;
        Integer test_minor = null;
        Integer test_build = null;
        boolean expected = false;

        // Act
        boolean actual = VersionUtil.isAnySet(test_major, test_minor, test_build);

        // Assert
        assertEquals(expected, actual);
    }
}