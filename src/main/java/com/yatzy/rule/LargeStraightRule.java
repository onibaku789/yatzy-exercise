package com.yatzy.rule;

import java.util.Arrays;
import java.util.Set;

import com.yatzy.model.Dice;

public class LargeStraightRule implements ScoreRule {

	@Override
	public int calculate(Dice dice) {
		Set<Integer> required = Set.of(2, 3, 4, 5, 6);
        return dice.getValues().length == 5 &&
        		required.containsAll(Arrays.stream(dice.getValues()).boxed().toList()) ? 20 : 0;
	}

}
