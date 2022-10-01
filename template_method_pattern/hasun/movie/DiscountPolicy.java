package movie;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
