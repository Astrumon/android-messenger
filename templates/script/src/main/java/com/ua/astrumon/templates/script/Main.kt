package com.ua.astrumon.templates.script

data class InputArgs(
    val templateName: String,
    val outputModuleName: String,
    val outputModulePackage: String
)

fun main(args: Array<String>) {
    val inputArgs = parseArgs(args)
    val generator = TemplateGeneratorImpl()
    generator.generate(inputArgs)
}

/**
 * Parse input arguments.
 *  Input arguments list: 1) template name 2) module name 3) package. Arguments are specified by
 *  java -jar create.jar <template_name> <module_name> <package>
 *  For example:
 *  java -jar create.jar kotlin-library :my-library com.example.mylib
 */
private fun parseArgs(args: Array<String>): InputArgs {
    if (args.size != 3) {
        throw IllegalArgumentException(
            "Invalid number of arguments. Expected 3 arguments: <template_name> <module_name> <package>."
        )
    }

    val templateName = args[0]
    val outputModuleName = args[1]
    val outputModulePackage = args[2]

    if (templateName.isBlank()) {
        throw IllegalArgumentException("Template name is required. Please specify all three arguments.")
    }

    val  moduleNameRegex = Regex("^:[a-zA-Z]+[a-zA-Z-:]*$")
    if (!moduleNameRegex.matches(outputModuleName)) {
        throw IllegalArgumentException(
            "Invalid module name. Example of a valid name: ':my-library'"
        )
    }

    val packageRegex = Regex("^[a-zA-Z]+(\\.[a-zA-Z][a-zA-Z0-9]*)*$")
    if (!packageRegex.matches(outputModulePackage)) {
        throw IllegalArgumentException(
            "Invalid package name. Example of a valid package: 'com.example.mylib'"
        )
    }

    return InputArgs(
        templateName = templateName,
        outputModuleName = outputModuleName,
        outputModulePackage = outputModulePackage
    )
}

interface TemplateGenerator {
    fun generate(inputArgs: InputArgs)
}