public class Main {
    public static void main(String[] args) {

        Empresa leti = new Empresa("LetiTransportes");
        leti.criar_hubs_default();
        leti.criar_camioes_default();
        leti.camioes_to_hubs();
        leti.String();

    }
}