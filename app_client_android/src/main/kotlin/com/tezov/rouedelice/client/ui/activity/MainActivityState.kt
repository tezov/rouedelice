

package com.tezov.rouedelice.client.ui.activity

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import com.tezov.lib_adr_app_core.ui.compositionTree.activity.ActivityState

class MainActivityState private constructor(
    val scaffoldState: ScaffoldState
) : ActivityState() {

    companion object {
        @Composable
        fun create(scaffoldState: ScaffoldState) = MainActivityState(
            scaffoldState = scaffoldState
        )
    }

}