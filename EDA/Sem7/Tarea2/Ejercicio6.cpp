#include <iostream>
using namespace std;

struct datos
{
    int edad;
    bool sexo;
};

struct empleado
{
    char nombre[100];
    double salario;
    datos dato;
};


int main()
{
    empleado emp;
    return 0;
}