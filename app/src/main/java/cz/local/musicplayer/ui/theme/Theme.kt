package cz.local.musicplayer.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColors = darkColorScheme(
    primary = PlayerBlue,
    secondary = PlayerBlueDark,
    background = AmoledBlack,
    surface = AmoledBlack,
    onBackground = TextWhite,
    onSurface = TextWhite
)

private val LightColors = lightColorScheme(
    primary = Color(0xFF245A9B),
    secondary = Color(0xFF526783)
)

@Composable
fun LocalMusicPlayerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }

    val finalColorScheme = if (darkTheme) {
        colorScheme.copy(
            background = AmoledBlack,
            surface = AmoledBlack
        )
    } else {
        colorScheme
    }

    MaterialTheme(
        colorScheme = finalColorScheme,
        typography = PlayerTypography,
        content = content
    )
}
