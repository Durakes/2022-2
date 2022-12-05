#include <iostream>
using namespace std;

struct desempeno
{ 
    int numeroCorrectas ;  /* numero de preguntas correctas*/ 
    int tiempo;  /* tiempo total de termino, en minutos */ 
}; 
typedef struct desempeno Desempeno; 

struct identificacion
{ 
    int inscripcion;  /* numero de inscripcion del participante*/ 
    char nombre[31]; 
    int edad; 
}; 
typedef struct identificacion Identificacion; 

struct participante
{ 
    Identificacion identif; 
    Desempeno desemp; /* desempeno del participante */ 
}; 
typedef struct participante Participante;

int comparaDesempeno(Desempeno *des1, Desempeno *des2)
{
    if(des1->numeroCorrectas > des2->numeroCorrectas)
    {
        return 1;
    }else if(des1->numeroCorrectas == des2->numeroCorrectas)
    {
        if(des1->tiempo < des2->tiempo)
        {
            return 1;
        }else if (des1->tiempo = des2->tiempo)
        {
            return 0;
        }else
        {
            return -1;
        }
    }else
    {
        return -1;
    }
}

Identificacion* ObtenerIdentificaciones(Participante participantes[], int numeroParticipantes, Desempeno d, int *numSuperior)
{
    int index = 0;
    for(int i = 0; i < numeroParticipantes; i++)
    {
        if(comparaDesempeno(&participantes[i].desemp, &d) == 1)
        {
            index++;
        }
    }
    Identificacion *identificacionesx = (Identificacion*) malloc(index * sizeof(Identificacion));
    index = 0;

    for(int i = 0; i < numeroParticipantes; i++)
    {
        if(comparaDesempeno(&participantes[i].desemp, &d) == 1)
        {
            identificacionesx[index] = participantes[i].identif;
            index++;
        }
    }

    *numSuperior = index;

    if(identificacionesx != NULL)
    {
        return identificacionesx;
    }else
    {
        cout << "No fue posible separar espacio" << endl;
        return NULL;
    }
}

int main()
{
    int numParticipantes = 6;
    Participante participantes[numParticipantes] = {{{1111,"Maria Clara",10},{3,60}}, 
                                    {{1245,"Jose Alvarado",9},{4,50}}, 
                                    {{1457,"Ana Maria S",10},{2,30}}, 
                                    {{1559,"Bianca Mayta",10},{5,70}}, 
                                    {{9874,"Teresa Carmona",9},{3,30}}, 
                                    {{9987,"Camila Gonzales",9},{3,70}}};

    Desempeno d = {3,45};
    int numSuperior;

    Identificacion* identificacionesMayores = ObtenerIdentificaciones(participantes, numParticipantes, d, &numSuperior);

    system("cls");
    if(numSuperior != 0)
    {
        cout << "El numero total con desempeno optimo es: " << numSuperior << endl;
        cout << "Los alumnos son: " << endl;
        for (int i = 0; i < numSuperior; i++)
        {
            cout << "{" << identificacionesMayores[i].inscripcion << ", " << identificacionesMayores[i].nombre << ", " << identificacionesMayores[i].edad << "}" << endl;
        }
    }else
    {
        cout << "No se encontro ningun participante con un desempeno optimo" << endl;
    }

    return 0;
}