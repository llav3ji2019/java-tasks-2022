package code.homework7.easy;

import code.homework7.ReflectionToStringHelper;

public class Easy {
    private final int age;
    private final String name;
    private final double weight;

    public Easy(int age, String name, double weight) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return ReflectionToStringHelper.reflectiveToString(this);
    }
}