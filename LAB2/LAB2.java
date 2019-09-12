package LAB2;

import javax.swing.*;
import javax.swing.JOptionPane;

public class LAB2 {
    public static void main(String[] args) {
        LAB2 lab2 = new LAB2();
        byte matrix[][] = lab2.fillMatrix();
        lab2.display(matrix,(byte) 5);
    }
    // byte [-128;127] sizeof 1 byte
    public byte[][] fillMatrix() {
        String matrixSize;
        byte parseMatrixSize;

        try {
            matrixSize = JOptionPane.showInputDialog("Enter size for matrix");
            parseMatrixSize = Byte.parseByte(matrixSize);
            
            if(parseMatrixSize <= 0) {
                throw new Exception("Enter size > 0");
            }

            byte[][] matrix = new byte[parseMatrixSize][parseMatrixSize];
        for (byte i = 0; i < parseMatrixSize; i++) {
            for (byte j = 0; j < parseMatrixSize; j++) {
                matrix[i][j] = (byte) (Math.random() * 255 - 128);
            }
        }
        return matrix;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "title for Error",JOptionPane.PLAIN_MESSAGE);
            System.exit(1);
        }
        return null;
    }

    public void transport(byte [][] matrix, byte size) {
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                byte temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void display(byte [][] matrix, byte size) {
        JFrame window = new JFrame("test");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(200, 200);
        window.setLocationRelativeTo(null);

        window

        JTable table = new JTable(mat, column);
        window.add(new JScrollPane(table));
        window.setVisible(true);
    }
}