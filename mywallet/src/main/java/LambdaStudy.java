
public class LambdaStudy {

	private int N=10;
	public int getN() {
		return N;
	}
	public void setN(int num) {
		N=num;
		
	}
	public static void main(String[] args) {
		
	}
}

class Animal extends LambdaStudy{
	static Animal a=new Animal();
	int y=9;
	
	//a.setN(9);
	public static void main(String[] args) {
		//a.setN(2);
	}
}