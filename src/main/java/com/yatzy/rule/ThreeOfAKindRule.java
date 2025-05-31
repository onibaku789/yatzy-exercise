package com.yatzy.rule;

import java.util.Map;
import com.yatzy.model.Dice;

public class ThreeOfAKindRule implements ScoreRule {

	@Override
	public int calculate(Dice dice) {
		for (Map.Entry<Integer, Long> entry : dice.getFrequencyMap().entrySet()) {
            if (entry.getValue() >= 3) {
                return entry.getKey() * 3;
            }
        }
		return 0;
	}

}
