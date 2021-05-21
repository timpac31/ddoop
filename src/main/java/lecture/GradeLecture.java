package lecture;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradeLecture extends Lecture {
	public GradeLecture(int pass, String title, List<Integer> scores) {
		super(pass, title, scores);
	}
	
	public double average(Grade grade) {		
		return super.getScores().stream()
				.filter(score -> grade.include(score))
				.mapToInt(Integer::intValue)
				.average().orElse(0d);
	}
	
	@Override
	public String evaluate() {
		return super.evaluate() + ", " + gradesStatistics();
	}

	private String gradesStatistics() {
		return Stream.of(Grade.values())
				.map(grade -> gradeStatFormat(grade))
				.collect(Collectors.joining(" "));
	}

	private String gradeStatFormat(Grade grade) {
		return String.format("%s:%d", grade.name(), gradeCount(grade));
	}

	private Object gradeCount(Grade grade) {
		return super.getScores().stream().filter(score -> grade.include(score)).count();
	}
}
