import java.util.Random;

public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String toString() {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent) {
        Random random = new Random();
        double chance = random.nextDouble();

        if (chance < 0.5) {
            opponent.hitPoints -= 10;
        } else {
            this.hitPoints -= 10;
        }
    }

    public void senzuBean() {
        this.hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            this.attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        this.senzuBean();
        opponent.senzuBean();
        this.fightUntilTheDeathHelper(opponent);
        return this.name + ": " + this.hitPoints + "    " + opponent.name + ": " + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int[] wins = new int[2];
        for (int i = 0; i < n; i++) {
            this.senzuBean();
            opponent.senzuBean();
            this.fightUntilTheDeathHelper(opponent);
            if (this.hitPoints > 0) {
                wins[0]++;
            } else {
                wins[1]++;
            }
        }
        return wins;
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] wins = nFightsToTheDeathHelper(opponent, n);
        if (wins[0] > wins[1]) {
            return this.name + ": " + wins[0] + " wins " + opponent.name + ": " + wins[1] + " wins\n" + this.name + " wins!";
        } else if (wins[1] > wins[0]) {
            return this.name + ": " + wins[0] + " wins " + opponent.name + ": " + wins[1] + " wins\n" + opponent.name + " wins!";
        } else {
            return this.name + ": " + wins[0] + " wins " + opponent.name + ": " + wins[1] + " wins\nOMG! It was actually a draw!";
        }
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        this.senzuBean();
        opponent.senzuBean();
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            this.attack(opponent);
            System.out.println(this.name + ": " + this.hitPoints + " " + opponent.name + ": " + opponent.hitPoints);
        }

        if (this.hitPoints > 0) {
            System.out.println(this.name + " wins!");
        } else {
            System.out.println(opponent.name + " wins!");
        }
    }
}