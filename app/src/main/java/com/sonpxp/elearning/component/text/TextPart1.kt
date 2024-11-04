package com.sonpxp.elearning.component.text

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonpxp.elearning.R

/**
 * Created by Sonpx on 11/04/2024
 * Copyright(©)Cloudxanh. All rights reserved.
 */
@Composable
fun TextWithModifiersDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 1. Background và Border
        Text(
            text = "Text với background và border",
            modifier = Modifier
                .background(Color.LightGray, RoundedCornerShape(8.dp))
                .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                .padding(16.dp)
                .fillMaxWidth()
        )

        // 2. Click và Hover Effects
        var isClicked by remember { mutableStateOf(false) }
        Text(
            text = "Click vào text này!",
            modifier = Modifier
                .clickable { isClicked = !isClicked }
                .background(
                    if (isClicked) Color.Green.copy(alpha = 0.2f)
                    else Color.Gray.copy(alpha = 0.1f)
                )
                .padding(12.dp)
                .fillMaxWidth()
        )

        // 3. Shadow và Offset
        Text(
            text = "Text với shadow effect",
            modifier = Modifier
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(4.dp)
                )
                .background(Color.White)
                .padding(16.dp)
                .offset(x = 4.dp, y = 4.dp)
        )

        // 4. Size và Aspect Ratio
        Text(
            text = "Text trong box với kích thước cố định",
            modifier = Modifier
                .size(width = 200.dp, height = 100.dp)
                .background(Color.Yellow.copy(alpha = 0.3f))
                .padding(8.dp)
        )

        // 5. Gradient Background
        Text(
            text = "Text với gradient background",
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Blue.copy(alpha = 0.3f),
                            Color.Red.copy(alpha = 0.3f)
                        )
                    )
                )
                .padding(16.dp)
                .fillMaxWidth()
        )

        // 6. Rotation và Scale
        Text(
            text = "Rotated và Scaled Text",
            modifier = Modifier
                .rotate(15f)
                .scale(1.2f)
                .background(Color.Cyan.copy(alpha = 0.3f))
                .padding(8.dp)
        )

        // 7. Custom Shape với Clip
        Text(
            text = "Text với custom shape",
            fontSize = 12.sp,
            modifier = Modifier
                .clip(DiamondShape())
                .background(Color.Magenta.copy(alpha = 0.3f))
                .padding(24.dp)
        )

        // 8. Animated Size Change
        var isExpanded by remember { mutableStateOf(false) }
        Text(
            text = "Click để thay đổi kích thước",
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .background(Color.LightGray)
                .padding(if (isExpanded) 32.dp else 16.dp)
                .fillMaxWidth()
        )

        Text(
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = colorResource(R.color.purple_200),
            modifier = Modifier
                .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                .padding(16.dp)
        )
    }
}

// Custom Shape cho demo
class DiamondShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(size.width / 2f, 0f)
            lineTo(size.width, size.height / 2f)
            lineTo(size.width / 2f, size.height)
            lineTo(0f, size.height / 2f)
            close()
        }
        return Outline.Generic(path)
    }
}

// Preview
@Preview(showBackground = true)
@Composable
fun TextModifiersPreview() {
    TextWithModifiersDemo()
}