import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pessoa {

    private final String cpf;
    private final String nome;
    private final List<Cachorro> cachorros = new ArrayList();


    public Pessoa(String cpf, String nome){
        verificarCPF(cpf);
        this.cpf = cpf;
        this.nome = nome;
    }

    private void verificarCPF(String cpf){
        Pattern pattern = Pattern.compile("[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9][0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher((cpf));
        if(!(matcher.find() && cpf.length() == 14))
            throw new IllegalArgumentException();
    }

    public void addCachorro(String nome,String raca ,boolean vacinado){
        cachorros.add(new Cachorro(nome, raca, vacinado));
    }

    public String listarCachorros(){
        StringBuilder todosCachorros = new StringBuilder();
        for (Cachorro cachorro : cachorros) {
            todosCachorros.append(cachorro);
            todosCachorros.append("\n");
        }
        return todosCachorros.toString();
    }

    public boolean removeCachorro(String nome){
        for (Cachorro cachorro : cachorros) {
            if(cachorro.getNome().equals(nome)){
                cachorros.remove(cachorro);
                return true;
            }
        }
        return false;
    }

    public String listarCachorros(boolean vacinado){
        StringBuilder cachorrosVacinados = new StringBuilder();
        for (Cachorro cachorro : cachorros) {
            if(cachorro.isVacinado() == vacinado) {
                cachorrosVacinados.append(cachorro);
                cachorrosVacinados.append("\n ");
            }
        }
        return cachorrosVacinados.toString();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
