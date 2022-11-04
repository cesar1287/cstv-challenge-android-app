package com.github.cesar1287.challengecstv.utils

sealed class Command {
    class Loading(val value: Boolean): Command()
    class Error(val error: Int? = null): Command()
}