package lecture;

public enum Grade {
	A(100, 90), 
	B(89, 80), 
	C(79, 60), 
	D(59, 40), 
	F(39, 0);
	
	private int upper;
	private int lower;
	
	Grade(int upper, int lower) {
		this.upper = upper;
		this.lower = lower;
	}
	
	public boolean include(int score) {
		return upper >= score && lower <= score;
	}
}
