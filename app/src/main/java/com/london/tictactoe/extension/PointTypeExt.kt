package com.london.tictactoe.extension

import com.london.tictactoe.data.PointType
import com.london.tictactoe.data.WinType

fun PointType.toWinType(): WinType {
	return when (this) {
		PointType.Empty -> WinType.None
		PointType.X -> WinType.X
		PointType.O -> WinType.O
	}
}