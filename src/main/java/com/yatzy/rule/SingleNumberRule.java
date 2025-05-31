package com.yatzy.rule;

import com.yatzy.model.Dice;

public abstract class SingleNumberRule implements ScoreRule {
	
	protected abstract int targetNumber();

    @Override
    public int calculate(Dice dice) {
        return (int) (dice.count(targetNumber()) * targetNumber());
    }
}
