package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class TextModel
{
	private HashMap<String, Bag>map;
	
	public TextModel()
	{
		map = new HashMap<String, Bag>();
	}
	public void add(String ngram, String nextLetter)
	{
		if(map.containsKey(ngram))
		{
			Bag b = map.get(ngram);
			b.add(nextLetter);
			map.put(ngram, b);
		}
		else
		{
			Bag b = new Bag();
			b.add(nextLetter);
			map.put(ngram, b);
		}
	}
	public void addAllNgramsIn(String inputText)
	{
		for(int i=0; i<inputText.length()-3; i++)
		{
			String ngram = inputText.substring(i, i+3);
			String nextLetter = inputText.substring(i+3, i+4);
			
			//System.out.println("Adding: " + ngram + " | Next is: " + nextLetter);
			
			add(ngram, nextLetter);
		}
	}
	//Loads the data from the file into the algorithm
	public void loadData(String filename)
	{
		String text = getFileAsString(filename);
		System.out.println("Finished Reading from file");
		System.out.println("Learning from data");
		addAllNgramsIn(text);
		System.out.println("Done learning form data");
	}
	//Returns the file into one singular string
	private String getFileAsString(String filename)
	{
		System.out.println("Reading from file");
		StringBuilder b = new StringBuilder();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			
			while(line != null)
			{
				b.append(line);
				line = br.readLine();
			}
			br.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b.toString();
	}
	public String getNextLetter(String state)
	{
		if(map.containsKey(state))
		{
			Bag b = map.get(state);
			return b.getRandomLetterByFrequency();
		}
		else
		{
			System.out.println("Never seen before: " + state);
		}
		return "";
	}
}

















