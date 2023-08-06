

package com.tezov.rouedelice.client.ui.pageMain.lobby.loginAuth

import androidx.compose.runtime.Composable
import com.tezov.rouedelice.client.ui.pageMain.lobby.loginAuth.PageLoginAuthState.Field
import com.tezov.lib_adr_sdk_core.ui.component.chunk.TextField
import com.tezov.lib_adr_sdk_core.ui.misc.FocusDispatcher
import com.tezov.lib_adr_core.type.collection.ListEntry

//TODO modifier lenght control par une validation login / password
//doit etre fait a travers le TextField.State par un Validator (cf. reprendre le travail en Java)

class PageLoginAuthFormManager(
    private var focusDispatcher: FocusDispatcher = FocusDispatcher(),
    private val textFieldValues: ListEntry<Field, TextField.State>,
) {
    init {
        textFieldValues.forEach {
            it.value.focusId = focusDispatcher.createId()
        }
    }

    @Composable
    fun compose() = focusDispatcher.compose()

    fun hideKeyboard() = focusDispatcher.hideKeyboard()

    fun requestClearFocus() = focusDispatcher.requestClearFocus()

    fun requestFocus(state: TextField.State) = state.focusId?.let {
        focusDispatcher.requestFocus(it)
    }

    fun hasFocus(state: TextField.State) = state.focusId?.let {
        focusDispatcher.hasFocus(it)
    } ?: false

    fun onChange(field: Field) {
        when (field) {
            Field.Login -> onLoginChange()
            Field.Password -> onPasswordChange()
        }
    }

    private fun onLoginChange() {
        val login = textFieldValues.getValue(Field.Login)
        val password = textFieldValues.getValue(Field.Password)
        if (login == null || password == null) {
            throw IllegalStateException("can't be null")
        }
        if (login.current.length >= PageLoginAuthState.LOGIN_LENGTH) {
            if (password.current.length < PageLoginAuthState.PASSWORD_LENGTH) {
                requestFocus(password)
            } else {
                requestClearFocus()
            }
        }
    }

    private fun onPasswordChange() {
        val login = textFieldValues.getValue(Field.Login)
        val password = textFieldValues.getValue(Field.Password)
        if (login == null || password == null) {
            throw IllegalStateException("can't be null")
        }
        if (password.current.length < PageLoginAuthState.PASSWORD_LENGTH) {
            requestFocus(password)
        } else if (login.current.length < PageLoginAuthState.LOGIN_LENGTH) {
            requestFocus(login)
        } else {
            requestClearFocus()
        }
    }

}