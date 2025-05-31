package com.yatzy;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

import com.yatzy.model.Category;
import com.yatzy.model.Dice;
import com.yatzy.model.DiceRoller;
import com.yatzy.rule.LargeStraightRule;
import com.yatzy.rule.OnesRule;
import com.yatzy.rule.ScoreRule;
import com.yatzy.rule.SmallStraightRule;
import com.yatzy.rule.ThreeOfAKindRule;
import com.yatzy.rule.ThreesRule;
import com.yatzy.rule.TwosRule;
import com.yatzy.rule.YatzyRule;
import com.yatzy.util.ConsoleOutput;
import com.yatzy.util.OutputStrategy;

public class YatzyJava {
	
	private static final String YOU_VE_GOT_NOTHING = "You've got NOTHING";
	
	static int playNo =1;

	private OutputStrategy outputStrategy; 
	
	public int score(Dice dice, ScoreRule rule) {
        return rule.calculate(dice);
    }

    public YatzyJava() {
    	
    }
    
    public void setOutputStrategy(OutputStrategy outputStrategy) {
    	this.outputStrategy = outputStrategy;
    }
    
    
    /*
     * This is a game simulation with 3 retries
     */
    public static void main(String[] args) {
    	Category[] categories = Category.values();
		YatzyJava yatzyGame = new YatzyJava();
		DiceRoller roller = new DiceRoller();
		int[] values = new int[] {4,4,4,4,4};
		Dice dice = new Dice(values);
		Category category = categories[0];
		yatzyGame.setOutputStrategy(new ConsoleOutput());
		yatzyGame.getResult(category, yatzyGame, dice);
		yatzyGame.getResult(Category.THREE_OF_A_KIND, yatzyGame, new Dice(3, 4, 4, 4, 4));
		yatzyGame.getResult(Category.ONES, yatzyGame, new Dice(1, 1, 1, 1, 1));
		
		//print(category,score,result);
	}
    
    public String getResult(Category category, YatzyJava yatzyJava, Dice dice) {
        Map<Category, ScoreRule> ruleMap = Map.of(
            Category.YATZY, new YatzyRule(),
            Category.THREE_OF_A_KIND, new ThreeOfAKindRule(),
            Category.SMALL_STRAIGHT, new SmallStraightRule(),
            Category.LARGE_STRAIGHT, new LargeStraightRule(),
            Category.ONES, new OnesRule(),
            Category.TWOS, new TwosRule(),
            Category.THREES, new ThreesRule()
            // Add others as needed
        );

        ScoreRule rule = ruleMap.get(category);
        if (rule == null) {
            return YOU_VE_GOT_NOTHING;
        }

        int score = yatzyJava.score(dice, rule);
        String result = (score > 0) ? "You've got a " + category.toString() : YOU_VE_GOT_NOTHING;

        print(category, score, result, playNo++); // Optional: remove if you don’t want print in all cases
        return result;
    }


	private void print(Category category, int score, String result, int playNo) {
		outputStrategy.print(category, score, result, playNo);
	}
}



