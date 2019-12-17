package Ex1;

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

public class Functions_GUI implements functions {
	public LinkedList<function> list;


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
	
	
	//TODO equal
	
	
	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub
		try {
			PolynomGraph pg = new PolynomGraph()
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void drawFunctions(String json_file) {
		Gson gson = new Gson();
		String json = gson.toJson(json_file);
	}

}
