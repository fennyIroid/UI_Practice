package com.example.uipractice_golocal.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R
import com.example.uipractice_golocal.ui.components.PrimaryButton

@Composable
fun PromotionalBannerPager(
    modifier: Modifier = Modifier,
    banners: List<Int>
) {
    val pagerState = rememberPagerState(
        pageCount = { banners.size }
    )

    Box(
        modifier = modifier
            .width(350.dp)
            .height(170.dp),
        contentAlignment = Alignment.Center

    ) {

        // ───────── Banner Pager ─────────
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            pageSpacing = 12.dp
        ) { page ->
            Image(
                painter = painterResource(id = banners[page]),
                contentDescription = "Promotional Banner",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Fit
            )
        }

        // ───────── Pager Dots (Overlay) ─────────
        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 12.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(banners.size) { index ->
                val isSelected = pagerState.currentPage == index

                Box(
                    modifier = Modifier
                        .width(if (isSelected) 14.dp else 6.dp)
                        .height(6.dp)
                        .clip(RoundedCornerShape(50))
                        .background(
                            if (isSelected) Color.White
                            else Color.White.copy(alpha = 0.4f)
                        )
                )
            }
        }
    }
}
