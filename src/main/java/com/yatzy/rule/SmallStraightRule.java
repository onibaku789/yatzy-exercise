package com.yatzy.rule;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.yatzy.model.Dice;

public class SmallStraightRule implements ScoreRule {

	@Override
	public int calculate(Dice dice) {
		Set<Integer> required = Set.of(1, 2, 3, 4, 5);
        //return dice.getValues().length == 5 && 
        	//	required.containsAll(Arrays.stream(dice.getValues()).boxed().toList()) ? 15 : 0;
		 Set<Integer> uniqueValues = new HashSet<>(Arrays.stream(dice.getValues()).boxed().toList());		 
	        if (uniqueValues.equals(required)) {
	            return 15;
	        }
	        return 0;
	}

}
