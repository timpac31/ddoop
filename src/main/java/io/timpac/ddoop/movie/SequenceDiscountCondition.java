package io.timpac.ddoop.movie;

public class SequenceDiscountCondition implements DiscountCondition {
	private int seq;
	
	public SequenceDiscountCondition(int seq) {
		this.seq = seq;
	}
	
	@Override
	public boolean isSatisfied(Screening screening) {
		return seq == screening.getSeq();
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
}
