package com.example.pertemuan9

import android.app.Application
import com.example.pertemuan9.repositori.ContainerApp
import com.example.pertemuan9.repositori.ContainerDataApp

class AplikasiSiswa : Application() {
    lateinit var container: ContainerApp
        private set

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}
