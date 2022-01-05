package com.cruftbusters.java_starter;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class BiNode {
    BiNode left;
    String token;
    BiNode right;

    public String toString() {
        return "\n" + toString(this);
    }

    public static String toString(BiNode node) {
        String leftBox = toStringOrEmpty(node.left);
        int leftBoxWidth = leftBox.split("\n")[0].length();
        String leftPadding = new String(new char[leftBoxWidth]).replace("\0", " ");
        String rightBox = toStringOrEmpty(node.right);
        int rightBoxWidth = rightBox.split("\n")[0].length();
        String rightPadding = new String(new char[rightBoxWidth]).replace("\0", " ");
        String bottomBox = bottomBox(leftBox, rightBox);
        if (leftBox.length() > 0 || rightBox.length() > 0){
            return String.format("%s%s%s\n%s", leftPadding, node.token, rightPadding, bottomBox);
        } else return node.token;
    }

    private static String bottomBox(String leftBox, String rightBox) {
        String[] leftBoxLines = leftBox.split("\n");
        if (leftBoxLines.length > 1) {
            return leftBoxLines[0] + " " + rightBox + "\n" + leftBoxLines[1];
        } else return leftBox + " " + rightBox;
    }

    private static String toStringOrEmpty(BiNode node) {
        if (node == null) {
            return "";
        } else return toString(node);
    }
}