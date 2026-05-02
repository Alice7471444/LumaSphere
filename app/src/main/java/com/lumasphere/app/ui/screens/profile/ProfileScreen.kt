package com.lumasphere.app.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.lumasphere.app.ui.theme.*

@Composable
fun ProfileScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        // Profile Header
        item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(3) }) {
            ProfileHeader()
        }

        // Tab Switcher
        item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(3) }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { selectedTab = 0 }) {
                    Icon(
                        Icons.Outlined.GridView,
                        contentDescription = null,
                        tint = if (selectedTab == 0) PurplePrimary else TextSecondary
                    )
                }
                Spacer(modifier = Modifier.width(32.dp))
                IconButton(onClick = { selectedTab = 1 }) {
                    Icon(
                        Icons.Outlined.PhotoCamera,
                        contentDescription = null,
                        tint = if (selectedTab == 1) PurplePrimary else TextSecondary
                    )
                }
            }
        }

        // Grid Content
        items(12) { index ->
            AsyncImage(
                model = "https://picsum.photos/300/300?random=${index + 100}",
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(1.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun ProfileHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar with gradient
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(PurplePrimary, CyanAccent)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = "https://picsum.photos/200",
                contentDescription = null,
                modifier = Modifier
                    .size(92.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Luma User",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )

        Text(
            text = "@luma_user",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Creating the future ✨",
            style = MaterialTheme.typography.bodyMedium,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Stats
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem(value = "12", label = "Posts")
            StatItem(value = "1.2K", label = "Followers")
            StatItem(value = "890", label = "Following")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Actions
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* Edit Profile */ },
                colors = ButtonDefaults.buttonColors(containerColor = PurplePrimary),
                modifier = Modifier.weight(1f).padding(end = 4.dp)
            ) {
                Icon(Icons.Default.Edit, contentDescription = null, tint = TextPrimary)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Edit Profile", color = TextPrimary)
            }

            Button(
                onClick = { /* Share */ },
                colors = ButtonDefaults.buttonColors(containerColor = SurfaceGlass),
                modifier = Modifier.weight(1f).padding(start = 4.dp)
            ) {
                Icon(Icons.Default.Share, contentDescription = null, tint = TextPrimary)
            }
        }
    }
}

@Composable
fun StatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = TextSecondary
        )
    }
}