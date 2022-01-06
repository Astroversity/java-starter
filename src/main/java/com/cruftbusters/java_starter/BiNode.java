package com.cruftbusters.java_starter;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

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
        if (leftBox.length() > 0 || rightBox.length() > 0) {
            return String.format("%s%s%s\n%s", leftPadding, node.token, rightPadding, bottomBox);
        } else return node.token;
    }

    private static String bottomBox(String leftBox, String rightBox) {
        String[] leftBoxLines = leftBox.split("\n");
        String[] rightBoxLines = rightBox.split("\n");
        List<String> bottomBoxLines = new ArrayList<>();
        for (int i = 0; i < Math.max(leftBoxLines.length, rightBoxLines.length); i++) {
            String leftBoxLine = getLineOrPadding(leftBoxLines, i);
            String rightBoxLine = getLineOrPadding(rightBoxLines, i);
            bottomBoxLines.add(leftBoxLine + " " + rightBoxLine);
        }
        return String.join("\n", bottomBoxLines);
    }

    private static String padding(int n) {
        return new String(new char[n]).replace("\0", " ");
    }

    private static String getLineOrPadding(String[] lines, int i) {
        if (i < lines.length) {
            return lines[i];
        } else return padding(lines[0].length());
    }


    private static String toStringOrEmpty(BiNode node) {
        if (node == null) {
            return "";
        } else return toString(node);
    }
}