package chapter1.Pockemon;

public class MiniPokemonSimulator {
    public static void main(String[] args) {
        Pockemon pikachu = new Pikachu();
        pikachu.growl();
        pikachu.performAttack();

        Pockemon yadoran = new Yadoran();
        yadoran.growl();
        yadoran.performAttack();

        Pockemon ppippi = new Ppippi();
        ppippi.growl();
        ppippi.performAttack();
    }
}
