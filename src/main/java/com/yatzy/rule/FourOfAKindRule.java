package com.yatzy.rule;

import java.util.Map;
import com.yatzy.model.Dice;

public class FourOfAKindRule implements ScoreRule {

	@Override
	public int calculate(Dice dice) {
		for (Map.Entry<Integer, Long> entry : dice.getFrequencyMap().entrySet()) {
            if (entry.getValue() >= 4) {
                return entry.getKey() * 4;
            }
        }
		return 0;
	}

}
