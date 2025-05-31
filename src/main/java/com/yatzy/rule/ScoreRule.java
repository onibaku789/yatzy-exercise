package com.yatzy.rule;

import com.yatzy.model.Dice;

public interface ScoreRule {

	int calculate(Dice dice);
}
