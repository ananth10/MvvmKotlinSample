package com.ananth.mvvmkotlinsample.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @Converters let room database know that mentioned types should be converted, so @Room database can understand it and store it
 * because Room database only allow certain types like string, int, bool
 * */
class Converters {

    /**
     * it will read data from table and convert it to user defined types
     * @param json - value that fetched from table row
     * @return List<String> - function will return as List<String>
     * */
    @TypeConverter
    fun fromStringToArrayList(json:String):List<String>{
       val listType=object : TypeToken<List<String>>(){}.type
        return Gson().fromJson(json,listType)
    }

    /**
     * it will read data from table and convert it to user defined types
     * @param list - list that will be converted as string
     * @return String - function will return as string
     * */
   @TypeConverter
    fun fromArrayListToString(list:List<String>):String{
        val gson=Gson()
        return gson.toJson(list)
    }
}