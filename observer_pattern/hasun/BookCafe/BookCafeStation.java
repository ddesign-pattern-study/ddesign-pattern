package chapter2.BookCafe;

public class BookCafeStation {
    public static void main(String[] args) {
        HBookCafe hBookCafe = new HBookCafe();

        RomanceObserver romanceObserver = new RomanceObserver(hBookCafe);
        ThrillerObserver thrillerObserver = new ThrillerObserver(hBookCafe);
        AllGenreObserver allGenreObserver = new AllGenreObserver(hBookCafe);

        hBookCafe.setGenre(Genre.ROMANCE);
        hBookCafe.setGenre(Genre.THRILLER);
        hBookCafe.setGenre(Genre.COMEDY);
    }
}
