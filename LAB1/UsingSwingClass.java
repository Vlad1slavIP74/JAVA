package LAB1;

import javax.swing.JOptionPane;
public class UsingSwingClass {
	public static void main(String[] args) {
		UsingSwingClass lab1 = new UsingSwingClass();
		short operators[] = lab1.askValues();

		double sum = lab1.calculate(operators[0], operators[1], operators[2], operators[3]); 

		JOptionPane.showMessageDialog(null, "the sum is : " + sum , "Results", JOptionPane.PLAIN_MESSAGE );
	}
	public double calculate(short numberI, short numberJ, short numberN, short numberM) {
		return 2.15;
	}

	public short[] askValues() {
		String i, j, n, m;
		short numberI, numberJ, numberN, numberM;
		try {
			i = JOptionPane.showInputDialog("Enter 'i' variable");
			numberI = Short.parseShort(i);
				
			j = JOptionPane.showInputDialog("Enter 'j' variable");
			numberJ = Short.parseShort(j);	

			n = JOptionPane.showInputDialog("Enter 'n' variable");
			numberN = Short.parseShort(n);

			m = JOptionPane.showInputDialog("Enter 'm' variable");
			numberM = Short.parseShort(m);

			if(numberN < numberI || numberM < numberJ) {
				throw new Exception("Enter valid number. 'i' < 'n' and 'j' < 'm'");
			}
			return new short[] {numberI, numberJ, numberN, numberM};
		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e, "title", JOptionPane.PLAIN_MESSAGE);
		}
		return null;
	}
}