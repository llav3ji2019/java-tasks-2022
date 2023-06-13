package code.homework3.vet;

public class Cow extends Animal implements Pet {
    public Cow() {
        super(4);
    }

    @Override
    public String say() {
        return "Moo-Moo";
    }

    @Override
    public MoveType moveType() {
        return MoveType.RUN;
    }
}
