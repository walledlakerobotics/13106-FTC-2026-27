@file:JvmName("Tuning")
package org.firstinspires.ftc.teamcode.pedro

import com.pedropathing.revhub.drivetrains.Mecanum
import com.pedropathing.tuning.autotune.Procedure
import com.pedropathing.tuning.autotune.Tuner
import org.firstinspires.ftc.teamcode.pedro.procedures.MecanumTuner
import org.firstinspires.ftc.teamcode.pedro.procedures.OTOSTuner
import org.firstinspires.ftc.teamcode.pedro.procedures.Tests

@Tuner
fun mecanumTuner(): Procedure = MecanumTuner()

@Tuner
fun otosTuner(): Procedure = OTOSTuner()

@Tuner
fun tests(): Procedure = Tests({ hardwareMap ->
        Mecanum(
            hardwareMap,
            drivetrainConfig
        )
    }, null, null)