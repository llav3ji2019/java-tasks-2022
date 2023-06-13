package code.homework3.vet;

public class Dog extends Animal implements Pet {
    public Dog() {
        super(4);
    }

    @Override
    public String say() {
        return "Wow-wow";
    }

    @Override
    public MoveType moveType() {
        return MoveType.RUN;
    }
}
