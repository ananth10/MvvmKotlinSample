package com.ananth.mvvmkotlinsample.data.local.converter

import androidx.room.TypeConverter
import com.ananth.mvvmkotlinsample.model.local.GistsEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @GistsFileTypeConverter let room database know that mentioned types should be converted, so @Room database can understand it and store it
 * because Room database only allow certain types like string, int, bool
 * */
class GistsFileTypeConverter {

    /**
     * it will read data from table and convert it to user defined types
     * @param json - value that fetched from table row
     * @return GistsEntity.Files - function will return as @GistsEntity.Files
     * */
    @TypeConverter
    fun stringToFile(json:String):GistsEntity.Files{
        val gson=Gson()
        val type=object :TypeToken<GistsEntity.Files>(){}.type
        return if(json=="null")
            gson.fromJson("{}",type)
        else
            gson.fromJson(json,type)
    }

    /**
     * it will read data from table and convert it to user defined types
     * @param file - file that will be converted as string
     * @return String - function will return as string
     * */
    @TypeConverter
    fun fileToString(file:GistsEntity.Files?):String{
        val gson=Gson()
        val type=object :TypeToken<GistsEntity.Files>(){}.type
        return gson.toJson(file,type)
    }
}