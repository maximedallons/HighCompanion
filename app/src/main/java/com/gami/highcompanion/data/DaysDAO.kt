package com.gami.highcompanion.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gami.highcompanion.models.DayStats

@Dao
interface DaysDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addDay(dayStats: DayStats)

    @Update(entity = DayStats::class)
    fun updateDay(dayStats: DayStats)


    @Query("SELECT smoked_joints FROM days_table where sql_date = DATE('now')")
    fun getDailySmokedJoints(): LiveData<Int>

    @Query("SELECT SUM(smoked_joints) FROM days_table WHERE sql_date > DATE('now', '-8 day')")
    fun getWeeklySmokedJoints(): LiveData<Int>

    @Query("SELECT SUM(smoked_joints) FROM days_table WHERE sql_date > DATE('now','-1 month', '-1 day')")
    fun getMonthlySmokedJoints(): LiveData<Int>


    @Query("SELECT spent_amount FROM days_table where sql_date = DATE('now')")
    fun getDailySpentAmount(): LiveData<Float>

    @Query("SELECT SUM(spent_amount) FROM days_table WHERE sql_date >= DATE('now', 'weekday 0', '-7 days')  AND sql_date != DATE('now')  AND sql_date != DATE('now','-1 day')")
    fun getWeeklySpentAmount(): LiveData<Float>

    @Query("SELECT SUM(spent_amount) FROM days_table where strftime('%W',sql_date) != strftime('%W',date('now')) AND strftime('%Y',sql_date) = strftime('%Y',date('now')) AND  strftime('%m',sql_date) = strftime('%m',date('now')) AND sql_date != DATE('now', 'weekday 0', '-7 days')  AND sql_date != DATE('now')  AND sql_date != DATE('now','-1 day')")
    fun getMonthlySpentAmount(): LiveData<Float>
}