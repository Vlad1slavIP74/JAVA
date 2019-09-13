package LAB2;

import javax.swing.*;
import javax.swing.JOptionPane;

public class LAB2 {
    public static void main(String[] args) {
        LAB2 lab2 = new LAB2();
        byte matrix[][] = lab2.fillMatrix();
        //size r x c
        byte row = (byte)matrix.length;
        byte column = (byte)matrix[0].length;

        System.out.println(row);
        System.out.println(column);
        lab2.display(matrix, row, column, "before");
        byte newMatrix[][] = lab2.transport(matrix, row, column);
        Object[][] data = new Object [row][column];

     
         lab2.display(newMatrix, column, row, "after");


        
    }
    // byte [-128;127] sizeof 1 byte
    public byte[][] fillMatrix() {
        String matrixRow, matrixColumn;
        byte parseMatrixRow, parseMatrixColumn;

        try {
            matrixRow = JOptionPane.showInputDialog("Enter size(Row) for matrix");
            parseMatrixRow = Byte.parseByte(matrixRow);
            
            matrixColumn = JOptionPane.showInputDialog("Enter size(Column) for matrix");
            parseMatrixColumn = Byte.parseByte(matrixColumn);
            if(parseMatrixColumn <= 0 || parseMatrixRow <= 0) {
                throw new Exception("Enter size > 0");
            }

            byte[][] matrix = new byte[parseMatrixRow][parseMatrixColumn];
        for (byte i = 0; i < parseMatrixRow; i++) {
            for (byte j = 0; j < parseMatrixColumn; j++) {
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

    public byte [][] transport(byte [][] matrix, byte row, byte column) {
        byte [][] newMatrix = new byte[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }

    public void display(byte [][] matrix, byte row, byte column, String title) {
        JFrame window = new JFrame(title);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(200, 200);
        window.setLocationRelativeTo(null);

        Object[][] data = new Object [row][column];

        for (byte i = 0; i < row;i++) {
            for (byte j = 0; j < column; j++) {
                data[i][j] = matrix[i][j];
                System.out.print(data[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
        Object[] empty = new Object[column];
        
        for (byte i = 0; i < column; i++) {
            empty[i] = "";
        }
            
        JTable table = new JTable(data, empty);
        window.add(new JScrollPane(table));
        window.setVisible(true);
    }
}