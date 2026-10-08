public class Pokemon {
    private String name;
    private String type;
    private int attack;
    private int defense;
    private int level;

    public Pokemon (String name, String type, int attack, int defense, int level) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
    }

    public Pokemon(String name, String type) {
        this(name, type, 50, 50, 1);
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public int getLevel() {
        return level;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        String bio = String.format("Name: %s\n", name);
        bio += String.format("Type: %s\n", type);
        bio += String.format("Attack: %s\n", attack);
        bio += String.format("Defense: %s\n", defense);
        bio += String.format("Level: %s", level);
        return bio;
    }

    @Override 
    public boolean equals(Object o) {
        if (o instanceof Pokemon otherPokemon) {
            boolean equals = true;
            equals = this.type.equals(otherPokemon.getType());
            equals = equals && this.attack == otherPokemon.getAttack();
            equals = equals && this.defense == otherPokemon.getDefense();
            equals = equals && this.level == otherPokemon.getLevel();
            equals = equals && this.name.equals(otherPokemon.getName());
            return equals;
        }
        return false;
    }

}
