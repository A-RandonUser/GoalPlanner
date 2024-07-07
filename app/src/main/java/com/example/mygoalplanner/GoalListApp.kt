package com.example.mygoalplanner

import android.app.Application

class GoalListApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}