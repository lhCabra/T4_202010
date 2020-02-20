package model.data_structures;

public interface IQueue  <T extends Comparable<T>>
{
int darTamano();
T darPrincipio();
boolean estaVacia();
void enqueue(T dato);
T dequeue();
}
