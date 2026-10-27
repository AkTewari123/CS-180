public class Character {

    public String name;
    private int level;

    public Character(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("%s (Level %d)", name, level);
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Character otherChar) {
            return this.name.equals(otherChar.getName()) && this.level == otherChar.getLevel();
        }
        return false;

    }

    public void printInfo() {
        IO.println(name);
    }

    void main() {

        Character c1 =
            new Character("Steve", 10);

        Character c2 =
            new Character("Steve", 10);

        IO.println("Name: "
            + c1.getName());

        IO.println("Level: "
            + c1.getLevel());

        IO.println();
        IO.println(c1);

        IO.println();
        IO.println(
            "Characters Equal: "
            + c1.equals(c2));
    }
}