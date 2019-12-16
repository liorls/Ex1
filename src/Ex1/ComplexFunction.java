package Ex1;

public class ComplexFunction implements complex_function{
	function l;
	Operation op;
	function r;


	public ComplexFunction(String s) {
		String op = "";
		String left = "";
		String right = "";
		int count = 0 ;
		for (int i = 0; i < s.length() ; i++) {
			if(s.charAt(i) == '(') {
				count ++ ;
				break;
			}
			op = op + s.charAt(i);
		}
		for (int i = op.length() + 1; i < s.length(); i++) {
			if(s.charAt(i) == ',' && count == 1) break;
			if(s.charAt(i) == ')') count --; 
			if(s.charAt(i) == '(') count ++; 
			left = left + s.charAt(i);
		}
		for (int i = (op.length() + left.length() + 1 ); i < s.length(); i++) {
			if(s.charAt(i) == ')' && count == 0) break;
			if(s.charAt(i) == ')') count --; 
			if(s.charAt(i) == '(') count ++; 
			right = right + s.charAt(i);
		}
		op = op.toLowerCase();
		left = left.toLowerCase();
		right = right.toLowerCase();
		if (left.charAt(0) >= 'a' && left.charAt(0) <= 'z') {
			if (left.charAt(0) != 'x') {
				this.l = new ComplexFunction(left);
			}
		}
		if (left.charAt(0) == 'x' || left.charAt(0) == '-' || left.charAt(0) == '+') {
			if (left.charAt(0) >= '0' && left.charAt(0) <- '9') {
				this.l = new Polynom(left);
			}
		}
		if (right.charAt(0) >= 'a' && right.charAt(0) <= 'z') {
			if (right.charAt(0) != 'x') {
				this.r = new ComplexFunction(right);
			}
		}
		if (right.charAt(0) == 'x' || right.charAt(0) == '-' || right.charAt(0) == '+') {
			if (right.charAt(0) >= '0' && right.charAt(0) <- '9') {
				this.r = new Polynom(right);
			}
		}
		this.op = Operation.None;
		if (op.equals("add") || op.equals("plus")) {//TODO
			this.op = Operation.Plus;
		}
	}
	
	
	public String toString() {
		String string = "";
		string = string + this.op.toString() + "(" + this.l.toString() + "," + this.r.toString() + ")";
		return string;
	}
		

	@Override
	public double f(double x) {
		double ans = 0;
		double ansL = this.l.f(x);
		double ansR = this.r.f(x);
		if(this.op.toString().equals("Plus"))//TODO
			return ansL + ansR;
		return 0;
	}

	@Override
	public function initFromString(String s) {
		ComplexFunction anser = new ComplexFunction(s);
		return anser;
	}

	@Override
	public function copy() {
		ComplexFunction anser = new ComplexFunction(this.toString());
		return anser;
	}

	@Override
	public void plus(function f1) {
		ComplexFunction left = new ComplexFunction(this.toString());
		this.l = left;
		this.op = Operation.Plus;
		this.r = f1;
	}

	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub‫‪‬‬

	}

	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public function left() {
		return this.l;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operation getOp() {
		// TODO Auto-generated method stub
		return null;
	}
}