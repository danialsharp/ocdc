package com.example.ocdworld

object DevMode {
    private const val PREFS = "dev_prefs"
    private const val KEY = "isTherapistMode"

    fun get(ctx: android.content.Context): Boolean =
        ctx.getSharedPreferences(PREFS, android.content.Context.MODE_PRIVATE)
            .getBoolean(KEY, false)

    fun set(ctx: android.content.Context, value: Boolean) {
        ctx.getSharedPreferences(PREFS, android.content.Context.MODE_PRIVATE)
            .edit().putBoolean(KEY, value).apply()
    }
}