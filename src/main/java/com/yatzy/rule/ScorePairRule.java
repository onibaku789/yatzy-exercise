package com.yatzy.rule;

import java.util.Map;

import com.yatzy.model.Dice;

public class ScorePairRule implements ScoreRule {

	@Override
	public int calculate(Dice dice) {
		return dice.getFrequencyMap().entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(Map.Entry::getKey)
                .max(Integer::compareTo)
                .map(val -> val * 2)
                .orElse(0);
	}

}
