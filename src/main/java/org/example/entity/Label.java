package org.example.entity;

import lombok.Getter;

@Getter
public class Label {
    private final String label;

    public Label(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Label{" +
                "label='" + label + '\'' +
                '}';
    }
}
