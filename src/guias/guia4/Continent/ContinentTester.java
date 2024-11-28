package guias.guia4.Continent;


public class ContinentTester {

    public static void main(String[] args) {
        System.out.println("Densidades de población:");
        for(Continent continent : Continent.values()) {
            System.out.printf("%s = %.2f%n", continent, continent.getPopulationRatio());
        }
        System.out.printf("%.2f", Continent.valueOf("AMERICA").getPopulationRatio());


    }

}


