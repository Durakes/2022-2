#include <iostream>
#include <cmath>
using namespace std;

struct complejo
{
    float real;
    float imaginario;
};

typedef struct complejo Complejo;

Complejo* crear(int real, int imaginario)
{
    Complejo* complejo = (Complejo*) malloc(sizeof(Complejo));

    complejo->real = real;
    complejo->imaginario = imaginario;

    return complejo;
}

void imprimir(Complejo *num)
{
    cout << "Real: " << num->real << endl;
    cout << "Imaginario: " << num->imaginario << endl;
    cout << "Completo: " << num->real << " + " << num->imaginario << "i" << endl; 
}

Complejo* suma(Complejo *num1, Complejo *num2)
{
    Complejo *suma = (Complejo*) malloc(sizeof(Complejo));

    suma->real = num1->real + num2->real;
    suma->imaginario = num1->imaginario + num2->imaginario;

    return suma;
}

Complejo* multiplicar(Complejo *num1, Complejo *num2)
{
    Complejo *multiplicar = (Complejo*) malloc(sizeof(Complejo));

    multiplicar->real = (num1->real * num2->real) - (num1->imaginario * num2->imaginario);
    multiplicar->imaginario = (num1->real * num2->imaginario) + (num1->imaginario * num2->real);

    return multiplicar;
}

Complejo* absoluto(Complejo *num)
{
    Complejo *absoluto = (Complejo*) malloc(sizeof(Complejo));

    absoluto->real = sqrt((num->real * num->real) + (num->imaginario * num->imaginario));
    absoluto->imaginario = 0;

    return absoluto;
}

Complejo* negativo(Complejo *num)
{
    Complejo *negativo = (Complejo*) malloc(sizeof(Complejo));

    negativo->real = -1 * num->real;
    negativo->imaginario = -1 * num->imaginario;

    return negativo;
}

int main()
{
    Complejo* complejo, *complejo2, *absComplejo, *sumComplejo, *multComplejo, *negComplejo;
    complejo = crear(3, 4);
    complejo2 = crear(1, 2);

    absComplejo = absoluto(complejo);
    sumComplejo = suma(complejo, complejo2);
    multComplejo = multiplicar(complejo, complejo2);
    negComplejo = negativo(complejo);

    cout << "Numero complejo 1: " << endl;
    imprimir(complejo);
    cout << endl;
    cout << "Numero complejo 2: " << endl;
    imprimir(complejo2);
    cout << endl;
    cout << "Valor Absoluto: " << endl;
    imprimir(absComplejo);
    cout << endl;
    cout << "Suma Complejos: " << endl;
    imprimir(sumComplejo);
    cout << endl;
    cout << "Multiplicar Complejos: " << endl;
    imprimir(multComplejo);
    cout << endl;
    cout << "Negar Complejo: " << endl;
    imprimir(negComplejo);
    cout << endl;


    return 0;
}