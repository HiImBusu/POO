package Examenes._19JunioRegistroCivil.Solucion;

public class PruebaNombre {
    public static void main(String[] args) {
        args = new String[]{"Charlotte", "F", "Lorena", "F", "Gael", "M", "Alexis", "M"};
        if(args.length % 2 != 0)
            System.err.println("No se proporcionan valores suficientes como argumentos");

        String nom, gen;
        for(int i = 0; i < args.length; i += 2){

                nom = args[i];
                gen = args[i + 1];
                if(gen.length() != 1)
                    System.err.println("Algunos de los valores introducidos como género no es una cadena de un unico caracter");

                if(gen.charAt(0) != 'F' && gen.charAt(0) != 'M')
                    System.err.println("Algunos de los valores introducidos como género es una cadena de un único carácter, pero no es ni F ni M");

                Nombre ins = new Nombre(gen.charAt(0), nom);
                System.out.println(ins);
        }
    }
}
