public class Move {
    String name;
    String type;
    int power;
    public Move(String name, String type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }
    public int calculateDamage(Pokemon attacker, Pokemon defender) {
        int damage = power + attacker.getAttack() - defender.getDefense();
        damage += attacker.getLevel() - defender.getLevel();
        return damage < 1 ? 1 : damage;
    }
    public String toString() {
        String bio = String.format("Move: %s\n", name);
        bio += String.format("Type: %s", type);
        bio += String.format("Power: %s", power);
        return bio;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getPower() {
        return power;
    }
    public boolean equals(Object o) {
        if (o instanceof Move otherMove) {
            boolean equals = true;
            equals = equals && this.name.equals(otherMove.getName());
            equals = equals && this.type.equals(otherMove.getType());
            equals = equals && this.power == otherMove.getPower();
            return equals;
        }
        return false;
    }
}
