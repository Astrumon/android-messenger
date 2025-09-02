package com.ua.astrumon.templates.script

import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

class TemplateGeneratorImpl : TemplateGenerator {
    override fun generate(inputArgs: InputArgs) {
        val templateDir =
            this::class.java.classLoader.getResource("templates/${inputArgs.templateName}")
                ?.let { File(it.toURI()) }
                ?: throw IllegalArgumentException("Template '${inputArgs.templateName}' does not exist.")

        if (!templateDir.exists() || !templateDir.isDirectory) {
            throw IllegalArgumentException("Template '${inputArgs.templateName}' does not exist.")
        }

        val subdirectories = templateDir.listFiles { file -> file.isDirectory } ?: arrayOf()
        val modulePaths = if (subdirectories.size <= 1) {
            listOf(inputArgs.outputModuleName)
        } else {
            subdirectories.map { "${inputArgs.outputModuleName}:${it.name}" }
        }

        modulePaths.forEach { modulePath ->
            val moduleDir = convertModuleNameToPath(modulePath)
            val moduleSubDir = File(moduleDir)
            if (moduleSubDir.exists()) {
                throw IllegalArgumentException("Cannot create module at '$modulePath': directory already exists.")
            }
            moduleSubDir.mkdirs()

            val subDirName = modulePath.substringAfterLast(":")
            val sourceDir = if (subdirectories.size <= 1) {
                File(templateDir, "template-content")
            } else {
                File(templateDir, subDirName)
            }

            copyTemplateContents(sourceDir, moduleSubDir, inputArgs)
            adjustSourceFiles(moduleSubDir, inputArgs)
            createGitIgnore(moduleSubDir)
        }

        updateSettingsGradle(modulePaths)
    }

    private fun convertModuleNameToPath(moduleName: String): String {
        return moduleName.trimStart(':').replace(":", File.separator)
    }

    private fun copyTemplateContents(sourceDir: File, targetDir: File, inputArgs: InputArgs) {
        sourceDir.walkTopDown().forEach { file ->
            val targetFile = File(targetDir, file.relativeTo(sourceDir).path)

            if (file.isDirectory) {
                targetFile.mkdirs()
            } else {
                Files.copy(file.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
                replacePlaceholders(targetFile, inputArgs)
            }
        }
    }

    private fun replacePlaceholders(file: File, inputArgs: InputArgs) {
        val camelCaseModuleName = inputArgs.outputModuleName
            .split(":", "-")
            .filter { it.isNotBlank() }
            .joinToString("") { it.capitalize() }

        val content = file.readText()
            .replace("%PACKAGE%", inputArgs.outputModulePackage)
            .replace("%NAME%", camelCaseModuleName)
        file.writeText(content)

        if (file.name.contains("ModuleName")) {
            val newName = file.name.replace("ModuleName", camelCaseModuleName)
            file.renameTo(File(file.parentFile, newName))
        }
    }

    private fun adjustSourceFiles(dir: File, inputArgs: InputArgs) {
        val sourceRoots = listOf("src/main/java", "src/main/kotlin")
        sourceRoots.forEach { root ->
            val sourceDir = File(dir, root)
            if (sourceDir.exists()) {
                val packagePath = inputArgs.outputModulePackage.replace('.', File.separatorChar)
                val packageDir = File(sourceDir, packagePath)
                packageDir.mkdirs()
                sourceDir.walkTopDown()
                    .filter { it.isFile }
                    .forEach { file ->
                        val targetFile = File(packageDir, file.name)
                        file.renameTo(targetFile)
                    }
            }
        }
    }

    private fun createGitIgnore(moduleDir: File) {
        val gitIgnoreFile = File(moduleDir, ".gitignore")
        gitIgnoreFile.writeText("/build")
    }

    private fun updateSettingsGradle(modulePaths: List<String>) {
        val settingsFile = File("settings.gradle.kts").takeIf { it.exists() }
            ?: File("settings.gradle").takeIf { it.exists() }
            ?: throw IllegalStateException("settings.gradle(.kts) file not found in project root.")

       val includeStatements = modulePaths.joinToString("\n") { "include(\"$it\")" }
        settingsFile.appendText("\n$includeStatements\n")
    }
}