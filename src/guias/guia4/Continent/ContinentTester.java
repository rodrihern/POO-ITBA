package guias.guia4.Continent;


public class ContinentTester {

    public static void main(String[] args) {
        System.out.println("Densidades de población:");
        for(Continent continent : Continent.values()) {
            System.out.println("%s = %.2f".formatted(continent, continent.getPopulationRatio()));
        }
        System.out.printf("%.2f", Continent.valueOf("AMERICA").getPopulationRatio());
    }

}


