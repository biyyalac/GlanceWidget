package com.example.glancewidget.widgets

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.preview.ExperimentalGlancePreviewApi
import androidx.glance.preview.Preview
import androidx.glance.text.Text
import com.example.glancewidget.Compose2FromGlance

class FirstGlance: GlanceAppWidget() {


    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            My()
        }
    }


    @OptIn(ExperimentalGlancePreviewApi::class)
    @Preview
    @Composable
    private fun My() {
        Column(
            modifier = GlanceModifier.fillMaxSize().padding(10.dp)
                .background(GlanceTheme.colors.background),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Where to? 1", modifier = GlanceModifier.padding(12.dp))
            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    text = "Compose ",
                    onClick = actionStartActivity<Compose2FromGlance>()
                )

            }
        }
    }




}

class CounterGlanceReceiver : GlanceAppWidgetReceiver() {

    override val glanceAppWidget:GlanceAppWidget = FirstGlance()
}
