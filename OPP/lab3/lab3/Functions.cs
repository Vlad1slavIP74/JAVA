using System;
using System.Threading;

namespace lab4
{
public class ThreadFunctions
{
Data d;
public ThreadFunctions(Data d)
{
this.d = d;

}
public void Task1()
{
int n;
int e;
int[] a, b;
int[,] mb, mc;
Console.WriteLine(Thread.CurrentThread.Name + " started");
n = d.getN ();
a = new int[n];
b = new int[n];
d.vectorFill(1, b);
mb = new int[n,n];
mc = new int[n,n];
d.matrixFill(1, mb);
d.matrixFill(1, mc);
Thread.Sleep(3000);
a = d.func1(b, mb, mc);
Console.WriteLine("F1:");
d.vectorOutput(a);

Console.WriteLine(Thread.CurrentThread.Name + " finished");
}
public void Task2()
{
int n;
int[] w, r;
int[,] mt, mx, ms;
Console.WriteLine(Thread.CurrentThread.Name + " started");
n = d.getN();
r = new int[n];
d.vectorFill(1, r);
mt = new int[n,n];
d.matrixFill (1, mt);
ms = new int[n, n];
d.matrixFill(1, ms);
mx = new int[n,n];
d.matrixFill (1, mx);
Thread.Sleep(2000);
w = d.func2(r, mt, mx, ms);
Console.WriteLine("F2:");
d.vectorOutput(w);
Console.WriteLine(Thread.CurrentThread.Name + " finished");
}
public void Task3()
{
int n;
int[] r,s,t;
int[,] mr, ms;
Console.WriteLine(Thread.CurrentThread.Name + " started");
n = d.getN();
s = new int[n];
d.vectorFill(1, s);
t = new int[n];
d.vectorFill(1, t);
mr = new int[n,n];
d.matrixFill (1, mr);
ms = new int[n,n];
d.matrixFill (1, ms);
Thread.Sleep(1000);
r = d.func3(s, t, ms, mr);
Console.WriteLine("F3:");
d.vectorOutput(r);
Console.WriteLine(Thread.CurrentThread.Name + " finished");
}
}
}