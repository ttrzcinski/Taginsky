package org.ttrzcinski.utils;

import org.ttrzcinski.dictionaries.Binding;
import org.ttrzcinski.dictionaries.DateWithTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder of version tag.
 */
public class TagBuilder {

    /**
     * List of kept parts.
     */
    private List<String> parts;

    /**
     * MArks usage of UUID.
     */
    private boolean uuidUsage;

    /**
     * Major number of version tag.
     */
    private Integer major;

    /**
     * Minor number of version tag.
     */
    private Integer minor;

    /**
     * Build number of version tag.
     */
    private Integer buildNumber;

    /**
     * Type of passed date form.
     */
    private DateWithTime dateWithTime;

    /**
     * Kept concatenating character.
     */
    private Binding binding;

    /**
     * Creates new instance of version tag builder.
     */
    public TagBuilder() {
        this.clear();
    }

    /**
     * Clears variables to their zero values.
     */
    public void clear() {
        this.parts = new ArrayList<>();
        this.uuidUsage = false;
        this.dateWithTime = DateWithTime.NONE;

        this.major = null;
        this.minor = null;
        this.buildNumber = null;

        this.binding = Binding.NONE;
    }

    /**
     * Marks usage of UUID.
     *
     * @return builder handle
     */
    public TagBuilder withUUID() {
        this.uuidUsage = true;
        return this;
    }

    /**
     * Marks usage of major version.
     *
     * @param version passed value
     * @return builder handle
     */
    public TagBuilder withMajorVersion(int version) {
        this.major = Math.abs(version);
        return this;
    }

    /**
     * Marks usage of minor version.
     *
     * @param version passed value
     * @return builder handle
     */
    public TagBuilder withMinorVersion(int version) {
        this.minor = Math.abs(version);
        return this;
    }

    /**
     * Marks usage of build number.
     *
     * @param version passed value
     * @return builder handle
     */
    public TagBuilder withBuildNumber(int version) {
        // TODO READ THE BUILD FROM GIT REPOSITORY
        this.buildNumber = Math.abs(version);
        return this;
    }

    /**
     * Marks usage of current date.
     *
     * @return builder handle
     */
    public TagBuilder withDate() {
        this.dateWithTime = DateWithTime.DATE_ONLY;
        return this;
    }

    /**
     * Marks usage of current timestamp.
     *
     * @return builder handle
     */
    public TagBuilder witTimestamp() {
        this.dateWithTime = DateWithTime.TIMESTAMP;
        return this;
    }

    /**
     * Marks usage of current time.
     *
     * @return builder handle
     */
    public TagBuilder withTime() {
        this.dateWithTime = this.dateWithTime == DateWithTime.DATE_ONLY
                ? DateWithTime.TIMESTAMP
                : DateWithTime.DATE_ONLY;
        return this;
    }

    /**
     * Processes set attributes into version tag.
     *
     * @return version tag
     */
    private String process() {
        // Version
        if (VersionUtil.isAnySet(this.major, this.minor, this.buildNumber)) {
            this.parts.add(VersionUtil.asVersion(this.major, this.minor, this.buildNumber));
        }

        // UUID
        if (this.uuidUsage) {
            this.parts.add(UUIDUtil.getUUID());
        }

        // Date'n'time
        if (this.dateWithTime != DateWithTime.NONE) {
            this.parts.add(TimeUtil.asTime(this.dateWithTime));
        }

        // Concatenating
        String delimiter;
        switch (this.binding) {
            case DASHES -> delimiter = "-";
            case UNDERSCORES -> delimiter = "_";
            default -> delimiter = "";
        }
        return String.join(delimiter, this.parts);
    }

    /**
     * Returns version tag with underscores.
     *
     * @return version tag with underscores
     */
    public String asUnderscore() {
        this.binding = Binding.UNDERSCORES;
        String rtn = this.process();
        this.clear();
        return rtn;
    }

    /**
     * Returns version tag with dashes.
     *
     * @return version tag with dashes
     */
    public String asDash() {
        this.binding = Binding.DASHES;
        String rtn = this.process();
        this.clear();
        return rtn;
    }

    /**
     * Returns version tag without spaces.
     *
     * @return version tag without spaces
     */
    public String asTrim() {
        this.binding = Binding.NONE;
        String rtn = this.process();
        this.clear();
        return rtn;
    }

}
