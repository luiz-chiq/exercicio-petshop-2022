public class Cachorro {
    private final String raca;
    private final String nome;
    boolean vacinado;

    public Cachorro(String nome, String raca, boolean vacinado){
        this.nome = nome;
        this.raca = raca;
        this.vacinado = vacinado;
    }

    public String getNome() {
        return nome;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    @Override
    public String toString() {
        return "Cachorro{" +
                "raca='" + raca + '\'' +
                ", nome='" + nome + '\'' +
                ", vacinado=" + (vacinado?"sim":"não") +
                '}';
    }
}
