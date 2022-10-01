package movie;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
