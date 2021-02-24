package com.ananth.mvvmkotlinsample.data.local.converter

import androidx.room.TypeConverter
import com.ananth.mvvmkotlinsample.model.local.RepositoryEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @RepositoryLicenseTypeConverter let room database know that mentioned types should be converted, so @Room database can understand it and store it
 * because Room database only allow certain types like string, int, bool
 * */
class RepositoryLicenseTypeConverter {

    /**
     * it will read data from table and convert it to user defined types
     * @param json - value that fetched from table row
     * @return RepositoryEntity.License - function will return as @RepositoryEntity.License
     * */
    @TypeConverter
    fun stringToLicense(json:String):RepositoryEntity.License{
        val gson=Gson()
        val type=object :TypeToken<RepositoryEntity.License>(){}.type
        return if(json=="null")
            gson.fromJson("{}",type)
        else
            gson.fromJson(json,type)
    }

    /**
     * it will read data from table and convert it to user defined types
     * @param license - RepositoryEntity.License that will be converted as string
     * @return String - function will return as string
     * */
    @TypeConverter
    fun licenseToString(license:RepositoryEntity.License?):String{
        val gson=Gson()
        val type=object :TypeToken<RepositoryEntity.License>(){}.type
        return gson.toJson(license,type)
    }

}