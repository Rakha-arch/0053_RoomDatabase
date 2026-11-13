package com.example.pertemuan9.repositori

import android.content.Context

interface ContainerApp {
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(private val context: Context) : ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        RepositoriSiswa()
    }
}