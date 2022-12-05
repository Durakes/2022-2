#include <iostream>
#include <cmath>
#include <string>
#include <vector>
#include <sstream>
using namespace std;

struct real
{
    int left;
    int right;
};

typedef struct real Real;

vector<string> separarNumeros(double numero)
{
    stringstream sstream;
    sstream << numero;
    string numeroString = sstream.str();
    string tempNum = "";
    vector<string> numeros;
    for (auto x : numeroString)
    {
        if (x != '.')
        {
            tempNum += x;
        }
        else
        {
            
            numeros.push_back(tempNum);
            tempNum = "";
        }
    }
    numeros.push_back(tempNum);
    return numeros;
}

Real* recibirReal(double num)
{
    Real* real = (Real*) malloc(sizeof(Real));

    vector<string> elementos = separarNumeros(num);

    real->left = stoi(elementos[0]);
    real->right = stoi(elementos[1]);

    return real;
}

double mostrarReal(Real* num)
{
    double numero;

    stringstream sstream;
    sstream << num->right;
    string numeroString = sstream.str();
    int multiplo = pow(10, numeroString.size());
    numero = (double)num->left + (double)(num->right)/multiplo;

    return numero;
}

Real* sumaReales(Real* num1, Real*num2)
{
    Real* real = (Real*) malloc(sizeof(Real));
    double suma = mostrarReal(num1) + mostrarReal(num2);
    real = recibirReal(suma);

    return real;
}

Real* multiplicarReales(Real *num1, Real *num2)
{
    Real* real = (Real*) malloc(sizeof(Real));
    double suma = mostrarReal(num1) * mostrarReal(num2);
    real = recibirReal(suma);

    return real;
}

Real* restarReales(Real *num1, Real *num2)
{
    Real* real = (Real*) malloc(sizeof(Real));
    double suma = mostrarReal(num1) - mostrarReal(num2);
    real = recibirReal(suma);

    return real;
}

int main()
{
    double num = 12.11;
    double num2 = 54.56;

    Real *real, *real2, *realSuma, *realMultiplicacion, *realDiferencia;
    real = recibirReal(num);
    real2 = recibirReal(num2);

    float numero2 = mostrarReal(real);

    cout << endl;
    cout << "Numero 1: " << endl;
    cout << "Izquierda: " << real->left << endl;
    cout << "Derecha: " << real->right << endl;

    cout << endl;
    cout << "Numero 2: " << endl;
    cout << "Izquierda: " << real2->left << endl;
    cout << "Derecha: " << real2->right << endl;

    realSuma = sumaReales(real, real2);
    realMultiplicacion = multiplicarReales(real, real2);
    realDiferencia = restarReales(real, real2);

    cout << endl;
    cout << "Suma: " << endl;
    cout << "Izquierda: " << realSuma->left << endl;
    cout << "Derecha: " << realSuma->right << endl;

    cout << endl;
    cout << "Multiplicacion: " << endl;
    cout << "Izquierda: " << realMultiplicacion->left << endl;
    cout << "Derecha: " << realMultiplicacion->right << endl;

    cout << endl;
    cout << "Sustraccion: " << endl;
    cout << "Izquierda: " << realDiferencia->left << endl;
    cout << "Derecha: " << realDiferencia->right << endl;

    return 0;
}