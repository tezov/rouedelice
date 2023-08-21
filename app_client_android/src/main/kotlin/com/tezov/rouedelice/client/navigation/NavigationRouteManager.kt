

package com.tezov.rouedelice.client.navigation

import com.tezov.lib_adr_app_core.navigation.NavigationController.Option
import com.tezov.lib_adr_app_core.navigation.NavigationController.Request
import com.tezov.lib_adr_app_core.navigation.NavigationRouteManager
import com.tezov.lib_adr_app_core.navigation.NavigationRouteManager.*
import com.tezov.lib_adr_app_core.navigation.bottom_navigation.BottomNavigationAction
import com.tezov.lib_adr_app_core.navigation.top_app_bar.TopAppBarAction
import com.tezov.lib_adr_app_core.ui.composition.activity.sub.snackbar.SnackbarAction
import com.tezov.lib_adr_app_core.ui.compositionTree.modal.dialog.DialogAction
import com.tezov.lib_adr_app_core.ui.compositionTree.page.PageAction

class NavigationRouteManager(
    val controller: com.tezov.lib_adr_app_core.navigation.NavigationController,
    private val snackbarAction: SnackbarAction,
) : com.tezov.lib_adr_app_core.navigation.NavigationController.Friend {

    companion object Route {

        //Command        *********************************************
        class NotHandled private constructor(val request: Request?) :
            NavigationRouteManager.Route("not_handled") {
            companion object {
                private val default = NotHandled(null)
                operator fun invoke() = default
                fun wrap(request: Request) = Request(
                    to = NotHandled(request),
                    askedBy = null
                )
            }

            override fun newInstance() = NotHandled(request = request)

            override val isReadOnly get() = this === default
        }

        //Graph        *********************************************
        //LOBBY
        object Splash : NavigationRouteManager.Route("splash")
        object Lounge : NavigationRouteManager.Route("lounge")
        object NavLobby : Routes(
            "navLobby",
            child = setOf(Splash, Lounge)
        )

        //AUTH
        object Shop : NavigationRouteManager.Route("shop")
        object Cart : NavigationRouteManager.Route("cart")
        object Check : NavigationRouteManager.Route("check")
        object Menu : NavigationRouteManager.Route("menu")
        object NavAuth : Routes(
            "navAuth",
            child = setOf(Shop, Cart, Check, Menu)
        )

        val startNavRoute = NavAuth
        val startLobbyRoute = Splash
        val startAuthRoute = Shop

    }

    init {
        controller.routes(this@NavigationRouteManager).apply {
            add(NavLobby)
            add(NavAuth)
            add(NotHandled())
        }
        controller.addRequestHandler(
            this@NavigationRouteManager,
            mapOf(
                TopAppBarAction::class to this::navigateFromTopAppBar,
                BottomNavigationAction::class to this::navigateFromBottomNavigation,
                PageAction::class to this::navigateFromPage,
                DialogAction::class to this::navigateFromDialog,
            )
        )
        controller.setRequestExceptionHandler(
            this@NavigationRouteManager,
            this::navigateException,
        )
        controller.setRequestFeedbackHandler(
            this@NavigationRouteManager,
            this::navigateFeedback,
        )
    }

    private fun navigateFeedback(request: Request) {
         (request.to as? NavigationRouteManager.Route.RequestFeedback)?.let {
            //navigation is busy, request was refused
        }
    }

    private fun navigateException(request: Request?) {
        request?.let {
            (request.to as? NotHandled)?.request?.takeIf { it.to is NavigationRouteManager.Route.NotImplemented }?.let {
                return navigateException(it)
            }
            (request.to as? NavigationRouteManager.Route.NotImplemented)?.let {
                snackbarAction.showNotImplemented(it.message)
            } ?: (request.to as? NotHandled)?.let {
                snackbarAction.show("forget to handle route from ${it.request?.from?.path} to ${it.request?.to?.path}")
            }
        } ?: kotlin.run {
            snackbarAction.showNotImplemented()
        }
    }

    private fun navigateFromTopAppBar(request: Request) {
        with(controller) {
            var failedToNavigate = true
            when (request.to) {
                is NavigationRouteManager.Route.Back -> {
                    navigateBack(
                        this@NavigationRouteManager,
                        request = request
                    )
                    failedToNavigate = false
                }
            }
            if (failedToNavigate) {
                navigateException(NotHandled.wrap(request))
            }
        }
    }

    private fun navigateFromBottomNavigation(request: Request) {
        with(controller) {
            navigate(
                this@NavigationRouteManager,
                request = request.apply {
                    option = option ?: Option.SingleTop(request.to)
                }
            )
        }
    }

    private fun navigateFromPage(request: Request) {
        with(controller) {
            var failedToNavigate = true
            when (request.from) {
                //LOBBY
                Splash -> {
                    when (request.to) {
                        Lounge -> {
                            navigate(
                                this@NavigationRouteManager,
                                request = request.apply {
                                    option = option ?: Option.ClearStack()
                                }
                            )
                            failedToNavigate = false
                        }
                    }
                }
            }
            if (failedToNavigate) {
                navigateException(NotHandled.wrap(request))
            }
        }
    }

    private fun navigateFromDialog(request: Request) {
        with(controller) {
            var failedToNavigate = true
            when (request.from) {
                Shop, Cart, Check, Menu  -> {
                    when (request.to) {
                        is NavigationRouteManager.Route.Finish -> {
                            navigate(
                                this@NavigationRouteManager,
                                request
                            )
                            failedToNavigate = false
                        }
                    }
                }
            }
            if (failedToNavigate) {
                navigateException(NotHandled.wrap(request))
            }
        }
    }

}




