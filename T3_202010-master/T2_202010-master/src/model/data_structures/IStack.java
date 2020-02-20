package model.data_structures;

public interface IStack <T extends Comparable<T>>
{
void push(T dato);
T pop();
int darTamano();
boolean estaVacia();
T darTope();
}
