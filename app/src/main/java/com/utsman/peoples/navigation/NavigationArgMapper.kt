package com.utsman.peoples.navigation

import android.net.Uri
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.utsman.peoples.data.model.People
import java.lang.reflect.Type

object NavigationArgMapper {

    private val peopleType: Type
        get() = object : TypeToken<People>() {}.type


    fun peopleToNavArg(people: People): String {
        val json = Gson().toJson(people, peopleType)
        return Uri.encode(json)
    }

    fun peopleFromJson(json: String): People {
        return Gson().fromJson(json, peopleType)
    }
}