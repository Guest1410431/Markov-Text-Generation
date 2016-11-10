package Main;

import java.util.HashMap;
import java.util.Set;

public class Bag
{
	//Number of elements in the map
	private int size = 0;
	//Most frequent letter so far
	private String mostFrequent;
	//Hashmap of a letter with its frequency
	private HashMap<String, Integer> data;
	
	public Bag()
	{
		data = new HashMap<String, Integer>();
	}
	public int getSize()
	{
		return size;
	}
	public void add(String letter)
	{
		size++;
		
		if(data.containsKey(letter)) //If it already exists, put it back in with an increased frequency
		{
			int num = data.get(letter);
			data.put(letter, ++num);
		}
		else //First time the letter appears
		{
			data.put(letter, 1);
		}
		if(getFrequency(letter) > getFrequency(mostFrequent))
		{
			mostFrequent = letter;
		}
	}
	public int getFrequency(String letter)
	{
		if(data.containsKey(letter))
		{
			return data.get(letter);
		}
		return 0;
	}
	public String getMostFrequent()
	{
		return mostFrequent;
	}
	public String getRandomLetter()
	{
		Set<String>set = data.keySet();
		String[]letters = set.toArray(new String[0]);
		return letters[(int)(Math.random()*letters.length)];
	}
	public String getRandomLetterByFrequency()
	{
		int num = (int)(Math.random()*getSize());
		int sum = 0;
		
		for(String letter:data.keySet())
		{
			sum += data.get(letter);
			
			if(num < sum)
			{
				return letter;
			}
		}
		return "ERROR";
	}
	public String toString()
	{
		return data.toString();
	}
}












