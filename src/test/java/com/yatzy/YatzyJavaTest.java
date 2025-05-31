package com.yatzy;
import org.junit.jupiter.api.Test;

import com.yatzy.model.Category;
import com.yatzy.model.Dice;
import com.yatzy.model.DiceRoller;
import com.yatzy.rule.ChanceRule;
import com.yatzy.rule.FivesRule;
import com.yatzy.rule.FourOfAKindRule;
import com.yatzy.rule.FoursRule;
import com.yatzy.rule.FullHouseRule;
import com.yatzy.rule.LargeStraightRule;
import com.yatzy.rule.OnesRule;
import com.yatzy.rule.ScorePairRule;
import com.yatzy.rule.SixesRule;
import com.yatzy.rule.SmallStraightRule;
import com.yatzy.rule.ThreeOfAKindRule;
import com.yatzy.rule.ThreesRule;
import com.yatzy.rule.TwoPairRule;
import com.yatzy.rule.TwosRule;
import com.yatzy.rule.YatzyRule;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Map;


public class YatzyJavaTest {
	
	@Test
	public void yatzy_game_test() {
		YatzyJava yatzyGame = new YatzyJava();
		int actualScore = yatzyGame.score(createDice(4, 4, 4, 4, 4), new YatzyRule());
		int expectedScore = 50;
		assertEquals(expectedScore, actualScore);
	}

    @Test
    public void chance_scores_sum_of_all_dice_test() {
        int expected = 15;
        ChanceRule chance = new ChanceRule();
        int actual = chance.calculate(createDice(2, 3, 4, 5, 1));
        assertEquals(expected, actual);
        assertEquals(16, chance.calculate(createDice(3, 3, 4, 5, 1)));
    }

    @Test
    public void yatzy_scores_50_test() {
        int expected = 50;
        YatzyRule yatzyRule = new YatzyRule();
        int actual = yatzyRule.calculate(createDice(4, 4, 4, 4, 4));
        assertEquals(expected, actual);
        assertEquals(50, yatzyRule.calculate(createDice(6, 6, 6, 6, 6)));
        assertEquals(0, yatzyRule.calculate(createDice(6, 6, 6, 6, 3)));
    }

    @Test
    public void ones_test() {
    	OnesRule ones = new OnesRule();
        assertEquals(1, ones.calculate(createDice(1, 2, 3, 4, 5)));
        assertEquals(2, ones.calculate(createDice(1, 2, 1, 4, 5)));
        assertEquals(0, ones.calculate(createDice(6, 2, 2, 4, 5)));
        assertEquals(4, ones.calculate(createDice(1, 2, 1, 1, 1)));
    }

    @Test
    public void twos_test() {
    	TwosRule twos = new TwosRule();
        assertEquals(4, twos.calculate(createDice(1, 2, 3, 2, 6)));
        assertEquals(10, twos.calculate(createDice(2, 2, 2, 2, 2)));
    }

    @Test
    public void threes_test() {
    	ThreesRule threes = new ThreesRule();
        assertEquals(6, threes.calculate(createDice(1, 2, 3, 2, 3)));
        assertEquals(12, threes.calculate(createDice(2, 3, 3, 3, 3)));
    }

    @Test
    public void fours_test() {
    	FoursRule foursRule = new FoursRule();
        assertEquals(12, foursRule.calculate(createDice(4, 4, 4, 5, 5)));
        assertEquals(8, foursRule.calculate(createDice(4, 4, 5, 5, 5)));
        assertEquals(4, foursRule.calculate(createDice(4, 5, 5, 5, 5)));
    }

    @Test
    public void fives_test() {
    	FivesRule fives = new FivesRule();
        assertEquals(10,fives.calculate(createDice(4, 4, 4, 5, 5)));
        assertEquals(15, fives.calculate(createDice(4, 4, 5, 5, 5)));
        assertEquals(20, fives.calculate(createDice(4, 5, 5, 5, 5)));
    }

    @Test
    public void sixes_test() {
    	SixesRule sixes = new SixesRule();
        assertEquals(0, sixes.calculate(createDice(4, 4, 4, 5, 5)));
        assertEquals(6, sixes.calculate(createDice(4, 4, 6, 5, 5)));
        assertEquals(18, sixes.calculate(createDice(6, 5, 6, 6, 5)));
    }

    @Test
    public void one_pair_test() {
    	ScorePairRule scorePair = new ScorePairRule();
        assertEquals(6, scorePair.calculate(createDice(3, 4, 3, 5, 6)));
        assertEquals(10, scorePair.calculate(createDice(5, 3, 3, 3, 5)));
        assertEquals(12, scorePair.calculate(createDice(5, 3, 6, 6, 5)));
    }

    @Test
    public void two_Pair_test() {
    	TwoPairRule twoPair = new TwoPairRule();
        assertEquals(16, twoPair.calculate(createDice(3, 3, 5, 4, 5)));
        assertEquals(16, twoPair.calculate(createDice(3, 3, 5, 5, 5)));
    }

