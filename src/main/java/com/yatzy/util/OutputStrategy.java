package com.yatzy.util;

import com.yatzy.model.Category;

public interface OutputStrategy {
	
	void print(Category category, int score, String result, int playNo);
}
