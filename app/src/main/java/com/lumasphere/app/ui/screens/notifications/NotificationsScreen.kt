package com.lumasphere.app.ui.screens.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.lumasphere.app.ui.theme.*

data class Notification(
    val id: String,
    val type: String,
    val username: String,
    val avatar: String,
    val message: String,
    val time: String,
    val image: String? = null
)

@Composable
fun NotificationsScreen() {
    val notifications = remember {
        listOf(
            Notification("1", "like", "nova_art", "https://picsum.photos/100", "liked your post", "2h"),
            Notification("2", "follow", "digital_dream", "https://picsum.photos/101", "started following you", "4h"),
            Notification("3", "comment", "neon_vibes", "https://picsum.photos/102", "commented: Amazing! 🔥", "6h", "https://picsum.photos/200"),
            Notification("4", "like", "glass_maker", "https://picsum.photos/103", "liked your post", "8h"),
            Notification("5", "mention", "tech_guru", "https://picsum.photos/104", "mentioned you in a post", "10h")
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Text(
                "Activity",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(notifications) { notification ->
            NotificationItem(notification = notification)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun NotificationItem(notification: Notification) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(SurfaceGlass, RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            AsyncImage(
                model = notification.avatar,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            if (notification.type == "like") {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    tint = PinkAccent,
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.BottomEnd)
                        .background(BackgroundDark, CircleShape)
                        .padding(2.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = notification.username,
                style = MaterialTheme.typography.titleSmall,
                color = TextPrimary,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = notification.message,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = notification.time,
                style = MaterialTheme.typography.bodySmall,
                color = TextTertiary
            )
            notification.image?.let { imageUrl ->
                Spacer(modifier = Modifier.height(4.dp))
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}