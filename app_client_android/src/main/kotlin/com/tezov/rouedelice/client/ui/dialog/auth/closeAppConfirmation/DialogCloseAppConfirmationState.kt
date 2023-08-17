

package com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation

import androidx.compose.runtime.Composable
import com.tezov.lib_adr_app_core.ui.compositionTree.modal.dialog.DialogState

class DialogCloseAppConfirmationState private constructor( ) : DialogState {
    var contentData: ContentData

    companion object {

        @Composable
        fun create() = DialogCloseAppConfirmationState()
    }

    data class ContentData(
        val title: String,
        val body: String,
        val cancel: String,
        val confirm: String,
    )

    init {
        contentData = ContentData(
            title = "Déconnection",
            body = "Etes-vous certain de vouloir vous déconnecter ?",
            confirm = "Oui",
            cancel = "Non",
        )
    }

}