package br.com.vinicidesu.estacaohack

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import br.com.vinicidesu.estacaohack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cardprinMain = AnimationUtils.loadAnimation(this, R.anim.cardprinmain)
        val cardprinm = binding.cardprinmain
        cardprinm.startAnimation(cardprinMain)

        val txvtitmain = AnimationUtils.loadAnimation(this, R.anim.txvtitulomain)
        val txvtitulomain = binding.txvTitulo
        txvtitulomain.startAnimation(txvtitmain)

        val txvresultmain = AnimationUtils.loadAnimation(this, R.anim.txvresultadomain)
        val txvresultadomain = binding.txvResultadoMain
        txvresultadomain.startAnimation(txvresultmain)

        val txvclassificmain = AnimationUtils.loadAnimation(this, R.anim.txvclassificacaomain)
        val txvclassificacaomain = binding.txvClassificacaoMain
        txvclassificacaomain.startAnimation(txvclassificmain)

        val txvalturmain = AnimationUtils.loadAnimation(this, R.anim.txvalturamain)
        val txvalturamain = binding.txvAlturaMain
        txvalturamain.startAnimation(txvalturmain)

        val txvpesmain = AnimationUtils.loadAnimation(this, R.anim.txvpesomain)
        val txvpesomain = binding.txvPesoMain
        txvpesomain.startAnimation(txvpesmain)

        val edtalturmain = AnimationUtils.loadAnimation(this, R.anim.edtalturamain)
        val edtalturamain = binding.edtAlturaMain
        edtalturamain.startAnimation(edtalturmain)

        val edtpesmain = AnimationUtils.loadAnimation(this, R.anim.edtpesomain)
        val edtpesomain = binding.edtPesoMain
        edtpesomain.startAnimation(edtpesmain)

        val btncalcmain = AnimationUtils.loadAnimation(this, R.anim.btncalcularmain)
        val btncalcularmain = binding.btnCalcularMain
        btncalcularmain.startAnimation(btncalcmain)

        val imvcard1 = AnimationUtils.loadAnimation(this, R.anim.imvcard1main)
        val imvcard1m = binding.imvcard1main
        imvcard1m.startAnimation(imvcard1)

        val imvcard2 = AnimationUtils.loadAnimation(this, R.anim.imvcard2main)
        val imvcard2m = binding.imvcard2main
        imvcard2m.startAnimation(imvcard2)

        val imvcard3 = AnimationUtils.loadAnimation(this, R.anim.imvcard3main)
        val imvcard3m = binding.imv3cardmain
        imvcard3m.startAnimation(imvcard3)

        val btnfit = AnimationUtils.loadAnimation(this, R.anim.btnfitmain)
        val btnfitm = binding.btnfit
        btnfitm.startAnimation(btnfit)

        val imvunder = AnimationUtils.loadAnimation(this, R.anim.imvunderarmour)
        val imvundera = binding.imvunderarmour
        imvundera.startAnimation(imvunder)

        val pesoRegistrado = binding.edtPesoMain
        val alturaRegistrado = binding.edtAlturaMain
        val botao = binding.btnCalcularMain

        botao.setOnClickListener {

            val peso = pesoRegistrado.text.toString().toDouble()
            val altura = alturaRegistrado.text.toString().toDouble()
            val resultado = peso/(altura*altura)
            binding.txvResultadoMain.text = resultado.toString()

            if (resultado >= 18.5 && resultado <= 24.99) {
                binding.txvClassificacaoMain.text = "Peso Normal"
            }else if (resultado >= 25 && resultado <= 29.99) {
                binding.txvClassificacaoMain.text = "Sobrepeso"
            }else if (resultado >= 30 && resultado <= 39.99) {
                binding.txvClassificacaoMain.text = "Obesidade"
            }else if (resultado >= 40) {
                binding.txvClassificacaoMain.text = "Obesidade Grave"
            }else if (resultado < 18.5) {
                binding.txvClassificacaoMain.text = "Magreza"
            }

        }

        binding.btnfit.setOnClickListener {
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }
    }
}