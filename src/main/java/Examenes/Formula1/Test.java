package Examenes.Formula1;

public class Test {
    public static void main(String[] args) {
        Circuito monaco = new Circuito("Monaco", 90, 0.90, 28);
        // Mercedes
        monaco.addMonoplaza(new MonoplazaElite(44, "Lewis Hamilton", "Mercedes", TipoRueda.C5, new Motor("Mercedes", 0.07, 620)));
        monaco.addMonoplaza(new Monoplaza(77, "Valtteri Bottas", "Mercedes", TipoRueda.C3, new Motor("Mercedes", 0.08, 615)));

        // Red Bull Racing
        monaco.addMonoplaza(new MonoplazaElite(33, "Max Verstappen", "Red Bull Racing", TipoRueda.C4, new Motor("Honda", 0.06, 610)));
        monaco.addMonoplaza(new MonoplazaElite(11, "Sergio Pérez", "Red Bull Racing", TipoRueda.C3, new Motor("Honda", 0.07, 605)));

        // Ferrari
        monaco.addMonoplaza(new MonoplazaElite(16, "Charles Leclerc", "Ferrari", TipoRueda.C4, new Motor("Ferrari", 0.05, 600)));
        monaco.addMonoplaza(new MonoplazaElite(55, "Carlos Sainz", "Ferrari", TipoRueda.C3, new Motor("Ferrari", 0.05, 600)));

        // McLaren
        monaco.addMonoplaza(new Monoplaza(3, "Daniel Ricciardo", "McLaren", TipoRueda.C2, new Motor("Mercedes", 0.06, 595)));
        monaco.addMonoplaza(new MonoplazaElite(4, "Lando Norris", "McLaren", TipoRueda.C2, new Motor("Mercedes", 0.05, 595)));

        // Alpine
        monaco.addMonoplaza(new MonoplazaElite(14, "Fernando Alonso", "Alpine", TipoRueda.C3, new Motor("Renault", 0.08, 590)));
        monaco.addMonoplaza(new Monoplaza(31, "Esteban Ocon", "Alpine", TipoRueda.C3, new Motor("Renault", 0.07, 585)));

        // Aston Martin
        monaco.addMonoplaza(new MonoplazaElite(5, "Sebastian Vettel", "Aston Martin", TipoRueda.C4, new Motor("Mercedes", 0.07, 580)));
        monaco.addMonoplaza(new Monoplaza(18, "Lance Stroll", "Aston Martin", TipoRueda.C3, new Motor("Mercedes", 0.06, 575)));

        // Alfa Romeo Racing
        monaco.addMonoplaza(new Monoplaza(7, "Kimi Räikkönen", "Alfa Romeo Racing", TipoRueda.C4, new Motor("Ferrari", 0.08, 570)));
        monaco.addMonoplaza(new Monoplaza(99, "Antonio Giovinazzi", "Alfa Romeo Racing", TipoRueda.C3, new Motor("Ferrari", 0.07, 565)));

        // AlphaTauri
        monaco.addMonoplaza(new Monoplaza(10, "Pierre Gasly", "AlphaTauri", TipoRueda.C4, new Motor("Honda", 0.06, 560)));
        monaco.addMonoplaza(new Monoplaza(22, "Yuki Tsunoda", "AlphaTauri", TipoRueda.C3, new Motor("Honda", 0.05, 555)));

        // Haas
        monaco.addMonoplaza(new Monoplaza(9, "Nikita Mazepin", "Haas", TipoRueda.C4, new Motor("Ferrari", 0.07, 550)));
        monaco.addMonoplaza(new Monoplaza(47, "Mick Schumacher", "Haas", TipoRueda.C3, new Motor("Ferrari", 0.08, 545)));
        monaco.simularCarrera();


    }
}
