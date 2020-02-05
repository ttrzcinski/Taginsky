package org.ttrzcinski;

public class Main {

    public static void main(String[] args) {
        // Get me new tag
        String newTag = new TagBuilder().withUUID().asDash();
        System.out.println("Tag value: " + newTag);

        String newTag2 = new TagBuilder().withUUID().asDash();
        System.out.println("Tag value 2: " + newTag2);
    }
}
