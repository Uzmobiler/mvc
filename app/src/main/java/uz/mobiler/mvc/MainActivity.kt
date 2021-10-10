package uz.mobiler.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import uz.mobiler.mvc.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), Observer, View.OnClickListener {

    var myModel: Model? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myModel = Model()
        myModel?.addObserver(this)

        binding.apply {
            button.setOnClickListener(this@MainActivity)
            button2.setOnClickListener(this@MainActivity)
            button3.setOnClickListener(this@MainActivity)
        }
    }

    override fun update(p0: Observable?, p1: Any?) {
        binding.button.text = "Count: " + myModel?.getValueAtIndex(0)
        binding.button2.text = "Count: " + myModel?.getValueAtIndex(1)
        binding.button3.text = "Count: " + myModel?.getValueAtIndex(2)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button -> myModel?.setValueAtIndex(0)
            R.id.button2 -> myModel?.setValueAtIndex(1)
            R.id.button3 -> myModel?.setValueAtIndex(2)
        }
    }
}