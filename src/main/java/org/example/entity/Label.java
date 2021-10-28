package org.example.entity;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Label {
    private final String label;

    public Label(String label) {
        this.label = label;
    }
    //генерация целочисленного кода объекта
    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    //сравнение объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label1 = (Label) o;
        return Objects.equals(label, label1.label);
    }

    @Override
    public String toString() {
        return "Label{" +
                "label='" + label + '\'' +
                '}';
    }
}
