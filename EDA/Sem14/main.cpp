#include <iostream>
#include <list>
using namespace std;

typedef struct fraccion
{ 
    int numerador; 
    int denominator; 
} Fraccion;

Fraccion* crear(int numerador, int denominador)
{
    int i;
    Fraccion* fraccion = (Fraccion*) malloc(sizeof(Fraccion));
    fraccion->numerador = numerador;
    fraccion->denominator = denominador;
    
    return fraccion;
}

void liberar(Fraccion* fraccion)
{
    free(fraccion);
}

Fraccion* acceder(Fraccion* fraccion, int nuevoNumerador, int nuevoDenominador)
{
    fraccion->numerador = nuevoNumerador;
    fraccion->denominator = nuevoDenominador;
    return fraccion;
}

bool signoFraccion(Fraccion* fraccion)
{
    if(fraccion->denominator * fraccion->numerador > 0)
        return true;
    else
        return false;
}

bool fracEsSenalNeg(Fraccion* fraccion)
{
    if(signoFraccion(fraccion))
        return false;
    else
        return true;
}

int mayorNum(int numerador, int denominador)
{
    if(numerador > denominador)
        return numerador;
    else
        return denominador;
}

int auxMCD(int mayor, int menor)
{
    int resto;
    if(mayor%menor == 0)
        return menor;
    else
    {
        return auxMCD(menor, mayor%menor);
    }
}

Fraccion* fracReduce(Fraccion* fraccion)
{
    int numPos,denPos;
    int mcd;

    if(fraccion->numerador < 0)
        numPos = fraccion->numerador * -1;
    else
        numPos = fraccion->numerador;

    if(fraccion->denominator < 0)
        denPos = fraccion->numerador * -1;
    else
        denPos = fraccion->denominator;
    
    int mayor = mayorNum(numPos, denPos);
    
    if(numPos > denPos)
        mcd = auxMCD(numPos, denPos);
    else
        mcd = auxMCD(denPos, numPos);

    fraccion->numerador /= mcd;
    fraccion->denominator /= mcd;

    return fraccion;
}

Fraccion* fracMult(Fraccion* num1, Fraccion* num2)
{
    Fraccion* numero = (Fraccion*) malloc(sizeof(Fraccion));

    numero->numerador = (num1->numerador * num2->numerador);
    numero->denominator = (num1->denominator * num2->denominator);

    if(numero->numerador == 0)
        numero = crear(0,-1);
    else
        numero = fracReduce(numero);

    return numero;
}

void MostrarFrac(Fraccion* fraccion)
{
    if(fraccion != NULL)
    {
        if(fraccion->denominator == 1)
        {
            cout << fraccion->numerador << endl;
        }else if(fraccion->numerador == 0)
        {
            cout << 0 << endl;
        }else if(fraccion->denominator == 0)
        {
            cout << "Fraccion indeterminada" << endl;
        }else
        {
            cout << fraccion->numerador << "/" << fraccion->denominator << endl;
        }
    }else
    {
        cout << 0 << endl;
    }
}

void analizaNumerador(Fraccion* fraccion)
{
    if(fraccion->numerador%2 == 0)
        cout << "Numerador de: " << fraccion->numerador << "/" << fraccion->denominator << "es: " << fraccion->numerador << " y es par" << endl;
    else
        cout << "Numerador de: " << fraccion->numerador << "/" << fraccion->denominator << "es: " << fraccion->numerador << " y NO es par" << endl;
}

bool fracEsMayor(Fraccion* p, Fraccion* q)
{
    float result1, result2;
    result1 = ((float)p->numerador / (float)p->denominator);
    result2 = ((float)q->numerador / (float)q->denominator);
    if(result1 > result2)
    {
        return true;
    }
    else
    {
        return false;
    }
}

Fraccion* lista_mult(list<Fraccion*> fracciones)
{
    list<Fraccion*>:: iterator itr;
    Fraccion * tempFraccion = crear(1,1);
    for(itr = fracciones.begin(); itr!=fracciones.end(); ++itr)
    {
        tempFraccion = fracMult(tempFraccion,*itr);
    }
    return tempFraccion;
}

int main()
{
    list<Fraccion*> fracciones;
    Fraccion* f1 = crear(-24,468);
    Fraccion* f1Reducida = fracReduce(f1);
    Fraccion* f2 = crear(6,4);
    Fraccion* f3 = crear(0,2);
    Fraccion* f4 = crear(1,3);
    Fraccion* f5 = fracMult(fracMult(f1,f2),f4);
    Fraccion* f6 = fracMult(f5,f3);
    Fraccion* f7 = crear(6,9);
    Fraccion* f8 = crear(2,4);
    Fraccion* f9 = crear(-6,9);

    cout << "f1 = ";
    MostrarFrac(f1);
    cout << "f1 reducida = ";
    MostrarFrac(f1Reducida);
    cout << "f2 = ";
    MostrarFrac(f2);
    cout << "f3 = ";
    MostrarFrac(f3);
    cout << "f4 = ";
    MostrarFrac(f4);
    cout << "f5 = f4*f2*f1 = ";
    MostrarFrac(f5);
    cout << "f6 = f5*f3 = ";
    MostrarFrac(f6);
    if(fracEsSenalNeg(f5))
    {
        MostrarFrac(f5);
        cout << " Es NEGATIVA";
    }
    analizaNumerador(f5);
    
    if(fracEsMayor(f7,f8))
        cout << "f7 mayor a f8" << endl;
    else
        cout << "f7 menor a f8" << endl;
    
    if(fracEsMayor(f9,f8))
        cout << "f9 mayor a f8" << endl;
    else
        cout << "f9 menor a f8" << endl;
    
    fracciones.push_back(f1);
    fracciones.push_back(f2);
    fracciones.push_back(f4);

    Fraccion* mult3 = lista_mult(fracciones);
    
    cout << "La multiplicacion de la lista es : "<< endl;
    MostrarFrac(mult3);
    //cout << fracciones.size() << endl;

    //lista_mult(fracciones);
    return 0;
}