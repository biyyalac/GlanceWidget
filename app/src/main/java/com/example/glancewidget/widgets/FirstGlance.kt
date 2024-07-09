package com.example.glancewidget.widgets

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import com.example.glancewidget.Compose2FromGlance
import com.example.glancewidget.MainActivity

import androidx.glance.preview.ExperimentalGlancePreviewApi
import androidx.glance.preview.Preview

class FirstGlance: GlanceAppWidget() {
    val countKey= intPreferencesKey("count")


    /*@Composable
    override fun Content() {

        val countValue= currentState(countKey)
        Column(modifier = GlanceModifier.background(Color.Cyan).
        fillMaxSize(),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(countValue.toString(),

                )
            Button(text = "Increase", onClick = actionRunCallback(IncrementAction::class.java))

        }
    }*/

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

@androidx.compose.ui.tooling.preview.Preview
@Composable
private fun MyContent() {



    androidx.compose.foundation.layout.Column(
        modifier = Modifier.padding(10.dp).background(Color.White),

    ) {

      //  Column {
            for (i in 0..100)
                androidx.compose.material3.Text("Text 124", style = TextStyle(color = Color.Black))

      //  }


    }
}
class CounterGlanceReceiver : GlanceAppWidgetReceiver() {

    override val glanceAppWidget:GlanceAppWidget = FirstGlance()
}

object IncrementAction:ActionCallback{
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
            /*updateAppWidgetState(context,glanceId){
                pref->
                val currentCount=pref[FirstGlance.countKey]
                if(currentCount!=null){
                    pref[FirstGlance.countKey]=currentCount+1
                }else
                {
                    pref[FirstGlance.countKey]=1
                }
            }
        FirstGlance.update(context,glanceId)*/
    }

}