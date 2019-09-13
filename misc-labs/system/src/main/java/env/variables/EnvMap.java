package env.variables;

import java.util.Map;

/**
 * https://docs.oracle.com/javase/tutorial/essential/environment/env.html
 * Get the environment variables to hash map and print them.
 */
public class EnvMap {

    public static void main (String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName)
            );
        }
    }
}

