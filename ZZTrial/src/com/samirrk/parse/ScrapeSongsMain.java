package com.samirrk.parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeSongsMain 
{
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ScrapeSongsMain ssm = new ScrapeSongsMain();
		
		String input = "";
		try 
		{
			input = processText("/Users/samir/tmp/hgm.txt");
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			return;
		}
		







		Document doc = Jsoup.parse(input);
		Elements trows = doc.getElementsByTag("tr");
		ArrayList<SongInfo> arrSongInfo = new ArrayList<ScrapeSongsMain.SongInfo>(); 
		for (Element trow : trows)
		{
			Elements tdatas = trow.children();
			int i = 0;
			SongInfo si = ssm.new SongInfo();
			for (Element tdata : tdatas)
			{
				if (i == 0)
					si.song = tdata.child(0).text();
				if (i == 1)
					si.singer = tdata.text();
				if (i == 2)
					si.musicDirector = tdata.text();
				if (i == 3)
					si.lyricist = tdata.text();
				if (i == 4)
				{
					String txt = tdata.text();
					si.film = txt.substring(0, txt.indexOf('('));
					si.year = txt.substring(txt.indexOf('(')+1, txt.lastIndexOf(')'));
				}
				i++;
			}
			arrSongInfo.add(si);
		}
		Collections.sort(arrSongInfo);
		
		for (SongInfo si : arrSongInfo)
		{
			System.out.println("Song: " + si.song + " (" + si.year + ")");
		}
	}
	
	public class SongInfo implements Comparable<SongInfo>
	{
		String song;
		String film;
		String singer;
		String musicDirector;
		String lyricist;
		String year;
		
		@Override
		public int compareTo(SongInfo si)
		{
			int rv = Integer.parseInt(this.year) - Integer.parseInt(si.year);
			return rv;
		}
	}
	
	public static String processText(String filename) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(filename));
	    StringBuffer fileContents = new StringBuffer();
	    String line = br.readLine();
	    while (line != null) 
	    {
	        fileContents.append(line);
	        line = br.readLine();
	    }

	    br.close();


	    StringBuilder sb = new StringBuilder();
	    sb.append("<html><body><table>");
	    sb.append(fileContents);
	    sb.append("</table></body></html>");
		
	    return sb.toString();
	}

}


