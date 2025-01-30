//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("punched");
		nouns.add("Wal-Mart");
		adjectives.add("Massive");
		story="I punched Wal-Mart in a Massive way.";

	}

	public MadLib(String fileName)
	{
		//load stuff
		loadNouns();
		loadAdjectives();
		loadVerbs();

		

		try
		{
			Scanner read = new Scanner(new File("story.dat"));
			Scanner chopper = new Scanner(story);
			String word ="";
			while(read.hasNext());
			{
				word=read.next();
				if(word.equals("&"))
				{
					story+= getRandomAdjective();
				}
				else if(word.equals("@"))
				{
					story+= getRandomVerb();
				}
				else if(word.equals("#"))
				{
					story+= getRandomNoun();
				}
				else
				{
					story += story;
				}
				read.close();
				chopper.close();
			}
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech


			//While there is more of the story, read in the word/symbol

				//If what was read in is one of the symbols, find a random
				//word to replace it.
			


		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns()
	{
		try
		{
			Scanner reader = new Scanner(new File("nouns.dat"));
			while (reader.hasNext())
			{
				nouns.add(reader.next());
			}
			reader.close();

		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}

	}

	public void loadVerbs()
	{
		try
		{
			Scanner readerer = new Scanner(new File("verbs.dat"));
			while (readerer.hasNext())
			{
				verbs.add(readerer.next());
			}
			readerer.close();

		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner readererer = new Scanner(new File("adjectives.dat"));
			while (readererer.hasNext())
			{
				adjectives.add(readererer.next());
			}
			readererer.close();

		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
	}

	public String getRandomVerb()
	{
		int spot = (int)(Math.random()*verbs.size());

		return ""+ verbs.get(spot);
	}

	public String getRandomNoun()
	{
		int spot = (int)(Math.random()*nouns.size());

		return ""+ nouns.get(spot);
	}

	public String getRandomAdjective()
	{
		int spot = (int)(Math.random()*adjectives.size());

		return ""+ adjectives.get(spot);
	}

	public String toString()
	{
		return "" + story;
	}
}