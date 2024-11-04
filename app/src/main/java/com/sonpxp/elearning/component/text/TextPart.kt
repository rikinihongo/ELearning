package com.sonpxp.elearning.component.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Sonpx on 11/04/2024
 * Copyright(©)Cloudxanh. All rights reserved.
 */
// Preview toàn màn hình
@Preview(
    showBackground = true,
    widthDp = 412,
    heightDp = 800,
    showSystemUi = false
)
@Composable
fun TextPropertiesDemo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 1. Cơ bản: text, modifier, color, fontSize
        Text(
            text = "Văn bản cơ bản",
            modifier = Modifier.padding(vertical = 12.dp),
            color = Color.DarkGray,
            fontSize = 20.sp
        )

        // 2. Font styling: fontStyle, fontWeight, fontFamily
        Text(
            text = "Kiểu chữ tùy chỉnh",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )

        // 3. Spacing: letterSpacing, lineHeight
        Text(
            text = "Khoảng cách chữ và dòng\nDòng thứ hai",
            letterSpacing = 4.sp,
            lineHeight = 24.sp
        )

        // 4. Decoration và Alignment
        Text(
            text = "Văn bản được trang trí và căn giữa. \nchưa có gì bàn cãi cả nếu bạn thích thì tôi chiều ok",
            textDecoration = TextDecoration.combine(
                listOf(TextDecoration.Underline, TextDecoration.LineThrough)
            ),
            textAlign = TextAlign.Justify,
            modifier = Modifier.fillMaxWidth()
        )

        // 5. Overflow và Lines control
        Text(
            text = "Đây là một đoạn văn bản dài để demo overflow và số dòng tối đa. " +
                    "Văn bản sẽ bị cắt nếu vượt quá số dòng cho phép.Văn bản sẽ bị cắt nếu vượt quá số dòng cho phép.",
            maxLines = 2,
            overflow = TextOverflow.Clip,
            softWrap = true
        )

        // 6. Style tổng hợp
        Text(
            text = "Văn bản với style tổng hợp",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Green,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Start
            )
        )
    }
}