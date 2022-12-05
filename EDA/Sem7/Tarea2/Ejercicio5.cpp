#include <iostream>
using namespace std;

typedef struct 
{ 
    int numerador; 
    int denominator; 
} RACIONAL;

RACIONAL* sumarRacionales(RACIONAL* num1, RACIONAL* num2)
{
    RACIONAL* numero = (RACIONAL*) malloc(sizeof(RACIONAL));

    numero->numerador = (num1->numerador * num2->denominator) + (num2->numerador * num1->denominator);
    numero->denominator = (num1->denominator * num2->denominator);

    return numero;
}

RACIONAL* multiplicarRacionales(RACIONAL* num1, RACIONAL* num2)
{
    RACIONAL* numero = (RACIONAL*) malloc(sizeof(RACIONAL));

    numero->numerador = (num1->numerador * num2->numerador);
    numero->denominator = (num1->denominator * num2->denominator);

    return numero;
}

RACIONAL* restarRacionales(RACIONAL* num1, RACIONAL* num2)
{
    RACIONAL* numero = (RACIONAL*) malloc(sizeof(RACIONAL));

    numero->numerador = (num1->numerador * num2->denominator) - (num2->numerador * num1->denominator);
    numero->denominator = (num1->denominator * num2->denominator);

    return numero;
}

int main()
{
    return 0;
}