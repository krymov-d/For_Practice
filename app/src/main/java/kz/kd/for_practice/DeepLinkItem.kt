package kz.kd.for_practice

sealed class DeepLinkItem {
    data class AuthDeepLink(val email: String, val code: String) : DeepLinkItem()
}