package org.firstinspires.ftc.teamcode.opmodes.teleop

import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import dev.nextftc.robot.triggers.CommandGamepad
import org.firstinspires.ftc.teamcode.Robot

@NextTeleop("Full", "Competition")
class Full(robot: Robot) : NextOpMode(robot) {
    val driver = CommandGamepad(gamepad1)
    val codriver = CommandGamepad(gamepad2)

    init {
        robot.drivetrain.driveByDefault(driver)

        codriver.leftBumper.whileTrue(robot.launcher.run)
        codriver.rightBumper.whileTrue(robot.intake.run)

        codriver.rightTrigger.isOver(0.5).whileTrue(robot.gate.run)
    }
}