package com.jeysonChinchilla.HuelladeCarbono

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class ElectricidadActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    //Ventilador
    private lateinit var swVentilador: SwitchCompat
    private lateinit var gpVentilador: RadioGroup
    private lateinit var textVentilador: TextView
    private lateinit var radioBmenosde1: RadioButton
    private lateinit var radioB1a3: RadioButton
    private lateinit var radioB4a5: RadioButton
    private lateinit var radioBOtroVentilador: RadioButton
    private lateinit var editTextOtroVentilador: EditText
    /*lateinit var swBombaAgua: SwitchCompat
    lateinit var swAireAcondicionado: SwitchCompat
    lateinit var swSecadora: SwitchCompat
    lateinit var swReproductorDVD: SwitchCompat
    lateinit var swComputadora: SwitchCompat
    lateinit var swRadio: SwitchCompat
    lateinit var swTelevisor: SwitchCompat
    lateinit var swPlancha: SwitchCompat
    lateinit var swLavadora: SwitchCompat
    lateinit var swCalentador: SwitchCompat
    lateinit var swMaquinaCoser: SwitchCompat
    lateinit var swTostadorPan: SwitchCompat
    lateinit var swCafetera: SwitchCompat
    lateinit var swRefrigerador: SwitchCompat
    lateinit var swMicroondas: SwitchCompat
    lateinit var swLicuadora: SwitchCompat
    lateinit var swBombillaAhorra: SwitchCompat
    lateinit var swBombillaIncandi: SwitchCompat*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electricidad)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_nav, R.string.close_nav)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)


        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        swVentilador = findViewById(R.id.swVentilador)
        gpVentilador = findViewById(R.id.gpVentilador)
        textVentilador = findViewById(R.id.textVentilador)
        radioBOtroVentilador = findViewById(R.id.radioBOtroVentilador)
        editTextOtroVentilador = findViewById(R.id.editTextOtroVentilador)
        swVentilador.setOnCheckedChangeListener { swVentilador, b ->
            if (swVentilador.isChecked){
                gpVentilador.visibility = View.VISIBLE
                textVentilador.visibility = View.VISIBLE
            }else{
                gpVentilador.visibility = View.GONE
                textVentilador.visibility = View.VISIBLE
            }
        }
        radioBOtroVentilador.setOnCheckedChangeListener { rBOtroVentilador, b ->
            if (rBOtroVentilador.isChecked){
                editTextOtroVentilador.visibility = View.VISIBLE
            }else{
                editTextOtroVentilador.visibility = View.GONE
                
            }
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_item_one -> Toast.makeText(this, "Consumo Electrico", Toast.LENGTH_SHORT).show()
            R.id.nav_item_two -> {
                Toast.makeText(this, "Consumo Combustible", Toast.LENGTH_SHORT).show()
                val i = Intent(this, CombustibleActivity::class.java)
                startActivity(i)
            }
            R.id.nav_item_three -> {
                Toast.makeText(this, "Desechos", Toast.LENGTH_SHORT).show()
                val i = Intent(this, DesechosActivity::class.java)
                startActivity(i)
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}