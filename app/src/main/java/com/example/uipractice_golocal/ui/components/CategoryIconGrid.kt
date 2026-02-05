package com.example.uipractice_golocal.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R

data class CategoryItem(
    val name: String,
    val iconResId: Int
)

@Composable
fun CategoryIconGrid(
    modifier: Modifier = Modifier,
    categories: List<CategoryItem> = getDefaultCategories(),
    onCategoryClick: (String) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Use weights ensuring 4 items per row fit perfectly
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            categories.take(4).forEach { category ->
                CategoryIcon(
                    category = category,
                    onClick = { onCategoryClick(category.name) },
                     modifier = Modifier.weight(1f)
                )
            }
        }
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            categories.drop(4).take(4).forEach { category ->
                CategoryIcon(
                    category = category,
                    onClick = { onCategoryClick(category.name) },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun CategoryIcon(
    category: CategoryItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Image Icon from Assets
        Image(
            painter = painterResource(id = category.iconResId),
            contentDescription = category.name,
            modifier = Modifier.size(70.dp), // Verified size
            contentScale = ContentScale.Fit
        )
        
        Text(
            text = category.name,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF1B1B1B),
            textAlign = TextAlign.Center,
            lineHeight = 14.sp,
            maxLines = 2
        )
    }
}

fun getDefaultCategories(): List<CategoryItem> {
    return listOf(
        CategoryItem("Fashion", R.drawable.ic_fashion),
        CategoryItem("Home & Garden", R.drawable.ic_category_home),
        CategoryItem("Kids & Toys", R.drawable.ic_kids),
        CategoryItem("Electronics", R.drawable.ic_electronics),
        CategoryItem("Tools & Equipment", R.drawable.ic_tools),
        CategoryItem("Beauty & Personal Care", R.drawable.ic_beauty),
        CategoryItem("Gifts", R.drawable.ic_gifts),
        CategoryItem("Occasions & Celebrations", R.drawable.ic_occasions)
    )
}
