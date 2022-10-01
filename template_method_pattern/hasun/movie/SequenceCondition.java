package movie;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        // screening 의 상연 순번과 일치할 경우 할인 가능한 것으로 판단
        return screening.isSequence(sequence);
    }
}
