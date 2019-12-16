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

public class Functions_GUI implements functions {
	public LinkedList<function> list;


	@Override
	public boolean add(function arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<function> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

}
