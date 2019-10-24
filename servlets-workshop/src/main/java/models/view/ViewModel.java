package models.view;

public class ViewModel<T> {
    T object;

    public ViewModel(T object) {
        this.object = object;
    }
}
