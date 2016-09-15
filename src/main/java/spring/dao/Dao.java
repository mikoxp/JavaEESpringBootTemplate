package spring.dao;

/**
 * Created by spring on 28.07.2016.
 */
public class Dao<T> {
    private T value;

    public Dao(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}