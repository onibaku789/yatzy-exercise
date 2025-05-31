package com.yatzy.model;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class Dice {
	
	private final int[] values;
	
	private final Map<Integer, Long> frequencyMap;
	
	public Dice(int... values) {
		if (values.length != 5)
			throw new IllegalArgumentException("Exactly 5 dice are required");
		this.values = values;
		frequencyMap = computeFrequencyMap();
	}

	public int[] getValues() {
		return values.clone();
	}
	
	/*
	 * method count occurence of given value in all 5 dice
	 * 
	 * @param int value
	 */
	public long count(int value) {
		return Arrays.stream(values)
				.boxed().filter(v->v==value).count();
	}
	
	/*
	 * get unmodifiable frequencyMap which help us for further computation
	 * 
	 */
	public Map<Integer, Long> getFrequencyMap() {
		return Collections.unmodifiableMap(frequencyMap);
	}
	
	/*
	 * summing all dice values
	 */
	public int sum() {
		return Arrays.stream(values).sum();
	}
	
	/*
	 * ComputeFrequencyMap during initialization
	 * 
	 */
	private Map<Integer, Long> computeFrequencyMap() {
		return Arrays.stream(values).boxed()
				.collect(Collectors.groupingBy(v->v,Collectors.counting()));
	}

}
