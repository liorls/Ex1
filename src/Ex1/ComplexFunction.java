package Ex1;

public class ComplexFunction implements complex_function{
	/**
	 * l = left function
	 * op = operation between the function
	 * r = right function
	*/
	function l;
	Operation op;
	function r;

	public ComplexFunction() {
	}
	
	public ComplexFunction(Operation op, function left, function right) {
		super();
		this.op = op;
		this.l = left;
		this.r = right;
	}
	
	public ComplexFunction(function f) {
		super();
		this.l = f;
		this.r = null;
		this.op = Operation.None;
	}
	
	public ComplexFunction(String s, function f1L, function f2R) {
		super();
		this.l = f1L;
		this.r = f2R;
		s = s.toLowerCase();
	}
	
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
		if (op.equals("add") || op.equals("plus")) {
			this.op = Operation.Plus;
		}
		if (op.equals("multiply") || op.equals("times")) {
			this.op = Operation.Times;
		}
		if (op.equals("div") || op.equals("Divid")) {
			this.op = Operation.Divid;
		}
		if (op.equals("max")) {
			this.op = Operation.Max;
		}
		if (op.equals("min")) {
			this.op = Operation.Min;
		}
		if (op.equals("comp")) {
			this.op = Operation.Comp;
		}
	}


	public String toString() {
		String string = "";
		string = string + this.op.toString() + "(" + this.l.toString() + "," + this.r.toString() + ")";
		return string;
	}

	/**
	 * The function return the value
	 * of x in f(x)
	 */
	@Override
	public double f(double x) {
		double ansL = this.l.f(x);
		double ansR = this.r.f(x);
		
		if(this.op.toString().equals("Plus"))
			return (ansL + ansR);
		if(this.op.toString().equals("Times"))
			return (ansL * ansR);
		if(this.op.toString().equals("Divid"))
			return (ansL / ansR);
		if(this.op.toString().equals("Max"))
			return Math.max(ansL, ansR);
		if(this.op.toString().equals("Min"))
			return Math.min(ansL, ansR);
		if(this.op.toString().equals("Comp"))
			return l.f(ansR);

		return 0;
	}

	@Override
	public function initFromString(String s) {
		ComplexFunction ans = new ComplexFunction(s);
		return ans;
	}

	/**
	 * copy of function
	 */
	@Override
	public function copy() {
		ComplexFunction ans = new ComplexFunction(this.toString());
		return ans;
	}

	/**
	 * The functions are all
	 * operation between the right side and left side
	 */
	@Override
	public void plus(function f1) {
		ComplexFunction left = new ComplexFunction(this.toString());
		this.l = left;
		this.op = Operation.Plus;
		this.r = f1;
	}

	@Override
	public void mul(function f1) {
		ComplexFunction left = new ComplexFunction(this.toString());
		this.l = left;
		this.op = Operation.Times;
		this.r = f1;
	}

	@Override
	public void div(function f1) {
		ComplexFunction left = new ComplexFunction(this.toString());
		this.l = left;
		this.op = Operation.Divid;
		this.r = f1;
	}

	@Override
	public void max(function f1) {
		ComplexFunction left = new ComplexFunction(this.toString());
		this.l = left;
		this.op = Operation.Max;
		this.r = f1;
	}

	@Override
	public void min(function f1) {
		ComplexFunction left = new ComplexFunction(this.toString());
		this.l = left;
		this.op = Operation.Min;
		this.r = f1;
	}

	@Override
	public void comp(function f1) {
		ComplexFunction left = new ComplexFunction(this.toString());
		this.l = left;
		this.op = Operation.Comp;
		this.r = f1;
	}

	/**
	 * Check between the Strings of this ComplexFunction and another given ComplexFunction.
	 * Returns true or false.
	 */
	public boolean equal(ComplexFunction ans) {
		String cf1 = this.toString();
		String cf2 = ans.toString();
		return cf1.equals(cf2);
		}
	
	@Override
	public function left() {
		return this.l;
	}

	@Override
	public function right() {
		return this.r;
	}

	@Override
	public Operation getOp() {
		return this.op;
	}
}