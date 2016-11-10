package Main;

public class Main
{
	public static void main(String[] args)
	{
		int length = 150;
		
		String output = "";
		String state;
		
		TextModel model = new TextModel();
		//For loading in from a file
		model.loadData("hemingway.txt");
		
		state = "The";
		output += state;
		
		System.out.println("Predicting...");
		
		for(int i=1; i<length; i++)
		{
			if(i % 100 == 0)
			{
				output += "\n";
			}
			String nextLetter = model.getNextLetter(state);
			output += nextLetter;
			state = state.substring(1, 3) + nextLetter;
		}
		System.out.println();
		System.out.println(output);
	}
}