    @Test
    public void three_of_a_kind_test() {
    	ThreeOfAKindRule threeOfAKind = new ThreeOfAKindRule();
        assertEquals(9, threeOfAKind.calculate(createDice(3, 3, 3, 4, 5)));
        assertEquals(15, threeOfAKind.calculate(createDice(5, 3, 5, 4, 5)));
        assertEquals(9, threeOfAKind.calculate(createDice(3, 3, 3, 3, 5)));
    }

    @Test
    public void four_of_a_knd_test() {
    	FourOfAKindRule fourOfAKind = new FourOfAKindRule();
        assertEquals(12, fourOfAKind.calculate(createDice(3, 3, 3, 3, 5)));
        assertEquals(20, fourOfAKind.calculate(createDice(5, 5, 5, 4, 5)));
        assertEquals(12, fourOfAKind.calculate(createDice(3, 3, 3, 3, 3)));
    }

    @Test
    public void smallStraight_test() {
    	SmallStraightRule smallStraight = new SmallStraightRule();
    	assertEquals(15, smallStraight.calculate(createDice(1, 2, 3, 4, 5)));
        assertEquals(15, smallStraight.calculate(createDice(2, 3, 4, 5, 1)));
        assertEquals(0, smallStraight.calculate(createDice(1, 2, 2, 4, 5)));
    }

    @Test
    public void largeStraight_test() {
    	LargeStraightRule largeStraight = new LargeStraightRule();
        assertEquals(20, largeStraight.calculate(createDice(6, 2, 3, 4, 5)));
        assertEquals(20, largeStraight.calculate(createDice(2, 3, 4, 5, 6)));
        assertEquals(0, largeStraight.calculate(createDice(1, 2, 2, 4, 5)));
    }

    @Test
    public void fullHouse_test() {
        assertEquals(18, new FullHouseRule().calculate(createDice(6, 2, 2, 2, 6)));
        assertEquals(0, new FullHouseRule().calculate(createDice(2, 3, 4, 5, 6)));
    }
    
    @Test
    void should_initialize_with_five_values_test() {
        Dice dice = new Dice(1, 2, 3, 4, 5);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, dice.getValues());
    }

    @Test
    void should_throw_exception_if_not_exactly_five_values_test() {
        assertThrows(IllegalArgumentException.class, () -> new Dice(1, 2, 3, 4));
        assertThrows(IllegalArgumentException.class, () -> new Dice(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> new Dice());
    }

    @Test
    void should_correctly_calculate_frequencyMap_test() {
        Dice dice = new Dice(2, 2, 3, 4, 4);
        Map<Integer, Long> frequencyMap = dice.getFrequencyMap();

        assertEquals(2, frequencyMap.get(2));
        assertEquals(2, frequencyMap.get(4));
        assertEquals(1, frequencyMap.get(3));
        assertNull(frequencyMap.get(1)); // 1 is not present
    }

    @Test
    void getValues_should_be_immutable_test() {
    	 Dice dice = new Dice(1, 2, 3, 4, 5);
    	    int[] original = dice.getValues();
    	    original[0] = 99;

    	    // The internal state of Dice should remain unchanged
    	    int[] actual = dice.getValues();
    	    assertArrayEquals(new int[]{1, 2, 3, 4, 5}, actual);
    }
    
    @Test
    void roll_returns_five_dice_test() {
        DiceRoller roller = new DiceRoller();
        int[] dice = roller.roll();
        assertEquals(5, dice.length, "Dice roll should return exactly 5 values");
    }

    @Test
    void roll_dice_values_in_range_test() {
        DiceRoller roller = new DiceRoller();
        int[] dice = roller.roll();
        for (int die : dice) {
            assertTrue(die >= 1 && die <= 6, "Each die should be between 1 and 6");
        }
    }

    @Test
    void roll_randomness_test() {
        DiceRoller roller = new DiceRoller();
        int[] firstRoll = roller.roll();
        int[] secondRoll = roller.roll();
        assertNotEquals(Arrays.toString(firstRoll), Arrays.toString(secondRoll),
                "Two rolls should not produce the same result (most of the time)");
    }
    
    @Test
    void all_categories_exist_test() {
        Category[] categories = Category.values();
        assertTrue(categories.length > 0, "Category enum should not be empty");
    }

    @Test
    void category_names_test() {
        assertEquals("YATZY", Category.YATZY.name());
        assertEquals("THREE_OF_A_KIND", Category.THREE_OF_A_KIND.name());
        assertEquals("SMALL_STRAIGHT", Category.SMALL_STRAIGHT.name());
        assertEquals("LARGE_STRAIGHT", Category.LARGE_STRAIGHT.name());
        assertEquals("ONES", Category.ONES.name());
    }

    @Test
    void category_ValueOf_test() {
        assertEquals(Category.YATZY, Category.valueOf("YATZY"));
        assertThrows(IllegalArgumentException.class, () -> Category.valueOf("INVALID"));
    }
    
    private Dice createDice(int... values) {
    	return new Dice(values);
    }
}
