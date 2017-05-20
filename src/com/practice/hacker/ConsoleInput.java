package com.practice.hacker;

import java.io.IOException;

public final class ConsoleInput
	{
		private static boolean goodLastRead = false;
		public static boolean lastReadWasGood()
		{
			return goodLastRead;
		}

		public static String readToWhiteSpace(boolean skipLeadingWhiteSpace){
			String input = "";
			char nextChar;
			try {
				while (Character.isWhitespace(nextChar = (char)System.in.read()))
				{
					//accumulate leading white space if skipLeadingWhiteSpace is false:
					if (!skipLeadingWhiteSpace)
					{
						input += nextChar;
					}
				}
			
			//the first non white space character:
			input += nextChar;

			//accumulate characters until white space is reached:
			while (!Character.isWhitespace(nextChar = (char)System.in.read()))
			{
				input += nextChar;
			}

			goodLastRead = input.length() > 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return input;
	}

		public static String scanfRead()
		{
			return scanfRead(null, -1);
		}

		public static String scanfRead(String unwantedSequence)
		{
			return scanfRead(unwantedSequence, -1);
		}

		public static String scanfRead(String unwantedSequence, int maxFieldLength)
		{
			String input = "";

			char nextChar;
			if (unwantedSequence != null)
			{
				nextChar = '\0';
				for (int charIndex = 0; charIndex < unwantedSequence.length(); charIndex++)
				{
					if (Character.isWhitespace(unwantedSequence.charAt(charIndex)))
					{
						//ignore all subsequent white space:
						try {
							while (Character.isWhitespace(nextChar = (char)System.in.read()))
							{
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						//ensure each character matches the expected character in the sequence:
						try {
							nextChar = (char)System.in.read();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (nextChar != unwantedSequence.charAt(charIndex))
							return null;
					}
				}

				input = (new Character(nextChar)).toString();
				if (maxFieldLength == 1)
					return input;
			}

			try {
				while (!Character.isWhitespace(nextChar = (char)System.in.read()))
				{
					input += nextChar;
					if (maxFieldLength == input.length())
						return input;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return input;
		}
	}
