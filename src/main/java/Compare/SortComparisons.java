package Compare;

import java.awt.Color;
import java.util.HashMap;

class Complexity {

	public String timeComplexityBest;
	public String spaceComplexityBest;
	public String timeComplexityAverage;
	public String spaceComplexityAverage;
	public String timeComplexityWorst;
	public String spaceComplexityWorst;

	// Default constructor
	public Complexity() {
		timeComplexityBest = "";
		spaceComplexityBest = "";
		timeComplexityAverage = "";
		spaceComplexityAverage = "";
		timeComplexityWorst = "";
		spaceComplexityWorst = "";
	}

	// Parameterized constructor
	public Complexity(String timeBest, String spaceBest, String timeAverage, String spaceAverage, String timeWorst, String spaceWorst) {
		this.timeComplexityBest = timeBest;
		this.spaceComplexityBest = spaceBest;
		this.timeComplexityAverage = timeAverage;
		this.spaceComplexityAverage = spaceAverage;
		this.timeComplexityWorst = timeWorst;
		this.spaceComplexityWorst = spaceWorst;
	}
};

class Effect {

	public int start;
	public int end;
	public Color color;

	public Effect(int s, int e, final Color c) {
		start = s;
		end = e;
		color = c;
	}
};

public class SortComparisons {

	Boolean started = false;
	String name;
	final HashMap<String, Complexity> allComplexities = new HashMap<>();

	public SortComparisons() {
		started = false;
		setupComplexities();
	}

	private static void setupComplexities() {
		final HashMap<String, Complexity> allComplexities = new HashMap<>();
// Fill the HashMap with complexities of various sorting algorithms
		allComplexities.put("Insertion Sort", new Complexity("O(n)", "O(1)", "O(n^2)", "O(1)", "O(n^2)", "O(1)"));
		allComplexities.put("Selection Sort", new Complexity("O(n^2)", "O(1)", "O(n^2)", "O(1)", "O(n^2)", "O(1)"));
		allComplexities.put("Bubble Sort", new Complexity("O(n)", "O(1)", "O(n^2)", "O(1)", "O(n^2)", "O(1)"));
		allComplexities.put("Merge Sort", new Complexity("O(n log n)", "O(n)", "O(n log n)", "O(n)", "O(n log n)", "O(n)"));
		allComplexities.put("Quick Sort", new Complexity("O(n log n)", "O(log n)", "O(n log n)", "O(log n)", "O(n^2)", "O(n)"));
	}

	public void chooseSort(String sortName) {
		started = true;
		if (!allComplexities.containsKey(sortName)) {
			throw new IllegalArgumentException("you!");
		}
		name = sortName;
	}

	public String spaceBest() {
		if (!started) {
			throw new IllegalArgumentException("you again!");
		}
		return allComplexities.get(name).spaceComplexityBest;
	}

	public String spaceAverage() {
		if (!started) {
			throw new IllegalArgumentException("you again!");
		}
		return allComplexities.get(name).spaceComplexityAverage;
	}

	public String spaceWorst() {
		if (!started) {
			throw new IllegalArgumentException("you again!");
		}
		return allComplexities.get(name).spaceComplexityWorst;
	}

	public String timeBest() {
		if (!started) {
			throw new IllegalArgumentException("you again!");
		}
		return allComplexities.get(name).timeComplexityBest;
	}

	public String timeAverage() {
		if (!started) {
			throw new IllegalArgumentException("you again!");
		}
		return allComplexities.get(name).timeComplexityAverage;
	}

	public String timeWorst() {
		if (!started) {
			throw new IllegalArgumentException("you again!");
		}
		return allComplexities.get(name).timeComplexityWorst;
	}

}
