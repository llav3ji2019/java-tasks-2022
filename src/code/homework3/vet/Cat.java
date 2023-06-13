package code.homework3.vet;

public class Cat extends Animal implements Pet {
    public Cat() {
        super(4);
    }

    @Override
    public String say() {
        return "Mow-Mow";
    }

    @Override
    public MoveType moveType() {
        return MoveType.RUN;
    }
}
