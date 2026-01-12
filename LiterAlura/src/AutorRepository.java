import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("""
        SELECT a FROM Autor a
        WHERE :ano BETWEEN a.anoNascimento AND a.anoFalecimento
    """)
    List<Autor> autoresVivosNoAno(Integer ano);
    Optional<Autor> findByNomeIgnoreCase(String nome);
}
