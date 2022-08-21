public class E11 
{
    public static void main(String[] args)
    {
        double nota;

        System.out.println("Ingrese la nota del alumno");
        nota = Double.parseDouble(System.console().readLine());

        if(nota < 0 || nota > 20)
        {
            System.out.println("Nota incorrecta");
        }else
        {
            if(nota < 12.5)
            {
                System.out.println("Alumno desaprobado");
            }else
            {
                System.out.println("Alumno aprobado");
            }
        }
    }
}
