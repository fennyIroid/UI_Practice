package com.example.uipractice_golocal.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    name: String,
    imageResId: Int,
    middleContent: @Composable (() -> Unit)? = null,
    onClick: () -> Unit = {}
) {
    val oliveBg = Color(0xFF66754C)
    val beigeBox = Color(0xFFF6EDDA)
    val sageText = Color(0xFF8E9B6D)

    Box(
        modifier = modifier
            .width(170.dp)
            .aspectRatio(170f / 200f)
    ) {

        // Olive base
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .background(oliveBg, RoundedCornerShape(25.dp))
        )

        // Top hump
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(62.dp)
                .background(oliveBg, CircleShape)
        )

        // Beige content box
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 36.dp)
                .fillMaxWidth(0.92f)
                .fillMaxHeight(0.72f)
                .background(beigeBox, RoundedCornerShape(22.dp)),
            contentAlignment = Alignment.TopCenter
        ) {

            // Avatar pinned to top
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .offset(y = (-32).dp)
                    .size(65.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Fit
            )

            // Text content
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = oliveBg,
                    modifier = Modifier
                        .padding(top = 32.dp)
                )

                Text(
                    text = "Timeless Craftsmanship!",
                    fontSize = 9.sp,
                    color = sageText,
                    textAlign = TextAlign.Center
                )

                Box(modifier = Modifier.padding(top = 4.dp)) {
                    middleContent?.invoke() ?: DefaultRoleBadge()
                }

            }
        }

        // Profile button

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp)
                .width(57.dp)
                .height(24.dp)
                .background(Color.White, RoundedCornerShape(100.dp))
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right_up),
                    contentDescription = null,
                    modifier = Modifier.size(8.dp),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Profile",
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }

    }
}

@Composable
private fun DefaultRoleBadge() {
    Box(
        modifier = Modifier
            .background(Color(0xFF8E9B6D), RoundedCornerShape(100.dp))
            .padding(horizontal = 32.dp, vertical = 2.dp)
    ) {
        Text(
            text = "Carpenter",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}


@Composable
fun ClickCollectActions() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        listOf(
            R.drawable.ic_tshirt,
            R.drawable.ic_mobile,
            R.drawable.ic_tool,
            R.drawable.ic_next
        ).forEach { icon ->

                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )

        }
    }
}



@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    MaterialTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProfileCard(
                name = "Jack Smith",
                imageResId = R.drawable.jack_smith_carpenter
            )

            ProfileCard(
                name = "Click & Collect",
                imageResId = R.drawable.click_collect_shopping,
                middleContent = {
                    ClickCollectActions()
                }
            )
        }
    }
}

