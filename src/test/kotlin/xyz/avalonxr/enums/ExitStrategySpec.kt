package xyz.avalonxr.enums

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringTestExtension
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import xyz.avalonxr.config.AppSettings

@SpringBootTest
@ActiveProfiles("test")
@Import(AppSettings::class)
class ExitStrategySpec(
    private val exitHandlerStrategy: ExitStrategy
) : DescribeSpec({

    extensions(SpringTestExtension())

    describe("ExitStrategy Tests") {

        it("Should provide an exit handler strategy") {
            exitHandlerStrategy.shouldNotBeNull()
        }

        it("Should have the correct strategy") {
            exitHandlerStrategy shouldBe ExitStrategy.DEBUG
        }
    }
})
