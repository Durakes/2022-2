#include <iostream>
using namespace std;

struct Alumno
{
    string *nombre;
    double n1;
    double n2;
};

Alumno* crearEstudiante(string nombre, double n1, double n2)
{
    Alumno* alumno = (Alumno*) malloc(sizeof(Alumno));

    alumno->nombre = &nombre;
    alumno->n1 = n1;
    alumno->n2 = n2;

    if(alumno != NULL)
    {
        return alumno;
    }else
    {
        return NULL;
    }
}

double promedio(Alumno* alumno)
{
    return (alumno->n1 + alumno->n2) / 2;
}

void liberarEstudiante(Alumno* alumno)
{
    cout << "Alumno: " << *alumno->nombre << endl;
    //free(alumno->nombre);
    free(alumno);
    cout << "Memoria liberada" << endl;
    cout << endl;
}


int main()
{
    Alumno *a1, *a2;

    a1 = crearEstudiante("Juan", 10.0, 15.0);
    a2 = crearEstudiante("Ana", 11.0, 12.00);

    system("cls");
    cout << "Promedio de alumno " << *a1->nombre << ": " << promedio(a1) << endl;
    cout << "Promedio de alumno " << *a2->nombre << ": " << promedio(a2) << endl;
    cout << endl;

    liberarEstudiante(a1);
    
    liberarEstudiante(a2);
    system("pause");

    return 0;
}