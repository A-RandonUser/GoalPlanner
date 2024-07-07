package com.example.mygoalplanner.data

data class Goal(
    val id: Long = 0L,
    val title:String ="",
    val description:String= ""
)

object DummyGoals{
    val goalList = listOf(
        Goal(title = "Meze Empyreans 2", description = "Best Headset money can buy"),
        Goal(title = "Karambit gamma doppler", description = "a knife skin for cs2 "),
        Goal(title = "Trip to japan", description = "a 2 week long trip to japan to all the famous places"),
        Goal(title = "A Stable job as an android dev", description = "dream job"),
        Goal(title = "Razer Cobra pro", description = "new razer gaming mouse")
    )
}
