package rpg.entities.enemy;

import rpg.entities.GameCharacter;
import rpg.entities.Player;
import rpg.enums.Stats;

public class Enemy extends GameCharacter {

    /**
     * Anexar el atributo para el tipo de enemigo
     */
    private String enemyType;

    /**
     * Agregar constructor que solo acepte nombre y tipo de enemigo
     * @param name
     * @param enemyType
     */
    public Enemy(String name, String enemyType) {
        /**
         * Llamar al constructor de GameCharacter
         */
        super(name);
        this.enemyType = enemyType;
        /**
         * Inicializar los stats específicos del enemigo
         */
        this.stats.put(Stats.HP, 110);
        this.stats.put(Stats.ATTACK, 7);
        this.stats.put(Stats.DEFENSE, 3);
    }

    /**
     * Agregar constructor que solo acepte nombre y tipo de enemigo
     * @param name
     */
    public Enemy(String name) {
        /**
         * Llamar al constructor con un tipo de enemigo por defecto
         */
        this(name, "Tipo Desconocido");
    }

    /**
     * Función para obtener el tipo de enemigo
     * @return
     */
    public String getEnemyType() {
        return this.enemyType;
    }

    public int getInitialHP (){
        return getInitialHP();
    }

    private int life;

    public void takeDamage(int damage) {
        this.stats.put(Stats.HP, this.stats.get(Stats.HP) - damage);
        if (this.stats.get(Stats.HP) < 0) {
            this.stats.put(Stats.HP, 0);  // Asegura que no pase de cero
        }
    }


    public boolean isDead() {
        return this.stats.get(Stats.HP) <= 0;
    }


    /**
     * Función para atacar al jugador
     */
    public int attack(Player player) {
        int attackPower = this.stats.get(Stats.ATTACK);
        player.receiveDamage(attackPower);
        System.out.println(this.name + " attacks " + player.getName() + " for " + attackPower + " damage!");
        return attackPower;
    }

}