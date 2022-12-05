#include <iostream>
#include <string.h>
using namespace std;

struct Trabajador
{
    int inscripcion;
    char nombre[50];
    // char* nombre;
    int clase;
    float horasNorm;
    float horasExt;
};

Trabajador* crearTrabajador(int insc, const char* nom, int cla, float hNorm, float hExt)
{
    Trabajador *trab = (Trabajador*)malloc(sizeof(Trabajador));
    trab->inscripcion = insc;
    strcpy(trab->nombre,nom);
    trab->clase = cla;
    trab->horasNorm = hNorm;
    trab->horasExt = hExt;

    return trab;
}


void imprBoleta(Trabajador* trab[], float salaR, int sizeArr)
{
    float salarioBase, salarioNorm, salarioExtra, salarioBruto, salarioNeto, descuentoTot;

    for(int i = 0; i < sizeArr; i++)
    {
        if(trab[i]->clase == 1)
    {
        salarioBase = 1.3 * salaR;
        salarioNorm = salarioBase * trab[i]->horasNorm;
        salarioExtra = 1.3 * salarioBase * trab[i]->horasExt;
        salarioBruto = salarioNorm + salarioExtra;
        descuentoTot = salarioBruto * 0.11;
        salarioNeto = salarioBruto - descuentoTot;
    }else if(trab[i]->clase == 2)
    {
        salarioBase = 1.9 * salaR;
        salarioNorm = salarioBase * trab[i]->horasNorm;
        salarioExtra = 1.3 * salarioBase * trab[i]->horasExt;
        salarioBruto = salarioNorm + salarioExtra;
        descuentoTot = salarioBruto * 0.11;
        salarioNeto = salarioBruto - descuentoTot;
    }else
    {
        salarioBase = 0;
        salarioNorm = 0;
        salarioExtra = 0;
        salarioBruto = 0;
        descuentoTot = 0;
        salarioNeto = 0;
    }
    
    cout << "NUMERO DE INSCRIPCION: " << trab[i]->inscripcion << "\t" << "Nombre: " << trab[i]->nombre << endl;
    cout << "MONTO POR HORAS NORMALES: " << salarioNorm << endl;
    cout << "MONTO POR HORAS EXTRA:" << salarioExtra << endl;
    cout << "IMPUESTO:" << descuentoTot << endl;
    cout << "SALARIO NETO A RECIBIR: " << salarioNeto << endl;
    }
}

int main()
{
    Trabajador* trabajadores[3];
    
    Trabajador* t1 = crearTrabajador(1,"Arnold",1,10,3);
    Trabajador* t2 = crearTrabajador(1,"Ana",2,10,5);
    Trabajador* t3 = crearTrabajador(1,"Jacquie",1,5,5);

    trabajadores[0] = t1;
    trabajadores[1] = t2;
    trabajadores[2] = t3;
    float salarioRef;
    cout << "Ingrese el salario x hora de referencia: "; cin >> salarioRef; cin.ignore();
    imprBoleta(trabajadores, salarioRef,3);

    return 0;
}