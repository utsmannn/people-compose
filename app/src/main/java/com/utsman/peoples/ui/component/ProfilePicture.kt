package com.utsman.peoples.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import com.utsman.peoples.utils.ImageProfileGenerator

@Composable
fun ProfilePicture(
    modifier: Modifier = Modifier,
    name: String
) {
    val image = ImageProfileGenerator.generate(name)
    Image(
        modifier = Modifier.clip(CircleShape).then(modifier),
        bitmap = image.asImageBitmap(),
        contentDescription = name
    )
}