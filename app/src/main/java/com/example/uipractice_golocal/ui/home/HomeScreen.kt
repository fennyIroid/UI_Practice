package com.example.uipractice_golocal.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import com.example.uipractice_golocal.R
import com.example.uipractice_golocal.ui.components.*
import com.example.uipractice_golocal.ui.model.HighlightProfile
import com.example.uipractice_golocal.ui.model.HighlightType

@Composable
fun HomeScreen() {
    var selectedTabIndex by remember { mutableStateOf(1) }
    var selectedBottomNavIndex by remember { mutableStateOf(0) }
    val listState = rememberLazyListState()


    // Sample data
    val seasonalProducts = listOf(
        Product("Button-Down Shirt", "₪15", R.drawable.product_card_img, null, null),
        Product("Button-Down Shirt", "₪15", R.drawable.product_card_img, null, null),
        Product("Button-Down Shirt", "₪15", R.drawable.product_card_img, null, null)
    )
    
    val specialDealsProducts = listOf(
        Product("Button-Down Shirt", "₪15", R.drawable.product_card_img, "-20%", "₪20"),
        Product("Button-Down Shirt", "₪15", R.drawable.product_card_img, "-20%", "₪20"),
        Product("Button-Down Shirt", "₪15", R.drawable.product_card_img, "-20%", "₪20")
    )
    
    val discoverProducts = listOf(
        Product("Button-Down Shirt", "₪15", R.drawable.product_card_img, null, null),
        Product("Button-Down Shirt", "₪15", R.drawable.product_card_img, null, null),
        Product("Button-Down Shirt", "₪15", R.drawable.product_card_img, null, null)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Main background
    ) {
        // Main Content Column
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 100.dp) // Space for floating nav
        ) {
            // Top section with search bar and icons
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .windowInsetsPadding(WindowInsets.statusBars)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SearchBar(
                        modifier = Modifier.weight(1f)
                    )
                    
                    // Message icon
                    Icon(
                        painter = painterResource(id = R.drawable.ic_message),
                        contentDescription = "Messages",
                        tint = Color(0xFF8E9B6D),
                        modifier = Modifier.size(37.dp)
                    )
                    
                    // Notification icon
                    Icon(
                        painter = painterResource(id = R.drawable.ic_notification),
                        contentDescription = "Notifications",
                        tint = Color(0xFF8E9B6D),
                        modifier = Modifier.size(37.dp)
                    )
                }
            }

//            Spacer(modifier = Modifier.height(16.dp))
            
            // Promotional Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                PromotionalBannerPager(
//                    modifier = Modifier
//                        .padding(vertical = 8.dp),
                    banners = listOf(
                        R.drawable.banner,
                        R.drawable.banner,   // replace with real images
                        R.drawable.banner
                    )
                )
            }

//            Spacer(modifier = Modifier.height(24.dp))
            
            // Category Tab Row
            CategoryTabRow(
                selectedTabIndex = selectedTabIndex,
                onTabSelected = { selectedTabIndex = it }
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Category Icon Grid
            CategoryIconGrid(
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Seasonal Picks Section
            SectionHeader(
                title = "Seasonal Picks",
                actionText = "View More",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            val horizontalScrollState1 = rememberScrollState()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(horizontalScrollState1)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                seasonalProducts.forEach { product ->
                    ProductCard(product = product)
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Special Deals Section
            SectionHeader(
                title = "Special Deals",
                actionText = "Up to 20% Off",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            val horizontalScrollState2 = rememberScrollState()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(horizontalScrollState2)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                specialDealsProducts.forEach { product ->
                    ProductCard(product = product)
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))


            // Today's Highlights Section
            val highlights = listOf(
                HighlightProfile(
                    name = "Jack Smith",
                    imageRes = R.drawable.jack_smith_carpenter,
                    type = HighlightType.PROFILE
                ),
                HighlightProfile(
                    name = "Click & Collect",
                    imageRes = R.drawable.click_collect_shopping,
                    type = HighlightType.CLICK_COLLECT
                ),
                HighlightProfile(
                    name = "Sarah Jones",
                    imageRes = R.drawable.jack_smith_carpenter,
                    type = HighlightType.PROFILE
                )
            )

// Today's Highlights Section Header
            SectionHeader(
                title = "Today's Highlights",
                modifier = Modifier.padding(bottom = 16.dp)
            )


            LazyRow(
                state = listState,
                contentPadding = PaddingValues(horizontal = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                itemsIndexed(highlights) { index, item ->

                    val alpha = rememberCarouselItemAlpha(index, listState)
                    val scale = if (alpha > 0.9f) 1f else 0.9f

                    ProfileCard(
                        name = item.name,
                        imageResId = item.imageRes,
                        middleContent = if (item.type == HighlightType.CLICK_COLLECT) {
                            {
                                ClickCollectActions()
                            }
                        } else {
                            null
                        },
                        modifier = Modifier.graphicsLayer {
                            this.alpha = alpha
                            scaleX = scale
                            scaleY = scale
                        }
                    )

                }
            }



            Spacer(modifier = Modifier.height(32.dp))
            
            // Discover What You Love Section
            SectionHeader(
                title = "Discover What You Love",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            val horizontalScrollState4 = rememberScrollState()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(horizontalScrollState4)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                discoverProducts.forEach { product ->
                    ProductCard(product = product)
                }
            }
            // Bottom spacing handled by column padding
        }

        // Floating Bottom Navigation Bar
        BottomNavigationBar(
            selectedIndex = selectedBottomNavIndex,
            onItemSelected = { selectedBottomNavIndex = it },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@Composable
fun rememberCarouselItemAlpha(
    index: Int,
    listState: LazyListState
): Float {
    val layoutInfo = listState.layoutInfo
    val visibleItem = layoutInfo.visibleItemsInfo
        .firstOrNull { it.index == index }

    val viewportCenter = layoutInfo.viewportStartOffset +
            layoutInfo.viewportEndOffset / 2

    return visibleItem?.let { item ->
        val itemCenter = item.offset + item.size / 2
        val distance = kotlin.math.abs(itemCenter - viewportCenter)

        // Fade logic
        val maxDistance = layoutInfo.viewportEndOffset / 2
        (1f - (distance.toFloat() / maxDistance)).coerceIn(0.4f, 1f)
    } ?: 0.4f
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    androidx.compose.material3.MaterialTheme {
        HomeScreen()
    }
}
