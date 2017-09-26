package ast;

import derivation.Visitor;

public class Exp extends UnaryOperation {
	
	public Exp(Operation op) {
		super(op);
	}

	@Override
	public <T> T accept(Visitor<T> v) {
		return v.visitExp(op);
	}
	
	public String toString(){
		return "(exp(" + op.toString() + "))";
 	}

	@Override
	public Double getNumericResult(Double val) {
		return Math.exp(op.getNumericResult(val));
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Exp)) return false;
		Exp abs = (Exp) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 31 * op.hashCode();
	}
}
