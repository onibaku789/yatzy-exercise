package com.yatzy.rule;

import com.yatzy.model.Dice;

public class ChanceRule implements ScoreRule {

	@Override
	public int calculate(Dice dice) {
		return dice.sum();
	}

}
