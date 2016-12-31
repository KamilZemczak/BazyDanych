package Zadanie1;

/**
 *
 * @author Kamil Zemczak
 */
public class BazyDanychSingleton {

    public static void main(String[] args) {
        try {
            Polaczenie db = Polaczenie.getConnector();
            System.out.println("Udało się połączyć z bazą danych.");
        } catch (Exception e) {
            System.out.println("Próba połączenia zakończona niepowodzeniem. " + e.getMessage());
        }
    }
}
