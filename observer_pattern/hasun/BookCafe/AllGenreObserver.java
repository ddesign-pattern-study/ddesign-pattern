package BookCafe;

public class AllGenreObserver implements Observer {
    private HBookCafe hBookCafe;
    private Genre genre;

    public AllGenreObserver(HBookCafe hBookCafe) {
        this.hBookCafe = hBookCafe;
        hBookCafe.registerObserver(this);
    }

    @Override
    public void update() {
        this.genre = hBookCafe.getGenre();
        System.out.println("AllGenreObserver "+genre+" 수신완료!");
    }
}
