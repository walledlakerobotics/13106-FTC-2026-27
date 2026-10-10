package org.firstinspires.ftc.teamcode.opmodes.teleop

import dev.nextftc.robot.opmode.BulkReadHook
import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import dev.nextftc.robot.triggers.CommandGamepad
import org.firstinspires.ftc.teamcode.Robot

@NextTeleop(name = "Basic Drive", group = "Basic")
class BasicDrive(robot: Robot) : NextOpMode(robot, BulkReadHook) {
    val driver = CommandGamepad(gamepad1)

    init {
        robot.drivetrain.driveByDefault(driver)
    }
}