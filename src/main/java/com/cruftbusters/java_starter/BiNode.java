package com.cruftbusters.java_starter;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@EqualsAndHashCode
@ToString
class BiNode {
    BiNode left;
    String token;
    BiNode right;
}