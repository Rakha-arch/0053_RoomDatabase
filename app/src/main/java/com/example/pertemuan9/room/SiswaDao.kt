package com.example.pertemuan9.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SiswaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(siswa: Siswa)

    @Query("SELECT * FROM tblSiswa WHERE id = :id")
    fun getSiswa(id: Int): Flow<Siswa>

    @Query("SELECT * FROM tblSiswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List<Siswa>>

    @Delete
    suspend fun delete(siswa: Siswa)

    @Update
    suspend fun update(siswa: Siswa)
}
