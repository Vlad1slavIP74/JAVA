using System;
/*
Parallel and distributed computing.
Lab 4: Threads in C#
Func1: A = sort(B)*(MB*MC)
Func2: W = sort(R*MT)*(MX*MS)
Func3: R = sort(S+T)*trans(MS*MR)
*/
namespace lab4
{
public class Data

{
private int n;
public int getN()
{
return n;
}
public Data(int n)
{
this.n = n;
}
public int[] vectorInput() {
int[] vector = new int[n];
for (int i = 0; i < n; i++) {
vector[i] = Console.Read();
}
return vector;
}
public void vectorFill(int value, int[] vector)
{
for (int i = 0; i < n; i++)
{
vector[i] = value;
}
return;
}
public void matrixFill(int value, int[,] matrix)
{
for (int i = 0; i < n; i++)
{
for (int j = 0; j < n; j++)
{
matrix[i, j] = value;
}
}
return;
}
public int[,] matrixInput() {
int[,] matrix = new int[n,n];
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
matrix[i,j] = Console.Read();
}
}
return matrix;
}
public void vectorOutput(int[] vector)
{
for (int i = 0; i < n; i++)
{
Console.Write(vector[i] + " ");
}
Console.WriteLine("");
}
public void matrixOutput(int[,] matrix)
{
for (int i = 0; i < n; i++)
{
for (int j = 0; j < n; j++)
{
Console.Write(matrix[i, j] + " ");
}
Console.WriteLine();
}
}
public int[] func1(int[] b, int[,] mb, int[,] mc)
{
return vectorMatrixMult(b, matrixMult(mb, mc));
}

public int[] func2(int[] r, int[,] mt, int[,] mx, int[,] ms)
{
return vectorMatrixMult(vectorSort(vectorMatrixMult(r, mt)), matrixMult(mx, ms));
}
public int[] func3(int[] s, int[] t, int[,] ms, int[,] mr)
{
return vectorMatrixMult(vectorAdd(s, t), matrixTrans(matrixMult(ms, mr)));
}
private int[] vectorAdd(int[] a, int[] b)
{
int[] c = new int[n];
for (int i = 0; i < n; i++)
{
c[i] = a[i] + b[i];
}
return c;
}
private int[,] matrixTrans(int[,] ma)
{
int buf;
for (int i = 0; i < n; i++)
{
for (int j = 0; j <= i; j++)
{
buf = ma[i,j];
ma[i,j] = ma[j,i];
ma[j,i] = buf;
}
}
return ma;
}
private int[] vectorMatrixMult(int[] a, int[,] ma)
{
int[] c = new int[n];
for (int i = 0; i < n; i++)
{
for (int j = 0; j < n; j++)
{
c[i] += a[j] * ma[j,i];
}
}
return c;
}
private int[,] matrixMult(int[,] ma, int[,] mb) {
int[,] c = new int[n,n];
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
for (int k = 0; k < n; k++) {
c[i,j] += ma[i,k] * mb[k,j];
}
}
}
return c;
}
private int[] vectorSort(int[] a)
{
int[] c = new int[n];
Array.Copy(a, c, n);
Array.Sort(c);
return c;
}
}
}