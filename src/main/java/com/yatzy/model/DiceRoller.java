package com.yatzy.model;

import java.util.Random;

public class DiceRoller {
    public int[] roll() {
        Random random = new Random();
        int[] dice = new int[5];
        for (int i = 0; i < 5; i++) {
            dice[i] = random.nextInt(6) + 1;
        }
        return dice;
    }
}