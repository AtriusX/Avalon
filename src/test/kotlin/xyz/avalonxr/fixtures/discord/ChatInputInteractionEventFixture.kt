package xyz.avalonxr.fixtures.discord

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent
import discord4j.core.`object`.command.ApplicationCommandInteractionOption
import discord4j.core.`object`.command.Interaction
import discord4j.core.`object`.entity.Message
import io.mockk.every
import io.mockk.mockk
import reactor.core.publisher.Mono

@Suppress("LocalVariableName")
object ChatInputInteractionEventFixture {

    fun make(
        _message: Message = MessageFixture.make(),
        _commandName: String = "foo",
        _interaction: Interaction = InteractionFixture.make(),
        _optionsList: List<ApplicationCommandInteractionOption> = listOf(
            ApplicationCommandInteractionOptionFixture.make()
        )
    ): ChatInputInteractionEvent = mockk {
        every { reply } returns Mono.just(_message)
        every { commandName } returns _commandName
        every { interaction } returns _interaction
        every { options } returns _optionsList
    }
}
