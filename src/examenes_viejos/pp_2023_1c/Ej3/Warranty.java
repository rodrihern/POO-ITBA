package examenes_viejos.pp_2023_1c.Ej3;

public enum Warranty {
    BASIC {
        @Override
        public double getIncrement(double price) {
            return 120;
        }
    },
    PREMIUM {
        @Override
        public double getIncrement(double price) {
            return price * 0.2;
        }
    };

    public abstract double getIncrement(double price);
}
