package com.maderajan.spacelecture.ui.fontchange

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maderajan.spacelecture.R

@Composable
fun ChangeFontScreen(
    onCancelClick: () -> Unit
) {
    var fontSize by remember { mutableIntStateOf(16) }

    Column {
        Row {
            Text(
                text = stringResource(id = R.string.increase_font_size_title),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = {
                    onCancelClick()
                },
                content = {
                    Icon(
                        imageVector = Icons.Sharp.Clear,
                        contentDescription = null
                    )
                }
            )
        }

        Text(
            text = stringResource(id = R.string.increase_font_size_description),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = fontSize.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(150.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    horizontal = 16.dp,
                    vertical = 24.dp,
                )
        ) {
            BigIconButton(
                icon = painterResource(id = R.drawable.ic_remove),
                onClick = {
                    fontSize -= 1
                }
            )

            Text(
                text = fontSize.toString(),
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            BigIconButton(
                icon = painterResource(id = R.drawable.ic_add),
                onClick = {
                    fontSize += 1
                }
            )
        }
    }
}

@Composable
private fun BigIconButton(
    icon: Painter,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        content = {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.White
            )
        },
        modifier = Modifier
            .size(45.dp)
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(10.dp))
    )
}

@Preview
@Composable
fun ChangeNewsFontScreenPreview() {
    ChangeFontScreen(
        onCancelClick = {}
    )
}