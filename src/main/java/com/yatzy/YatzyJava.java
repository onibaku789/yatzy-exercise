package com.yatzy;
import com.yatzy.model.Dice;
import com.yatzy.rule.ScoreRule;

public class YatzyJava {
	
	public int score(Dice dice, ScoreRule rule) {
        return rule.calculate(dice);
    }

    public YatzyJava() {
    	
    }
}



