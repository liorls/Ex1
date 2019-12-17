package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import com.google.*;
import com.google.gson.Gson;

import Ex1.StdDraw;

public class Functions_GUI implements functions {
	public LinkedList<function> list;

	public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE,
			Color.red, Color.GREEN, Color.PINK};

	@Override
	public boolean add(function arg0) {
		boolean ansToReturn = this.list.add(arg0);
		return ansToReturn;
	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		boolean ansToReturn = this.list.addAll(arg0);
		return ansToReturn;
	}

	@Override
	public void clear() {
		this.list.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		boolean ansToReturn = this.list.contains(arg0);
		return ansToReturn;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		boolean ansToReturn = this.list.containsAll(arg0);
		return ansToReturn;
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public Iterator<function> iterator() {
		return this.list.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		boolean ansToReturn = this.list.remove(arg0);
		return ansToReturn;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		boolean ansToReturn = this.list.removeAll(arg0);
		return ansToReturn;		
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		boolean ansToReturn = this.list.retainAll(arg0);
		return ansToReturn;
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public Object[] toArray() {
		return this.list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return this.list.toArray(arg0);
	}

	@Override
	public void initFromFile(String file) throws IOException {
		String line = "";
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null){
				if (line.charAt(0) == 'x' || line.charAt(0) == '-' || line.charAt(0) == '+') {
					if (line.charAt(0) >= '0' && line.charAt(0) <- '9') {
						Polynom polynom = new Polynom (line);
						this.list.add(polynom);
					}
				}
				if (line.charAt(0) >= 'a' && line.charAt(0) <= 'z') {
					if (line.charAt(0) != 'x') {
						ComplexFunction complexfunction = new ComplexFunction (line);
						this.list.add(complexfunction);
					}
				}
			} 
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("could not read file");
		}
	}

	@Override
	public void saveToFile(String file) throws IOException {
		Iterator iterator = this.iterator();
		try 
		{
			PrintWriter pw = new PrintWriter(new File(file));
			StringBuilder sb = new StringBuilder();
			while(iterator.hasNext()) {
				sb.append(iterator.next().toString());
				sb.append("\n");	
			}
			pw.write(sb.toString());
			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
	}


	public boolean equals(Functions_GUI fg) {
		if(this.toString().equals(fg.toString())) {
			return true;
		}
		return false;
	}


	@Override 
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		StdDraw.setCanvasSize(width,height);
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());

		double lenX = Math.abs((rx.get_max()) - (rx.get_min()));
		double lenY = Math.abs((ry.get_max()) - (ry.get_min()));

		// vertical lines 
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		for (int i = 0; i <= lenX; i++) {
			StdDraw.line(rx.get_min(), ry.get_min(), rx.get_min(), ry.get_max());
		}
		// horizontal  lines 
		for (double i = 0 ; i <= lenY; i++) {
			StdDraw.line(rx.get_min(), ry.get_min(), rx.get_max(), ry.get_min());
		}

		////////x axis 
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(rx.get_min(),0,rx.get_max(),0);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		for (int i = 0; i <= lenX; i++) {
			StdDraw.text(rx.get_min(), -0.11, ("" + rx.get_min()));
		}
		//////// y axis	
		StdDraw.line(0,ry.get_min(),0,ry.get_max());
		for (double i = 0; i <= lenY; i++) {
			StdDraw.text(-0.11, ry.get_min(), ("" + ry.get_min()));
		}

		// The function
		double lenstep = (rx.get_max()-rx.get_min())/(resolution);
		for (int i= 0; i < this.list.size(); i++) {
			for (int j = 0; j < resolution; j++) {
				StdDraw.setPenColor(Colors[i%(Colors.length)]);
				StdDraw.setPenRadius(0.003);
				StdDraw.line(rx.get_min(),this.list.get(i).f(rx.get_min()),((rx.get_min())+lenstep),this.list.get(i).f(((rx.get_min())+lenstep)));
	
			}
		}
	}

	@Override
	public void drawFunctions(String json_file) {
		try {
			Gson gson = new Gson();
			FileReader reader = new FileReader(json_file);
			GUI_params gp = gson.fromJson(reader,GUI_params.class);
			Range rx = new Range(gp.Range_X[0], gp.Range_X[1]);
			Range ry = new Range(gp.Range_Y[0], gp.Range_Y[1]);
			this.drawFunctions(gp.Width, gp.Height, rx, ry, gp.Resolution);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	class GUI_params{
		public int Width;
		public int Height;
		public int Resolution;
		public double []Range_X;
		public double []Range_Y;
	}

}
