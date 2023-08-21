public class Main {

    public static void main(String[] args) {

        final Petshop petshop = new Petshop();

        //implementações teste
        petshop.addPessoa("000.000.000-00", "Maria");
        petshop.addPessoa("111.111.111-11", "João");
        petshop.addPessoa("222.222.222-22", "Ana");
        petshop.addPessoa("333.333.333-33", "Carolina");
        petshop.addPessoa("444.444.444-44", "Ricardo");
        petshop.addPessoa("555.555.555-55", "Mariana");
        petshop.addCachorroCliente("000.000.000-00", "Max", "Labrador", true);
        petshop.addCachorroCliente("000.000.000-00", "Bella", "Labrador", true);
        petshop.addCachorroCliente("111.111.111-11", "Toby", "Bulldog", false);
        petshop.addCachorroCliente("111.111.111-11", "Lola", "Bulldog", true);
        petshop.addCachorroCliente("222.222.222-22", "Ziggy", "Golden Retriever", false);
        petshop.addCachorroCliente("333.333.333-33", "Rex", "Pastor Alemão", true);
        petshop.addCachorroCliente("333.333.333-33", "Nina", "Yorkshire", false);
        petshop.addCachorroCliente("444.444.444-44", "Rocky", "Bulldog Francês", true);
        petshop.addCachorroCliente("555.555.555-55", "Luna", "Poodle", true);



        Menu menu = new Menu();
        while(menu.menu(petshop));

    }









}


