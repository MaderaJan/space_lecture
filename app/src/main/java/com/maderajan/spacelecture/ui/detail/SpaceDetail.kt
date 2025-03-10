package com.maderajan.spacelecture.ui.detail

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.imageLoader
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.placeholder
import coil3.util.DebugLogger
import com.maderajan.spacelecture.R
import com.maderajan.spacelecture.data.SpaceNews
import com.maderajan.spacelecture.util.launchCustomChromeTab

@Composable
fun SpaceDetail(
    news: SpaceNews,
    onArrowBackClicked: () -> Unit,
    onBookmarkClicked: () -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            SpaceToolbar(
                title = news.title,
                bookmarked = news.isBookmarked,
                onArrowBackClicked = onArrowBackClicked,
                onBookmarkClicked = onBookmarkClicked
            )
        },
        content = { paddingValues ->
            SpaceDetailContent(
                news = news,
                padding = paddingValues
            )
        },
        bottomBar = {
            Button(
                content = {
                    Text(text = stringResource(id = R.string.read_more))
                },
                onClick = {
                    launchCustomChromeTab(
                        context = context,
                        uri = Uri.parse(news.url),
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        },
    )
}

@Composable
fun SpaceToolbar(
    title: String,
    bookmarked: Boolean,
    onArrowBackClicked: () -> Unit,
    onBookmarkClicked: () -> Unit
) {
    Column {
        Row {
            IconButton(
                onClick = {
                    onArrowBackClicked()
                },
                content = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = {
                    onBookmarkClicked()
                },
                content = {
                    Icon(
                        painter = painterResource(
                            if (bookmarked) {
                                R.drawable.ic_bookmark_filled
                            } else {
                                R.drawable.ic_bookmark
                            }
                        ),
                        contentDescription = null
                    )
                }
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun SpaceDetailContent(
    news: SpaceNews,
    padding: PaddingValues,
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .verticalScroll(rememberScrollState())
    ) {
        val imageLoader = LocalContext.current.imageLoader.newBuilder()
            .logger(DebugLogger())
            .build()

        AsyncImage(
            imageLoader = imageLoader,
            model = ImageRequest.Builder(LocalContext.current)
                .data(news.imageUrl)
                .crossfade(true)
                .placeholder(drawableResId = R.drawable.ic_image_placeholder)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 4.dp
                )
                .clip(RoundedCornerShape(16.dp))
                .height(200.dp)
        )

        Text(
            text = news.summary,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(
                top = 8.dp,
                start = 16.dp,
                end = 16.dp,
            )
        )

        Text(
            text = news.publishedAt,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .align(Alignment.End)
                .padding(vertical = 4.dp, horizontal = 16.dp),
        )
    }
}

@Preview
@Composable
fun SpaceDetailPreview() {
    SpaceDetail(
        news = SpaceNews(
            id = 1,
            title = "SpaceNews Title",
            summary = "ESA is ready to launch its Hera planetary defense mission just as soon as SpaceX’s Falcon 9 rocket is back in business. The launch window opens on Monday. SpaceX suspended...",
            newsSite = "News Site",
            url = "",
            imageUrl = null,
            publishedAt = "5.6. 2023",
            isBookmarked = false
        ),
        onArrowBackClicked = {},
        onBookmarkClicked = {}
    )
}