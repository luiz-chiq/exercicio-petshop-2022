import java.util.HashMap;
import java.util.Objects;

public class Petshop {
    public HashMap<String, Pessoa> pessoas = new HashMap<>();

    public String addPessoa(String cpf, String nome) {
        try {
            pessoas.put(cpf, new Pessoa(cpf, nome));
//            pessoas.put(cpf, new Pessoa(cpf, nome));
            return "Cliente adicionado";
        }
        catch (Exception e){
            return "Cliente não adicionado\nFormatação de CPF inválida, use: xxx.xxx.xxx-xx";
        }
    }

    public String listarPessoas(){
        StringBuilder todosPessoas = new StringBuilder();
        for (Pessoa pessoa : pessoas.values()) {
            todosPessoas.append(pessoa);
            todosPessoas.append("\n");
        }
        return todosPessoas.toString();
    }

    public String removePessoa(String cpf){
        if(!pessoas.containsKey(cpf)) return "Cliente não encontrado";
        pessoas.remove(cpf);
        return "Cliente removido";
    }

    public String addCachorroCliente(String cpf, String nome, String raca, boolean vacinado){
        try {
            pessoas.get(cpf).addCachorro(nome, raca, vacinado);
            return "Cachorro adicionado com sucesso";
        } catch (NullPointerException e) {
           return "Pessoa não encontrada";
        }

    }

    public String listarCachorrosCliente(String cpf){
        try {
            return pessoas.get(cpf).listarCachorros();
        } catch (NullPointerException e) {
            return "Pessoa não encontrada";
        }

    }

    public String removerCachorroCliente(String cpf,String nome){
        try {
            if (pessoas.get(cpf).removeCachorro(nome)) return "Cachorro removido com sucesso";
            return "Cachorro não encontrado";
        } catch (NullPointerException e) {
            return "Cliente não encontrado";
        }
    }

    public String listarCachorrosVacinados(boolean vacinados){
        StringBuilder todosCachorros = new StringBuilder();
        for (Pessoa pessoa : pessoas.values()) {
            todosCachorros.append(pessoa.listarCachorros(vacinados));
            todosCachorros.append("\n");
        }
        return todosCachorros.toString();
    }

    public String listarCachorrosVacinadosCliente(String cpf, boolean vacinados){
        if(verificar(cpf)) {
            String lista = pessoas.get(cpf).listarCachorros(vacinados);
            if (!Objects.equals(lista, ""))
                return lista;
        return (vacinados ? "sem cachorros vacinados" : "sem cachorros não vacinados");
        }
        return "pessoa não encontrada";
    }

    private boolean verificar(String cpf){
        try {
            if (!pessoas.containsKey(cpf)) throw new ClientNotFoundException();
            return true;
        } catch (ClientNotFoundException e) {
            return false;
        }
    }

}
