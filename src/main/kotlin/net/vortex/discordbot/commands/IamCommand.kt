package net.vortex.discordbot.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

class IamCommand: Command("!iam", listOf("!role"), "Assigns a certain role to an user.") {

    override fun onCommand(e: MessageReceivedEvent, args: List<String>) {
        if (args.isNotEmpty()){
            e.guild.controller.addSingleRoleToMember(e.member, e.guild.getRolesByName(args[0], true)[0]).queue()
            e.textChannel.sendMessage("${e.author.asMention} You have been given the ${args[0]} role.")
        } else {
            e.textChannel.sendMessage("${e.author.asMention} Invalid number of arguments.")
        }
    }
}