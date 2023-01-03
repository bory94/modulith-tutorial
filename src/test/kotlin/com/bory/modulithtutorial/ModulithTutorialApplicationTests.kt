package com.bory.modulithtutorial

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.modulith.docs.Documenter
import org.springframework.modulith.model.ApplicationModules

@SpringBootTest
class ModulithTutorialApplicationTests {

    @Test
    fun writeDocumentationSnippets() {
        val modules = ApplicationModules.of(ModulithTutorialApplication::class.java).verify()

        Documenter(modules)
            .writeDocumentation()
            .writeModulesAsPlantUml(
                Documenter.DiagramOptions.defaults().withTargetFileName("all-components.puml")
            )
    }

}
