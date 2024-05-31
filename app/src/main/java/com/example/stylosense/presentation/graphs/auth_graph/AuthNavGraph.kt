package com.example.stylosense.presentation.graphs

import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.stylosense.presentation.screens.forget_password_screen.component.ForgetPasswordScreen
import com.example.stylosense.presentation.graphs.auth_graph.AuthScreen
import com.example.stylosense.presentation.screens.on_boarding_screen.component.SplashScreen
import com.example.stylosense.presentation.screens.otp_screen.component.OTPScreen
import com.example.stylosense.presentation.screens.sign_in_screen.component.LoginScreen
import com.example.stylosense.presentation.screens.sign_success_screen.component.SignInScreen
import com.example.stylosense.presentation.screens.sign_up_screen.component.SignUpScreen


fun NavGraphBuilder.authNavGraph(navController: NavHostController, context: Context) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.OnBoardingScreen.route
    ) {
        composable(AuthScreen.OnBoardingScreen.route) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                (context as Activity).window.decorView.windowInsetsController?.hide(
                    WindowInsets.Type.statusBars()
                );
            } else {
                (context as Activity).window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
                )
            }
            SplashScreen(navController)

            Log.d("Navigation Call", "Called Splash Screen")
        }
        composable(AuthScreen.SignInScreen.route) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                (context as Activity).window.decorView.windowInsetsController?.show(
                    WindowInsets.Type.statusBars()
                );
            } else {
                (context as Activity).window.apply {
                    clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                    clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                }

            }
            LoginScreen(navController = navController)
        }
        composable(AuthScreen.ForgetPasswordScreen.route) {
            ForgetPasswordScreen(navController = navController)
        }
        composable(AuthScreen.OTPScreen.route) {
            OTPScreen(navController = navController)
        }
        composable(AuthScreen.SignUpScreen.route) {
            SignUpScreen(navController = navController)
        }
        composable(AuthScreen.SignInSuccess.route) {
            SignInScreen(navController = navController)
        }

    }
}