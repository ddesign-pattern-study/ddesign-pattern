package chapter2.BookCafeLmbda;

import java.util.ArrayList;
import java.util.List;

public class HBookCafe implements Subject {
    private List<Observer> observers;
    private Genre genre;

    public HBookCafe() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(genre);
        }
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
        notifyObserver();
    }

    public Genre getGenre() {
        return this.genre;
    }
}
