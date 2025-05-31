package com.yatzy.rule;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.yatzy.model.Dice;

public class TwoPairRule implements ScoreRule {

	@Override
	public int calculate(Dice dice) {
		List<Integer> pairs = dice.getFrequencyMap().entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (pairs.size() >= 2) {
            return pairs.get(0) * 2 + pairs.get(1) * 2;
        }
        return 0;
	}

}
