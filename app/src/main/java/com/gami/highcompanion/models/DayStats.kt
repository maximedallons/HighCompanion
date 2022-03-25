package com.gami.highcompanion.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "days_table")
data class DayStats(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "sql_date")
    val sqlDate: Date,
    @ColumnInfo(name = "smoked_joints")
    val smokedJoints: Int,
    @ColumnInfo(name = "spent_amount")
    val spentAmount: Float
) {
}