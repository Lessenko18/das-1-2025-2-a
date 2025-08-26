package br.univille.observer;

public class Cliente {
    public static void main(String[] args) {
        var grupoFamilia = new Publisher();

        var zezinho = new ConcreteSubscriber();
        var huguinho = new ConcreteSubscriber();
        var titia = new ConcreteSubscriber();

        grupoFamilia.subscribe(zezinho);
        grupoFamilia.subscribe(huguinho);
        grupoFamilia.subscribe(titia);

        grupoFamilia.setMainState("Bom dia!!!!❤️");
        grupoFamilia.notifySubscribers();
    }
}
