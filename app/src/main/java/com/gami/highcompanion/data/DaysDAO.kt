package com.gami.highcompanion.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gami.highcompanion.models.DayStats

@Dao
interface DaysDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addDay(dayStats: DayStats)

    @Query("UPDATE days_table SET smoked_joints = smoked_joints + :smokedJoints WHERE sql_date = DATE('now')")
    fun addSmokedJoint(smokedJoints: Double)

    @Query("UPDATE days_table SET smoked_joints = smoked_joints - :smokedJoints WHERE sql_date = DATE('now')")
    fun substractSmokedJoint(smokedJoints: Double)

    @Query("UPDATE days_table SET smoked_joints = 0 WHERE sql_date = DATE('now')")
    fun resetSmokedJoints()

    @Query("SELECT * FROM days_table where sql_date = DATE('now')")
    fun getDay(): LiveData<DayStats>


    @Query("SELECT smoked_joints FROM days_table where sql_date = DATE('now')")
    fun getDailySmokedJoints(): LiveData<Double>

    @Query("SELECT SUM(smoked_joints) FROM days_table WHERE sql_date > DATE('now', '-8 day')")
    fun getWeeklySmokedJoints(): LiveData<Double>

    @Query("SELECT SUM(smoked_joints) FROM days_table WHERE sql_date > DATE('now','-1 month', '-1 day')")
    fun getMonthlySmokedJoints(): LiveData<Double>

    @Query("UPDATE days_table SET spent_amount = spent_amount + :spentMoney WHERE sql_date = DATE('now')")
    fun addSpentMoney(spentMoney: Double)

    @Query("UPDATE days_table SET spent_amount = spent_amount - :spentMoney WHERE sql_date = DATE('now')")
    fun substractSpentMoney(spentMoney: Double)

    @Query("SELECT spent_amount FROM days_table where sql_date = DATE('now')")
    fun getDailySpentAmount(): LiveData<Double>

    @Query("SELECT SUM(spent_amount) FROM days_table WHERE sql_date > DATE('now', '-8 day')")
    fun getWeeklySpentAmount(): LiveData<Double>

    @Query("SELECT SUM(spent_amount) FROM days_table WHERE sql_date > DATE('now','-1 month', '-1 day')")
    fun getMonthlySpentAmount(): LiveData<Double>
}