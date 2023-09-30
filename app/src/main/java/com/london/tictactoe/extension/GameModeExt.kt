package com.london.tictactoe.extension

import com.london.tictactoe.data.GameMode

val GameMode.modeName: String
	get() = when(this) {
		GameMode.Computer -> "Computer"
		GameMode.PvP -> "PvP"
		GameMode.PvPBluetooth -> "PvP Bluetooth"
	}
