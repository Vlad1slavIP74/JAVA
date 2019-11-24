using System;
using System.Threading;
/*
Parallel and distributed computing.
Lab 4: Threads in C#
Func1: A = sort(B)*(MB*MC)
Func2: W = sort(R*MT)*(MX*MS)
Func3: R = sort(S+T)*trans(MS*MR)
*/
namespace lab4
{
class MainClass
{
public static void Main (string[] args)
{
Console.WriteLine ("Lab 4 started");
int n = 5;
Data data = new Data(n);
ThreadFunctions t = new ThreadFunctions (data);
Thread t1 = new Thread(t.Task1, 1000);
Thread t2 = new Thread(t.Task2, 1000);
Thread t3 = new Thread(t.Task3, 1000);
t1.Name = "Thread 1";
t1.Priority = ThreadPriority.BelowNormal;
t2.Name = "Thread 2";
t2.Priority = ThreadPriority.AboveNormal;
t3.Name = "Thread 3";
t3.Priority = ThreadPriority.Highest;
t1.Start();
t2.Start();
t3.Start();
t1.Join ();
t2.Join ();
t3.Join ();
Console.WriteLine ("Lab 4 finished");

;
}
}
}
