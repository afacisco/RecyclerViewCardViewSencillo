package com.juanfra.recyclerviewcardviewsencillo.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juanfra.recyclerviewcardviewsencillo.R
import com.juanfra.recyclerviewcardviewsencillo.adapter.Adapter

/*
Autor: Juan Francisco Sánchez González
Fecha: 21/11/2024
Clase: Actividad principal con un listado (RecyclerView y CardView) de textos. Cada elemento de la
lista será solo un campo TextView. Se utiliza un adaptador personalizado para el listado y se controla
el Click sobre cada elemento (gestionando el evento sobre el control CardView).
 */

class MainActivity : AppCompatActivity() {

    // Control RecyclerView
    lateinit var rcv: RecyclerView

    // Adaptador listado
    lateinit var adapter: Adapter

    // Estructura que almacena los textos del listado
    var listTextos = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Empezamos con nuestra lógica
        initUi()
    }

    // Inicializamos todos nuestros componentes
    private fun initUi() {
        initDatos()
        initRecyclerView()
    }

    // Asignamos los textos a la estructura de datos
    private fun initDatos() {
        listTextos = resources.getStringArray(R.array.string_datos).toMutableList()
    }

    // Inicaliza el RecyclerView
    private fun initRecyclerView() {
        rcv = findViewById(R.id.recyclerview)
        // Asignamos tipo de layout y adaptador al RecyclerView
        rcv.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(listTextos) { position -> mostrarPos(position) }
        rcv.adapter = adapter
    }

    // Método que se lanza al hacer click en uno de los elementos del listado
    private fun mostrarPos(position: Int) {
        Toast.makeText(this, getString(R.string.toast_text, listTextos[position]), Toast.LENGTH_LONG).show()
    }
}