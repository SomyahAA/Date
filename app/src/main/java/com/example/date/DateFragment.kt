package com.example.date

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

const val DATE_KEY="date_key"

class DateFragment : Fragment(),DatePickerDialogFragment.DatePickerCallback{

    private lateinit var dateBtn: Button
    private lateinit var text:TextView
    private lateinit var date: Date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        date = Date()
    }

     val dateFormat = "yyyy / MM / dd"
    override fun onStart() {
        super.onStart()
        dateBtn.setOnClickListener {

            val args = Bundle()
            args.putSerializable(DATE_KEY,date)

            val datePicker = DatePickerDialogFragment()

            datePicker.arguments = args
            datePicker.setTargetFragment(this,0)
            datePicker.show(this.parentFragmentManager,"date picker")
        }

}

    override fun onDateSelected(date: Date) {
       this.date = date
       dateBtn.text = date.toString()


    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_date,container,false)
        init(view)


        dateBtn.apply {
            text = "Date"
        }

        return view
    }

    private fun init(view: View) {
        dateBtn = view.findViewById(R.id.date)
        text =view.findViewById(R.id.text)
    }


}