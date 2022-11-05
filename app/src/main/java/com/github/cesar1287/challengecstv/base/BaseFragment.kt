package com.github.cesar1287.challengecstv.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.github.cesar1287.challengecstv.utils.Command

abstract class BaseFragment : Fragment() {

    abstract var command: MutableLiveData<Command>
}