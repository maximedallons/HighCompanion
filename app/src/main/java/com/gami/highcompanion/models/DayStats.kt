package com.gami.highcompanion.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "days_table")
data class DayStats(
    @PrimaryKey()
    @ColumnInfo(name = "sql_date")
    val sqlDate: LocalDate,
    @ColumnInfo(name = "smoked_joints")
    val smokedJoints: Double,
    @ColumnInfo(name = "spent_amount")
    val spentAmount: Double
) {
}