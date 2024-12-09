package rpg.factory;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Clase que genera enemigos de manera aleatoria.
 * Utiliza la libreria Reflections para buscar todas las clases que extienden de Enemy
 * y selecciona un enemigo de tipo basico aleatoriamente.
 */
public class EnemyFactory {

    /**
     * Generador de numeros aleatorios.
     */
    private static final Random random = new Random();

    /**
     * Metodo que obtiene un enemigo aleatorio de tipo basico.
     * Se filtran las clases de enemigos por el tipo especificado
     * y se selecciona una de ellas al azar.
     *
     * @return una instancia de Enemy de tipo basico o null si ocurre un error.
     */
    public static Enemy getEnemy() {

        Enemy enemyInstance; // Instancia del enemigo a devolver
        Set<Class<? extends Enemy>> enemyClasses; // Conjunto de clases que extienden de Enemy
        List<Class<? extends Enemy>> classList; // Lista filtrada de clases

        // Configura Reflections para buscar clases en el classpath
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new SubTypesScanner(), new FieldAnnotationsScanner()));

        // Obtiene todas las clases que extienden de Enemy
        enemyClasses = reflections.getSubTypesOf(Enemy.class);

        // Filtra las clases para obtener solo las de tipo basico
        classList = filterList(enemyClasses.stream().toList(), EnemyType.BASIC);

        try {
            int randomIndex; // Indice aleatorio para seleccionar un enemigo
            if (classList != null && !classList.isEmpty()) {
                // Selecciona un enemigo aleatorio de la lista filtrada
                randomIndex = random.nextInt(classList.size());
                enemyInstance = classList.get(randomIndex).getDeclaredConstructor().newInstance();
            } else {
                throw new Exception("No se encontraron enemigos de tipo basico");
            }
        } catch (Exception e) {
            return null; // Retorna null si ocurre un error
        }
        return enemyInstance; // Retorna el enemigo seleccionado
    }

    /**
     * Metodo que filtra las clases de enemigos segun el tipo especificado.
     *
     * @param classList lista de clases de enemigos a filtrar.
     * @param enemyType tipo de enemigo a seleccionar.
     * @return lista de clases de enemigos que coinciden con el tipo especificado.
     */
    private static List<Class<? extends Enemy>> filterList(List<Class<? extends Enemy>> classList, EnemyType enemyType) {

        Enemy enemy; // Instancia temporal para verificar el tipo de enemigo
        List<Class<? extends Enemy>> classListFiltered = new ArrayList<>(); // Lista filtrada

        // Itera sobre todas las clases de enemigos
        for (Class<? extends Enemy> enemyClass : classList) {
            try {
                // Crea una instancia de la clase Enemy
                enemy = enemyClass.getDeclaredConstructor().newInstance();

                // Si el tipo del enemigo coincide con el tipo especificado, lo agrega a la lista filtrada
                if (enemy.getType() == enemyType) {
                    classListFiltered.add(enemyClass);
                }
            } catch (Exception e) {
                return null; // Retorna null si ocurre un error al crear la instancia
            }
        }
        return classListFiltered; // Retorna la lista de clases filtradas
    }
}