package ast;

import derivation.Visitor;

public class Cos extends UnaryOperation {

	public Cos(Operation op) {
		super(op);
	}

	@Override
	public <T> T accept(Visitor<T> v) {
		return v.visitCos(op);
	}
	
	public String toString(){
		return "cos(" + op.toString() + ")";
 	}

	@Override
	public Double getNumericResult(Double val) {
		return Math.cos(op.getNumericResult(val));
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Cos)) return false;
		Cos abs = (Cos) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 29 * op.hashCode();
	}

}
