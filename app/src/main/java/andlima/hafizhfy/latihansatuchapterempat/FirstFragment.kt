package andlima.hafizhfy.latihansatuchapterempat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nama = et_nama.text

        btn_show_toast.setOnClickListener {
            Toast.makeText(requireContext(), "Selamat datang, $nama!", Toast.LENGTH_LONG).show()
        }

        btn_show_snackbar.setOnClickListener {
            val aksi = Snackbar.make(it, "Pindah halaman?", Snackbar.LENGTH_INDEFINITE)
            aksi.setAction("Pindah") {
                val data = bundleOf("NAMA" to et_nama.text.toString())
                Navigation.findNavController(view).navigate(
                    R.id.action_firstFragment_to_secondFragment,
                    data
                )
            }
            aksi.show()
        }
    }
}