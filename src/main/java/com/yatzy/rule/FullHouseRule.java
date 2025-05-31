package com.yatzy.rule;

import java.util.Map;
import com.yatzy.model.Dice;

public class FullHouseRule implements ScoreRule {

	@Override
	public int calculate(Dice dice) {
		boolean hasThree = false;
        boolean hasTwo = false;
        int sum = 0;

        for (Map.Entry<Integer, Long> entry : dice.getFrequencyMap().entrySet()) {
            if (entry.getValue() == 3) {
                hasThree = true;
                sum += entry.getKey() * 3;
            } else if (entry.getValue() == 2) {
                hasTwo = true;
                sum += entry.getKey() * 2;
            }
        }

        return (hasThree && hasTwo) ? sum : 0;
	}

}
