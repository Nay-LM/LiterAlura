@Service
public class CatalogoService {

    private final LivroRepository livroRepo;
    private final AutorRepository autorRepo;
    private final ConsumoApi consumoApi;
    private final ConversorDados conversor;

    public CatalogoService(...) {
        this.livroRepo = livroRepo;
        this.autorRepo = autorRepo;
        this.consumoApi = consumoApi;
        this.conversor = conversor;
    }

    public void buscarLivroPorTitulo(String titulo) {
        String url = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");
        String json = consumoApi.obterDados(url);
    }

    public void listarLivros() {
        livroRepo.findAll().forEach(System.out::println);
    }

    public void listarAutores() {
        autorRepo.findAll().forEach(System.out::println);
    }

    public void autoresPorAno(Integer ano) {
        autorRepo.autoresVivosNoAno(ano).forEach(System.out::println);
    }

    public void livrosPorIdioma(String idioma) {
        var livros = livroRepo.findByIdiomaIgnoreCase(idioma);
        if (livros.isEmpty()) {
            System.out.println("Não existem livros nesse idioma.");
        } else {
            livros.forEach(System.out::println);
        }
    }
}
