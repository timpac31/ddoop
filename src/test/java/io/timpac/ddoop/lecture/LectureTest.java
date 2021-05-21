package io.timpac.ddoop.lecture;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lecture.Grade;
import lecture.GradeLecture;
import lecture.Lecture;

public class LectureTest {
	@Test
	public void evaluate() {
		Lecture lecture = new Lecture(70, "수학", Arrays.asList(90, 80, 70, 60, 55));
		assertEquals("Pass:3, Fail:2", lecture.evaluate());
	}
	
	@Test
	public void gradeLectureTest() {
		GradeLecture lecture = new GradeLecture(70, "프로그래밍", Arrays.asList(90, 80, 70, 60, 55, 30));
		assertEquals("Pass:3, Fail:3, A:1 B:1 C:2 D:1 F:1", lecture.evaluate());
		assertEquals(65d, lecture.average(Grade.C));
	}
}
