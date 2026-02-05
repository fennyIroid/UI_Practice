package com.example.uipractice_golocal.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R

// -------------------- DATA MODEL --------------------

data class Product(
    val name: String,
    val price: String,
    val imageResId: Int,
    val discount: String? = null,
    val originalPrice: String? = null
)

// -------------------- PRODUCT CARD --------------------

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val beigeColor = Color(0xFFF6EDDA) // Figma exact color
    val redColor = Color(0xFFC04F39)
    val cornerShape = RoundedCornerShape(26.dp)

    Box(
        modifier = modifier
            .width(116.dp)
            .clip(cornerShape)
            .background(beigeColor)
            .clickable(onClick = onClick)
            .drawWithCache {
                val outline = cornerShape.createOutline(size, layoutDirection, this)
                onDrawWithContent {
                    drawContent()
                    // Draw red border only at the top edge (arc)
                    clipRect(bottom = 14.dp.toPx()) {
                        drawOutline(
                            outline = outline,
                            color = redColor,
                            style = Stroke(width = 5.dp.toPx())
                        )
                    }
                }
            }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // ───── White Image Container (Elevated/Overlapping) ─────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
//                    .padding(5.dp) // Slight margin to show beige
                    .height(110.dp)
                    .background(Color.White, RoundedCornerShape(22.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = product.imageResId),
                    contentDescription = product.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentScale = ContentScale.Fit
                )


            }

            // ───── Details Section (On Beige) ─────
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1B1B1B),
                    maxLines = 1,
                    lineHeight = 13.sp
                )
                
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Currency + Price
                    Text(
                        text = product.price,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1B1B1B)
                    )

                    // Sparkle (Seasonal)
                    if (product.discount == null) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null,
                            tint = Color(0xFFE6A57D),
                            modifier = Modifier
                                .padding(start = 46.dp)
                                .size(14.dp)

                        )
                    }
                    
                    // Original Price
                    product.originalPrice?.let {
                        Text(
                            text = it,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF9E9E9E),
                            textDecoration = TextDecoration.LineThrough
                        )
                    }

                    // High-Fidelity Discount Tag
                    product.discount?.let {
                        Box(
                            modifier = Modifier
                                .background(redColor, RoundedCornerShape(4.dp))
                                .padding(horizontal = 4.dp, vertical = 1.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = it,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.width(2.dp))
                                // The "Dot" on the tag
                                Box(
                                    modifier = Modifier
                                        .size(3.dp)
                                        .background(Color.White, CircleShape)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// -------------------- ROW --------------------

@Composable
fun ProductCardRow(
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        products.forEach { product ->
            ProductCard(product = product)
        }
    }
}

// -------------------- PREVIEW --------------------

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        // Seasonal Pick (No Discount)
        ProductCard(
            product = Product(
                name = "Button-Down Shirt",
                price = "₪15",
                imageResId = R.drawable.product_card_img,
                discount = null
            )
        )
        
        // Special Deal (Discount)
        ProductCard(
            product = Product(
                name = "Button-Down Shirt",
                price = "₪15",
                imageResId = R.drawable.product_card_img,
                discount = "-20%",
                originalPrice = "₪20"
            )
        )
    }
}
