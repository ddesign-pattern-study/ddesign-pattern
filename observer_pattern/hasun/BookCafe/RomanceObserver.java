package BookCafe;

public class RomanceObserver implements Observer{
    private HBookCafe hBookCafe;
    private final Genre genre = Genre.ROMANCE;

    public RomanceObserver(HBookCafe hBookCafe) {
        this.hBookCafe = hBookCafe;
        hBookCafe.registerObserver(this);
    }

    @Override
    public void update() {
        if (hBookCafe.getGenre() == this.genre) {
            System.out.println("RomanceObserver "+genre+" 수신완료!");
        }
    }
}
