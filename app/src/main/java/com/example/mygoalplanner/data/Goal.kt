package com.example.mygoalplanner.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "goal-table")
data class Goal(
    //when you auto generate it it increments by 1 and in case you delete
    //if u delete item 3 and add new item it will be item 4 not item 3
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name="goal-title")
    val title:String ="",
    @ColumnInfo(name="goal-description")
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
