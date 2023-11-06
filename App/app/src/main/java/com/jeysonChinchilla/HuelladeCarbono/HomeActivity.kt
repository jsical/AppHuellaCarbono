package com.jeysonChinchilla.HuelladeCarbono

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics

class HomeActivity : AppCompatActivity() {

    private val GOOGLE_SIGN_IN = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        //Theme
        setTheme(R.style.Base_Theme_AplicaciónHuelladeCarbono)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Eventos Analytics
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración Firebase Completa")
        analytics.logEvent("InitScreen",bundle)

        //Registrar con Email
        val goRegisterActivity = findViewById<ImageButton>(R.id.imageButtonEmail)
        goRegisterActivity.setOnClickListener{
            goToRegister()
        }

        //Ingresar como Invitado
        val goInvitadoActivity = findViewById<Button>(R.id.buttonInvitado)
        goInvitadoActivity.setOnClickListener{
            goToInvitado()
        }

        /*//Acceso Google
        val loginGoogle = findViewById<ImageButton>(R.id.imageButtonGoogle)
        loginGoogle.setOnClickListener{
            //Configuración
            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            val googleClient = GoogleSignIn.getClient(this, googleConf)

            startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)

        }*/


    }

    private fun goToRegister(){
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)

    }

    private fun goToInvitado(){
        val i = Intent(this, InvitadoActivity::class.java)
        startActivity(i)

    }

    private fun goToDatos(){
        val i = Intent(this, ElectricidadActivity::class.java)
        startActivity(i)

    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == GOOGLE_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val account = task.getResult(ApiException::class.java)

            if(account != null){
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                FirebaseAuth.getInstance().signInWithCredential(credential)

                if (it.isSuccessful){
                    goToDatos(account.email?:"", ProviderType.GOOGLE)
                }else{
                    showAlert()
                }

            }

        }


    }*/

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}