package com.example.date

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import java.util.*


class DatePickerDialogFragment : DialogFragment() {

    interface DatePickerCallback{
        fun onDateSelected(date: Date)
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val date = arguments?.getSerializable(DATE_KEY) as Date

        val calendar = Calendar.getInstance()
        calendar.time = date
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)


        val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->

            val resultDate = GregorianCalendar(year,month,day).time

            targetFragment?.let {

                ( it as DatePickerCallback ).onDateSelected(resultDate)

            }
        }

        return DatePickerDialog(
            requireContext(),
            dateListener,
            year,
            month,
            day
        )

    }

}