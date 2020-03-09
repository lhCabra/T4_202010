package model.data_structures;

public class MaxHeapCP<T extends Comparable<T>>
{
	private T[] pq;
	private int N=0;

	MaxHeapCP(int maxN)
	{
		pq=(T[])new Comparable[maxN +1];
	}
	public int darNumElementos()
	{
		return N;
	}
	public void agregar(T elemento)
	{
		pq[++N]= elemento;
		swim(N);
	}
	public T sacarMax () 
	{	
		T max = pq[1]; // Retrieve max key from top.
		exch(1, N--); // Exchange with last item.
		pq[N+1] = null; // Avoid loitering.
		sink(1); // Restore heap property.
		return max;

	}
	public T darMax() 
	{
		return pq[1];
	}
	public boolean esVacia ()
	{
		return N==0;
	}

	private void swim(int k)
	{
		while (k > 1 && less(k/2, k))
		{
			exch(k/2, k);
			k = k/2;
		}
	}
	public void sink(int k)
	{
		while (2*k <= N)
		{
			int j = 2*k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	private boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j])<0;
	}
	private void exch(int i, int j)
	{
		T t=pq[i];
		pq[i]=pq[j];
		pq[j]=t;
	}
}
