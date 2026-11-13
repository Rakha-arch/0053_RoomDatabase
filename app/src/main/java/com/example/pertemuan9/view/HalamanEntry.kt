package com.example.pertemuan9.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pertemuan9.R
import com.example.pertemuan9.uicontroller.DestinasiNavigasi
import com.example.pertemuan9.uicontroller.SiswaTopAppBar
import com.example.pertemuan9.viewmodel.DetailSiswa
import com.example.pertemuan9.viewmodel.EntryViewModel
import com.example.pertemuan9.viewmodel.PenyediaViewModel
import com.example.pertemuan9.viewmodel.UIStateSiswa
import kotlinx.coroutines.launch

object DestinasiEntry : DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = R.string.app_name
}



