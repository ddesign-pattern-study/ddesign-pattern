package BookCafeLmbda;

public class BookCafeStation {
    public static void main(String[] args) {
        HBookCafe hBookCafe = new HBookCafe();

        hBookCafe.registerObserver(genre -> {
            if (genre == Genre.COMEDY) {
                System.out.println(genre+" 수신완료!");
            }
        });

        hBookCafe.registerObserver(genre -> {
            if (genre == Genre.ROMANCE) {
                System.out.println(genre+" 수신완료!");
            }
        });

        hBookCafe.registerObserver(genre -> {
            System.out.println(genre+" 수신완료!");
        });

        hBookCafe.setGenre(Genre.COMEDY);
        hBookCafe.setGenre(Genre.ROMANCE);
        hBookCafe.setGenre(Genre.THRILLER);
    }
}
