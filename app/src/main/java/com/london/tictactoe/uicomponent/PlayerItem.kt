package com.london.tictactoe.uicomponent

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.london.tictactoe.data.PointType
import com.london.tictactoe.model.Player
import com.london.tictactoe.theme.light_onFlirtContainer

@Composable
fun PlayerItem(
	player: Player,
	playerTurn: Boolean,
	modifier: Modifier = Modifier
) {

	Column(
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Card(modifier = modifier) {
			Column(
				horizontalAlignment = Alignment.CenterHorizontally,
				modifier = Modifier
					.padding(16.dp)
			) {
				Text(
					text = player.name,
					style = MaterialTheme.typography.bodySmall.copy(
						fontWeight = FontWeight.Bold
					)
				)
				
				Spacer(modifier = Modifier.height(16.dp))
				
				PlayerPointType(
					playerTurn = playerTurn,
					pointType = player.pointType
				)
			}
		}
		
		Spacer(modifier = Modifier.height(8.dp))
		
		Card(
			shape = CircleShape,
			border = BorderStroke(
				width = 1.dp,
				color = MaterialTheme.colorScheme.onSurfaceVariant
			)
		) {
			Text(
				text = "Win rounds: ${player.win}",
				style = MaterialTheme.typography.labelMedium.copy(
					fontWeight = FontWeight.Medium,
					color = MaterialTheme.colorScheme.tertiary
				),
				modifier = Modifier
					.padding(
						horizontal = 8.dp,
						vertical = 4.dp
					)
			)
		}
	}
}

@Composable
private fun PlayerPointType(
	playerTurn: Boolean,
	pointType: PointType
) {
//	val imageRes = remember(pointType) {
//		when (pointType) {
//			PointType.Empty -> R.drawable.transparent
//			PointType.X -> R.drawable.ic_tic_tac_toe_x
//			PointType.O -> R.drawable.ic_tic_tac_toe_o
//		}
//	}
	
	val pointTypeBackground by animateColorAsState(
		targetValue = if (playerTurn) light_onFlirtContainer
		else MaterialTheme.colorScheme.background,
		animationSpec = tween(500)
	)
	
	Box(
		modifier = Modifier
			.clip(MaterialTheme.shapes.large)
			.drawBehind {
				drawRoundRect(
					color = pointTypeBackground,
					cornerRadius = CornerRadius(
						x = CircleShape.topStart.toPx(size, this),
						y = CircleShape.bottomEnd.toPx(size, this)
					)
				)
			}
	) {
		PlayerPointTypeImage(pointType = pointType)
	}
}

@Composable
private fun PlayerPointTypeImage(
	pointType: PointType
) {
	Image(
		painter = painterResource(
			id = when (pointType) {
				PointType.Empty -> R.drawable.transparent
				PointType.X -> R.drawable.ic_tic_tac_toe_x
				PointType.O -> R.drawable.ic_tic_tac_toe_o
			}
		),
		contentDescription = null,
		modifier = Modifier
			.padding(
				horizontal = 12.dp,
				vertical = 4.dp
			)
			.size(24.dp)
	)
}
