package com.ananth.mvvmkotlinsample.data.local.converter

import androidx.room.TypeConverter
import com.ananth.mvvmkotlinsample.model.local.GistsEntity
import com.ananth.mvvmkotlinsample.model.local.OwnerEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @OwnerTypeConverter let room database know that mentioned types should be converted, so @Room database can understand it and store it
 * because Room database only allow certain types like string, int, bool
 * */
class OwnerTypeConverter {

    /**
     * it will read data from table and convert it to user defined types
     * @param json - value that fetched from table row
     * @return OwnerEntity - function will return as @OwnerEntity
     * */
    @TypeConverter
    fun stringToOwner(json:String):OwnerEntity{
        val gson=Gson()
        val type=object :TypeToken<OwnerEntity>(){}.type
        return if(json=="null")
            gson.fromJson("{}",type)
        else
            gson.fromJson(json,type)
    }

    /**
     * it will read data from table and convert it to user defined types
     * @param owner - OwnerEntity that will be converted as string
     * @return String - function will return as string
     * */
    @TypeConverter
    fun OwnerToString(owner:OwnerEntity?):String{
        val gson=Gson()
        val type=object :TypeToken<OwnerEntity>(){}.type
        return gson.toJson(owner,type)
    }
}