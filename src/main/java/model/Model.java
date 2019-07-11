package model;

public interface Model<T> {
    public T save(T t);

    default public T remove(T t) {
        return null;
    }
}
