package org.firstinspires.ftc.teamcode

import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.NextRobot
import dev.nextftc.robot.triggers.CommandGamepad
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2

class Robot : NextRobot {
    val driverGamepad = CommandGamepad(gamepad1)
    val codriverGamepad = CommandGamepad(gamepad2)

    val drivetrain = Drivetrain()

    override val mechanisms = setOf(drivetrain)
}