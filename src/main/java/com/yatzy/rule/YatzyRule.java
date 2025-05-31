package com.yatzy.rule;

import com.yatzy.model.Dice;

public class YatzyRule implements ScoreRule {

	@Override
	public int calculate(Dice dice) {
		return dice.getFrequencyMap().containsValue(5L) ? 50 : 0;
	}

}
