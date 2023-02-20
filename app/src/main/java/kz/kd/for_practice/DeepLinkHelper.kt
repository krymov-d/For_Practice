package kz.kd.for_practice

import android.net.Uri

private const val AUTH_PATH = "/auth"
private const val AUTH_EMAIL = "email"
private const val AUTH_CODE = "code"

object DeepLinkHelper {
    fun getItemByUri(link: Uri): DeepLinkItem? =
        when (link.path) {
            AUTH_PATH -> DeepLinkItem.AuthDeepLink(
                getParameter(AUTH_EMAIL, link),
                getParameter(AUTH_CODE, link)
            )
            else -> null
        }

    private fun getParameter(name: String, link: Uri) = link.getQueryParameter(name) ?: ""
}