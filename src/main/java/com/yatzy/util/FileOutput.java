package com.yatzy.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.yatzy.model.Category;

public class FileOutput implements OutputStrategy {

	private File file = new File("output.txt");
	private BufferedWriter fileWriter;
	public FileOutput() {
		try {
			fileWriter = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void print(Category category, int score, String result, int playNo) {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(playNo + " Roll\n");
		stringBuilder.append("You have choosen Category: " + category.toString() + "\n");
		stringBuilder.append("score = " + score + "\n");
		stringBuilder.append(result);
		try {
			
			fileWriter.write(stringBuilder.toString());
			fileWriter.newLine();
			fileWriter.flush();
		}
		catch (Exception e) {
			
		}
			
	}

}
