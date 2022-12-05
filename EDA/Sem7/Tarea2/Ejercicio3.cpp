#include <iostream>

using namespace std;

struct tiponombre 
{ 
    char first[10]; 
    char midinit; 
    char last[20]; 
};

struct persona 
{ 
    struct tiponombre nombre; 
    int nacimiento[2]; 
    struct tiponombre parientes[2]; 
    int income; 
    int numhijos; 
    char direccion[20]; 
    char ciudad[10]; 
    char region[2]; 
}; 



int main()
{
    struct persona p[400];

    cout << "El tamanho en bytes de p[100] es: " << sizeof(p) << endl;
    cout << "El tamanho en bytes de p[10] es: " << sizeof(p[10]) << endl;
    cout << "El tamanho en bytes de p[10] es: " << sizeof(p[200].nombre.midinit) << endl;
    cout << "El tamanho en bytes de p[10] es: " << sizeof(p[20].income) << endl;
    cout << "El tamanho en bytes de p[10] es: " << sizeof(p[20].direccion[5]) << endl;
    cout << "El tamanho en bytes de p[10] es: " << sizeof(p[5].parientes[1].last[10]) << endl;
    return 0;
}