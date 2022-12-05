#include <iostream>
#include <vector>
using namespace std;

typedef struct estudiante
{
    string apellido;
    string nombre;
    float nota;
} Estudiante;

typedef struct empleado
{
    string apellido;
    string nombre;
    float salario;
} Empleado;

void ingresarDato(vector<Empleado> *empleados, vector<Estudiante> *estudiantes)
{
    int index;
    cout << "Ingrese el tipo de dato que desea ingresar: " << endl;
    cout << "Empleado [1]" << endl;
    cout << "Estudiante [2]" << endl;
    cin >> index;

    if(index == 1)
    {
        Empleado empleado;
        cout << "Ingrese el nombre del empleado: " << endl;
        cin >> empleado.nombre;
        cout << "Ingrese el apellido del empleado: " << endl;
        cin >> empleado.apellido;
        cout << "Ingrese el salario del empleado: " << endl;
        cin >> empleado.salario;

        empleados->push_back(empleado);

    }else if(index == 2)
    {
        Estudiante estudiante;
        cout << "Ingrese el nombre del empleado: " << endl;
        cin >> estudiante.nombre;
        cout << "Ingrese el apellido del empleado: " << endl;
        cin >> estudiante.apellido;
        cout << "Ingrese el salario del empleado: " << endl;
        cin >> estudiante.nota;

        estudiantes->push_back(estudiante);
    }else
    {
        cout << "Ingrese una opcion correcta" << endl;
        ingresarDato(empleados, estudiantes);
    }
}


int main()
{
    vector<Estudiante> estudiantes;
    vector<Empleado> empleados;

    ingresarDato(&empleados, &estudiantes);
    return 0;
}