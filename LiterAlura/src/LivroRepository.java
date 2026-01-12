import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdiomaIgnoreCase(String idioma);
}
