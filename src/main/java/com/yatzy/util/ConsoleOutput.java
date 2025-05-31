package com.yatzy.util;

import com.yatzy.model.Category;

public class ConsoleOutput implements OutputStrategy {

	@Override
	public void print(Category category, int score, String result, int playNo) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(playNo + " Roll\n");
		stringBuilder.append("You have choosen Category: " + category.toString() + "\n");
		stringBuilder.append("score = " + score + "\n");
		stringBuilder.append(result);
		System.out.println(stringBuilder.toString());
	}

}
