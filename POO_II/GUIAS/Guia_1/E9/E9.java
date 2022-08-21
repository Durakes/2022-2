public class E9 
{
    public static void main(String[] args)
    {
        double radio, hipotenusa, altura, areaTriangulo, areaCirculo, areaTotal;

        System.out.println("Ingrese el radio R");
        radio = Double.parseDouble(System.console().readLine());

        System.out.println("Ingrese la hipotenusa H");
        hipotenusa = Double.parseDouble(System.console().readLine());

        altura = Math.sqrt((hipotenusa * hipotenusa) - (radio * radio));
        areaTriangulo = radio * altura;
        areaCirculo = (Math.PI * radio * radio) / 2;
        areaTotal = Math.round((areaCirculo + areaTriangulo) * 100);

        System.out.println("El area total es: " + areaTotal / 100);
    }
}
