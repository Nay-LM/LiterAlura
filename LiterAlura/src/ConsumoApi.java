@Service
public class ConsumoApi {

    public String obterDados(String endereco) {
        return new RestTemplate().getForObject(endereco, String.class);
    }
}
