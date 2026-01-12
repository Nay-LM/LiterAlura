import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    private final CatalogoService service;
    private Scanner scanner = new Scanner(System.in);

    public Principal(CatalogoService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores
                4 - Listar autores em determinado ano
                5 - Listar livros por idioma
                0 - Sair
            """);

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o título: ");
                    service.buscarLivroPorTitulo(scanner.nextLine());
                }
                case 2 -> service.listarLivros();
                case 3 -> service.listarAutores();
                case 4 -> {
                    System.out.print("Digite o ano: ");
                    service.autoresPorAno(scanner.nextInt());
                }
                case 5 -> {
                    System.out.print("Idioma (PT, EN, FR, ES): ");
                    service.livrosPorIdioma(scanner.nextLine());
                }
            }
        }
    }
}
