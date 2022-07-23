package chapter2.BookCafe;

public class ThrillerObserver implements Observer {
    private HBookCafe hBookCafe;
    private final Genre genre = Genre.THRILLER;

    public ThrillerObserver(HBookCafe hBookCafe) {
        this.hBookCafe = hBookCafe;
        hBookCafe.registerObserver(this);
    }

    @Override
    public void update() {
        if (hBookCafe.getGenre() == genre) {
            System.out.println("ThrillerObserver "+genre+" 수신완료!");
        }
    }
}
