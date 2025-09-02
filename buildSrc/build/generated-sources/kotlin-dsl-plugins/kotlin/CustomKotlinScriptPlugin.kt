/**
 * Precompiled [custom-kotlin-script.gradle.kts][Custom_kotlin_script_gradle] script plugin.
 *
 * @see Custom_kotlin_script_gradle
 */
public
class CustomKotlinScriptPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Custom_kotlin_script_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
