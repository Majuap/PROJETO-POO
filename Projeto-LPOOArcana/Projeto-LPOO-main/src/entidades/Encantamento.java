package entidades;

public class Encantamento extends Cartas {
    private Object efeitoContinuo;
    private int turnodoefeitoContinuo;


    public Encantamento(String nome, int custoMana, String descricao,Object efeitoContinuo,int turnodoefeitoContinuo) {
        super(nome, custoMana, descricao);
        this.efeitoContinuo = efeitoContinuo;
        this.turnodoefeitoContinuo = turnodoefeitoContinuo;
    }
    public void aplicarEfeito() {
        if (efeitoContinuo instanceof Runnable) {
            ((Runnable) efeitoContinuo).run();
            System.out.println("O encantamento " + getNomeCarta() + " foi ativado!");
        }
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + "\n" +
                "Custo: " + custoMana + "\n" +
                "Descrição: " + descricao + "\n";
    }
    public void setTurnoDoEfeitoContinuo(int i,Jogador jogador,Encantamento encantamento) {
        if (i > 0) {
            encantamento.aplicarEfeito();
            this.turnodoefeitoContinuo -= i;
        }
        else {
            System.out.println("Encantamento: "+nome+", seu efeito foi retirado do campo");
            jogador.getCampo().getCemiterio().add(encantamento);
            jogador.getCampo().getEncantamentosnoCampo().remove(encantamento);
        }
    }

}
